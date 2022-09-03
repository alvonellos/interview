package com.alvonellos.interview.util.images;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

public class RandomImage {
    private static RandomImage instance = null;

    private RandomImage() {
    }

    public static RandomImage getInstance() {
        if (instance == null) {
            instance = new RandomImage();
        }
        return instance;
    }

    private static BufferedImage generateRandomImage(int width, int height) {
        SecureRandom random = new SecureRandom();
        ImagePlus imp = IJ.createImage("Random Image", "rgb", width, height, 1);
        ImageProcessor imageProcessor = imp.getProcessor();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                imageProcessor.putPixel(x, y, new int[]{
                        random.nextInt(256), random.nextInt(256), random.nextInt(256)
                });
            }
        }
        return imp.getBufferedImage();
    }

    public static byte[] getImage(int width, int height) throws IOException {
        BufferedImage image =  generateRandomImage(width, height);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image, "png", output);
        return output.toByteArray();
    }
}
