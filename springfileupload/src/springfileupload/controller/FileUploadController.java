package springfileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springfileupload.constant.FileuploadConstant;
import springfileupload.util.Thumbnail;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    private final ServletContext servletContext;

    public FileUploadController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @GetMapping({"/", "/fileuploadForm"})
    public String form(Model model, HttpServletRequest request) {
        String uploadRoot = getUploadRoot();
        File root = new File(uploadRoot);
        if (!root.exists()) root.mkdirs();

        List<String> files = new ArrayList<>();
        File[] list = root.listFiles();
        if (list != null) {
            for (File f : list) {
                if (f.isFile()) {
                    files.add("/uploadfiles/" + f.getName());
                }
            }
        }
        model.addAttribute("files", files);
        return "fileuploadForm";
    }

    @PostMapping("/fileuploadProc")
    public String upload(@RequestParam("files") List<Part> parts, Model model, HttpServletRequest request) throws Exception {
        
    	String uploadRoot = getUploadRoot();
        File root = new File(uploadRoot);
        if (!root.exists()) root.mkdirs();

        List<UploadResult> results = new ArrayList<>();

        for (Part part : parts) {
            if (part == null || part.getSize() == 0) continue;

            // Security: sanitize submitted file name and force UUID
            String submitted = getSubmittedFileName(part);
            String ext = getExtension(submitted);
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String safeName = uuid + (ext.isEmpty() ? "" : "." + ext.toLowerCase());

            // Store original
            Path target = Path.of(uploadRoot, safeName);
            try (InputStream in = part.getInputStream()) {
                Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
            }

            // If image -> generate thumbnail
            String contentType = part.getContentType();
            String thumbName = null;
            if (contentType != null && contentType.startsWith("image/")) {
                thumbName = uuid + "_thumb." + (ext.isEmpty() ? "jpg" : ext.toLowerCase());
                Path thumbTarget = Path.of(uploadRoot, thumbName);
                try {
                    Thumbnail.makeThumbnail(
                		target.toFile(), 
                		thumbTarget.toFile(), 
                		FileuploadConstant.THUMBNAIL_WIDTH,
                		FileuploadConstant.THUMBNAIL_HEIGHT
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                    thumbName = null;
                }
            }
            results.add(new UploadResult(submitted, "/uploadfiles/" + safeName, 
            	thumbName == null ? null : "/uploadfiles/" + thumbName));
        }

        model.addAttribute("results", results);
        return "fileuploadResult";
    }

    private String getUploadRoot() {
        String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        File dated = new File(FileuploadConstant.FILE_UPLOAD_REAL_PATH, "uploadfiles");
        if (!dated.exists()) dated.mkdirs();
        return dated.getAbsolutePath();
    }

    private static String getSubmittedFileName(Part part) {
        String header = part.getHeader("content-disposition");
        if (header == null) return "unknown";
        for (String cd : header.split(";")) {
            cd = cd.trim();
            if (cd.startsWith("filename")) {
                String fn = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fn.replace("\\", "/").substring(fn.lastIndexOf('/') + 1);
            }
        }
        return "unknown";
    }

    private static String getExtension(String filename) {
        int idx = filename.lastIndexOf('.');
        return (idx == -1) ? "" : filename.substring(idx + 1);
    }

    // DTO innerclass
    public static class UploadResult {
        public String originalName;
        public String url;
        public String thumbUrl;
        public UploadResult(String originalName, String url, String thumbUrl) {
            this.originalName = originalName;
            this.url = url;
            this.thumbUrl = thumbUrl;
        }
        public String getOriginalName() { return originalName; }
        public String getUrl() { return url; }
        public String getThumbUrl() { return thumbUrl; }
    }
}
