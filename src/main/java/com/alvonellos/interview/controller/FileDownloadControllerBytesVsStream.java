package com.alvonellos.interview.controller;

import lombok.extern.java.Log;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * I wanted to find out the performance differences between two methods:
 *  1). Downloading using bytes
 *  2). Downloading using streams
 *
 *  So I wrote this class to test the performance differences between the two methods.
 *
 *  Please see the unit tests for a detailed comparison.
 */
@Log
@RestController
public class FileDownloadControllerBytesVsStream {
    public static class RandomByteArrayInputStream extends InputStream {
        private final long length;
        private final Random random = new Random();
        private long bytesRead = 0;

        public RandomByteArrayInputStream(long length) {
            this.length = length;
        }

        @Override
        public int read() throws IOException {
            if (bytesRead < length) {
                bytesRead++;
                return random.nextInt(256); // Generating a random byte (0 to 255)
            } else {
                return -1; // Signal the end of the stream
            }
        }
    }

    @GetMapping("/downloadBytes")
        public ResponseEntity<byte[]> downloadBytes(@RequestParam long length) {
            byte[] fileContents = generateRandomBytes(length);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=randomFile.txt");
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileContents);
        }

        @GetMapping("/downloadStream")
        public ResponseEntity<InputStreamResource> downloadStream(@RequestParam long length) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=randomFile.txt");
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            InputStreamResource inputStreamResource = generateRandomStream(length);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(length)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(inputStreamResource);
        }

        private byte[] generateRandomBytes(long length) {
            try {
                final byte[] fileContents;

                if (length < 0 || length > Integer.MAX_VALUE) {
                    fileContents = new byte[Integer.MAX_VALUE];
                } else {
                    fileContents = new byte[(int) length];
                }

                new Random().nextBytes(fileContents);
                return fileContents;
            } catch (Exception e) {
                log.info("Error generating random bytes");
                return new byte[] {0};
            }
        }

        private InputStreamResource generateRandomStream(long length) {
            RandomByteArrayInputStream inputStream = new RandomByteArrayInputStream(length);
            return new InputStreamResource(inputStream);
        }

}
