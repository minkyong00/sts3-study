package springfileupload.util;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Thumbnail {

    public static void makeThumbnail(File input, File output, int width, int height) throws Exception {
       
        BufferedImage img = ImageIO.read(input);
        if (img == null) throw new IllegalArgumentException("Unsupported image: " + input.getName());

        Thumbnails.of(input)
                .size(width, height)
                .outputQuality(0.9f)
                .toFile(output);
    }
}
