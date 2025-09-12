package springfileupload.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import springfileupload.constant.FileuploadConstant;

@Controller
public class FiledownloadController {


    @GetMapping("/filedownload/{filename}")
    public void filedownload(@PathVariable String filename, HttpServletResponse res) 
    	throws IOException {
    		
		Path path = Paths.get(FileuploadConstant.FILE_UPLOAD_REAL_PATH + "/uploadfiles/", filename);
	
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment; filename=\"" 
				+ URLEncoder.encode(filename, StandardCharsets.UTF_8));
		
		Files.copy(path, res.getOutputStream());
		
		res.flushBuffer();
		
    }
    
	
}





















