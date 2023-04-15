package com.alvonellos.interview.controller;


import com.alvonellos.interview.client.MemeClient;
import com.alvonellos.interview.dto.response.CaptionImageResponseDTO;
import com.alvonellos.interview.dto.response.MemeResponseDTO;
import com.alvonellos.interview.service.MemeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MemeController {

    private final MemeService memeService;

    private final MemeClient memeClient;

    @GetMapping("/memes")
    public ResponseEntity<MemeResponseDTO> list() {
        return ResponseEntity.ok(memeClient.getMemes());
    }

    @GetMapping("/create/{id}/{text1}/{text2}")
    public ResponseEntity<CaptionImageResponseDTO> create(@PathVariable("id") String id, @PathVariable("text1") String text1, @PathVariable("text2") String text2) {
        return ResponseEntity.ok(memeClient.createMeme(id, text1, text2));
    }
}
