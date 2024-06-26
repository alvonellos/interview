package com.alvonellos.interview.controller;

import com.alvonellos.interview.service.SortingAlgorithmService;
import com.alvonellos.utilities.sorting.SortingAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController // Because of SpringBoot ResponseBody implementation. We are not returning a view.
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SortingAlgorithmController {
    final SortingAlgorithmService sortingAlgorithmService;
    @PostMapping(value = "sort")
    public List<?> sort(@RequestBody List<String> body,
                        @RequestParam(value = "algorithm", required = false) SortingAlgorithm.Algorithm algorithm) {

        String[] numbers = body.toArray(new String[0]);

        switch(algorithm) {
            case BUBBLE:
                sortingAlgorithmService.bubbleSort(numbers);
                break;
            case QUICK:
                sortingAlgorithmService.quickSort(numbers);
                break;
            case SELECTION:
                sortingAlgorithmService.selectionSort(numbers);
                break;
            case SHELL:
                sortingAlgorithmService.shellSort(numbers);
                break;
            case MERGE:
                sortingAlgorithmService.mergeSort(numbers);
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
        return Arrays.asList(numbers);
    }
}
