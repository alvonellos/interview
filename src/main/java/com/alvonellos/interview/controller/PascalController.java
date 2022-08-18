package com.alvonellos.interview.controller;

import com.alvonellos.interview.util.numbers.PascalsTriangle;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class PascalController {
    private static final HashMap<Integer, List<List<BigInteger>>> cached = new HashMap<>();
    static { // cache the first 10 entries
        cached.put(1, PascalsTriangle.pascalsTriangleBinomial(1));
        cached.put(2, PascalsTriangle.pascalsTriangleBinomial(2));
        cached.put(3, PascalsTriangle.pascalsTriangleBinomial(3));
        cached.put(4, PascalsTriangle.pascalsTriangleBinomial(4));
        cached.put(5, PascalsTriangle.pascalsTriangleBinomial(5));
        cached.put(6, PascalsTriangle.pascalsTriangleBinomial(6));
        cached.put(7, PascalsTriangle.pascalsTriangleBinomial(7));
        cached.put(8, PascalsTriangle.pascalsTriangleBinomial(8));
        cached.put(9, PascalsTriangle.pascalsTriangleBinomial(9));
        cached.put(10, PascalsTriangle.pascalsTriangleBinomial(10));
    }

    @GetMapping("/pascal/{numRows}")
    public ResponseEntity<List<List<BigInteger>>> pascal(@PathVariable("numRows") Integer numRows) {
        if(cached.containsKey(numRows)) {
            log.info("CACHE HIT");
            return new ResponseEntity<>(cached.get(numRows), HttpStatus.OK);
        } else {
            log.info("CACHE MISS");
            cached.put(numRows, PascalsTriangle.pascalsTriangleBinomial(numRows));
            // System.err.println(cached.get(numRows));
            return new ResponseEntity<>(cached.get(numRows), HttpStatus.CREATED);
        }
    }
}
