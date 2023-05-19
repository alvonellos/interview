package com.alvonellos.interview.client;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.imageio.ImageIO;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ImageClientTest extends AbstractTestNGSpringContextTests {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ImageReaderClient imageClient;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(enabled = false)
    public void testGetImageFromUrl() throws IOException {
        // create mock response with a JPEG image
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "image/jpeg");
        byte[] imageData = new byte[] {(byte) 0xff, (byte) 0xd8, (byte) 0xff, (byte) 0xe0, 0x00, 0x10, 0x4a, 0x46, 0x49, 0x46, 0x00, 0x01};
        ResponseEntity<byte[]> response = new ResponseEntity<>(imageData, headers, HttpStatus.OK);

        // mock restTemplate exchange method to return the mock response
        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(byte[].class)))
                .thenReturn(response);

        // call the getImageFromUrl method and verify the result
        String imageUrl = "https://example.com/image.jpg";
        BufferedImage image = imageClient.getJpgImageFromUrl(imageUrl);
        Assert.assertNotNull(image);
        Assert.assertEquals(image.getWidth(), 1);
        Assert.assertEquals(image.getHeight(), 1);
        Assert.assertEquals(image.getRGB(0, 0), 0xffd8ff);
    }
}
