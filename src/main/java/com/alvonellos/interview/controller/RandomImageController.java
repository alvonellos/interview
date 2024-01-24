package com.alvonellos.interview.controller;

import com.alvonellos.utilities.images.RandomImage;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class RandomImageController {
    @GetMapping(value = "/random-image/{width}/{height}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> randomImage(@PathVariable Integer width, @PathVariable Integer height) throws IOException {
        return new ResponseEntity<>(RandomImage.getImage(width, height), HttpStatus.OK);
    }
}
