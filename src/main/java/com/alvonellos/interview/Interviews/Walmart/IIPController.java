package com.alvonellos.interview.Interviews.Walmart;

//Spring boot crud restcontroller titled iipController

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/iips")
public class IIPController {

    private final IIPService iipService;

    @GetMapping
    public ResponseEntity<List<IIP>> getAlliips() {
        return new ResponseEntity<>(iipService.getAllIIPs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IIP> getIIPById(@PathVariable UUID iipId) {
        return new ResponseEntity<>(iipService.getIIPById(iipId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IIP> createIIP(@RequestBody IIP iip) {
        return new ResponseEntity<>(iipService.createIIP(iip), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IIP> updateIIP(@PathVariable UUID iipId, @RequestBody IIP iip) {
        return new ResponseEntity<>(iipService.updateIIP(iipId, iip), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<IIP> deleteIIP(@PathVariable UUID iipId) {
        return new ResponseEntity<>(iipService.deleteIIP(iipId), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IIP> patchIIP(@PathVariable UUID iipId, @RequestBody IIPPatchRequest iipPatchRequest) {
        return new ResponseEntity<>(iipService.patchIIP(iipId, iipPatchRequest), HttpStatus.OK);
    }
}