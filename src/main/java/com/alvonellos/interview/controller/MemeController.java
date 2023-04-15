package com.alvonellos.interview.controller;


import com.alvonellos.interview.client.ImageReaderClient;
import com.alvonellos.interview.client.MemeClient;
import com.alvonellos.interview.dto.response.CaptionImageResponseDTO;
import com.alvonellos.interview.dto.response.MemeResponseDTO;
import com.alvonellos.interview.service.MemeService;
import com.alvonellos.interview.util.images.RandomImage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.alvonellos.interview.client.ImageReaderClient.bufferedImageToBytes;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MemeController {

    private final MemeService memeService;

    private final MemeClient memeClient;

    private final ImageReaderClient imageReaderClient;

    @GetMapping("/memes")
    public ResponseEntity<MemeResponseDTO> list() {
        return ResponseEntity.ok(memeClient.getMemes());
    }

    @GetMapping("/create/{id}/{text1}/{text2}")
    public ResponseEntity<CaptionImageResponseDTO> create(@PathVariable("id") String id, @PathVariable("text1") String text1, @PathVariable("text2") String text2) {
        return ResponseEntity.ok(memeClient.createMeme(id, text1, text2));
    }

    @GetMapping(value = "/test", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@RequestParam String path) throws IOException {
        return new ResponseEntity<>(bufferedImageToBytes(imageReaderClient.getJpgImageFromUrl(path)), HttpStatus.OK);
    }
}
