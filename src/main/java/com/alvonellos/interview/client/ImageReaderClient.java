package com.alvonellos.interview.client;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

@Service
@Log
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ImageReaderClient {
    private final RestTemplate restTemplate;

    public BufferedImage getJpgImageFromUrl(String imageUrl) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.IMAGE_JPEG));

        ResponseEntity<byte[]> responseEntity =
                restTemplate.exchange(imageUrl, HttpMethod.GET, new HttpEntity<>(headers), byte[].class);

        byte[] imageBytes = responseEntity.getBody();
        if (imageBytes == null) {
            return null;
        }

        return ImageIO.read(new ByteArrayInputStream(imageBytes));
    }

    public static byte[] bufferedImageToBytes(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        baos.flush();
        byte[] imageBytes = baos.toByteArray();
        baos.close();
        return imageBytes;
    }
}

