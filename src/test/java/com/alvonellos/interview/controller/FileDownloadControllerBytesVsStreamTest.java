package com.alvonellos.interview.controller;

import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.TreeMap;
import java.util.logging.Logger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class FileDownloadControllerBytesVsStreamTest {
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new FileDownloadControllerBytesVsStream()).build();

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Before
    public void setUp() throws Exception {
        long start = System.currentTimeMillis();
        mockMvc.perform(get("/downloadBytes").param("length", String.valueOf(1000)));
        long end = System.currentTimeMillis();
        log.info("Without warmup downloadbytes took " + (end - start) + " ms");


        long start2 = System.currentTimeMillis();
        mockMvc.perform(get("/downloadStream").param("length", String.valueOf(1000)));
        long end2 = System.currentTimeMillis();
        log.info("Without warmup downloadstream took " + (end2 - start2) + " ms");

        log.info("Warming up to 100 bytes");
        for (int i = 0; i < 100; i++) {
            mockMvc.perform(
                            get("/downloadBytes")
                                    .param("length", String.valueOf(i)))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/octet-stream"))
                    .andReturn();

            mockMvc.perform(
                            get("/downloadStream")
                                    .param("length", String.valueOf(i)))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/octet-stream"))
                    .andReturn();
        }

        start = System.currentTimeMillis();
        mockMvc.perform(get("/downloadBytes").param("length", String.valueOf(1000)));
        end = System.currentTimeMillis();
        log.info("After warmup downloadbytes took " + (end - start) + " ms");


        start2 = System.currentTimeMillis();
        mockMvc.perform(get("/downloadStream").param("length", String.valueOf(1000)));
        end2 = System.currentTimeMillis();
        log.info("After warmup downloadstream took " + (end2 - start2) + " ms");
    }

    @Test
    public void downloadBytes_andShouldReturnSingleElement() throws Exception {
        log.info("Testing downloadBytes");
        val result = mockMvc.perform(
                        get("/downloadBytes")
                                .param("length", String.valueOf(1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/octet-stream"))
                .andDo(print())
                .andReturn();

        assert (result.getResponse().getContentAsByteArray().length == 1);
    }

    @Test
    public void downloadStream_andShouldReturnSingleElement() throws Exception {
        log.info("Testing downloadStream");

        val result = mockMvc.perform(
                        get("/downloadStream")
                                .param("length", String.valueOf(1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/octet-stream"))
                .andDo(print())
                .andReturn();

        assert (result.getResponse().getContentAsByteArray().length == 1);
    }

    @Test
    public void testDownloadBytesAndFindMaxLength() {
        long initialLength = 2;
        long maxLength = Long.MAX_VALUE;  // Adjust as needed
        int maxIterations = 30;  // Adjust as needed
        int iter = 0;
        long length = initialLength;
        long previousResponseTimeBytes = Long.MAX_VALUE;
        TreeMap<Long, Double> dpdtMap = new TreeMap<>();
        TreeMap<Long, Double> ddpdtMap = new TreeMap<>();

        outOfRam:
        {
            do {
                try {
                    long startTimeBytes = System.currentTimeMillis();

                    mockMvc.perform(
                                    get("/downloadBytes")
                                            .param("length", String.valueOf(length)))
                            .andExpect(status().isOk())
                            .andExpect(content().contentType("application/octet-stream"))
                            .andReturn();

                    long endTimeBytes = System.currentTimeMillis();
                    long responseTimeBytes = endTimeBytes - startTimeBytes;

                    System.out.println(String.format("Bytes - length: %d, responseTime: %d", length, responseTimeBytes));

                    if (responseTimeBytes > previousResponseTimeBytes) {
                        System.out.println("Bytes - Performance starting to degrade. Halving the length.");
                        // Adjust the length using binary search
                        maxLength = length;
                        length = (length / 2) + (maxLength / 2);
                    } else {
                        System.out.println("Bytes - Performance is good. Squaring the length.");
                        // Adjust the length using binary search
                        maxLength = length;
                        length = (length * length) / (maxLength / 2);
                    }

                    previousResponseTimeBytes = responseTimeBytes;

                    iter++;dpdtMap.put(length, (double) responseTimeBytes / length);
                    ddpdtMap.put(length, ((double) responseTimeBytes / length) - ((double) previousResponseTimeBytes / length) / (length - (length / 2)));
                } catch (Exception e) {
                    System.out.println("Bytes - Caught exception: " + e.getMessage());
                    break outOfRam;
                }
            } while ((iter < maxIterations && length > 0));
            System.out.println(String.format("Bytes - Final time: %d, Length: %d", previousResponseTimeBytes, length));
            System.err.println("Best length: " + dpdtMap.lastEntry().getKey());
            System.err.println("Derivatives");
            System.err.println(String.format("%8s, %9s, %2s", "length", "ddpdt", "=0"));
            ddpdtMap.forEach((key, value) -> {
                System.err.println(String.format("%8d, %1.8f %2b", key, value, value.compareTo(0.00) == 0));
            });
        }
    }

    @Test
    public void testDownloadStreamAndFindMaxLength() {

        long initialLength = 2;
        long maxLength = Long.MAX_VALUE;  // Adjust as needed
        int maxIterations = 30;  // Adjust as needed
        int iter = 0;
        long length = initialLength;
        long previousResponseTimeStream = Long.MAX_VALUE;
        double dpdt = Double.MAX_VALUE;
        double ddpdt = Double.MAX_VALUE;
        TreeMap<Long, Double> dpdtMap = new TreeMap<>();
        TreeMap<Long, Double> ddpdtMap = new TreeMap<>();

        outOfRam:
        {
            do {
                try {
                    long startTimeStream = System.currentTimeMillis();

                    mockMvc.perform(
                                    get("/downloadStream")
                                            .param("length", String.valueOf(length)))
                            .andExpect(status().isOk())
                            .andExpect(content().contentType("application/octet-stream"))
                            .andReturn();

                    long endTimeStream = System.currentTimeMillis();
                    long responseTimeStream = endTimeStream - startTimeStream;

                    System.err.println(String.format("Stream - length: %d, responseTime: %d", length, responseTimeStream));

                    if (responseTimeStream > (previousResponseTimeStream+1)) {
                        System.out.println("Stream - Performance starting to degrade. Halving the length.");
                        // Adjust the length using binary search
                        maxLength = length;
                        length = (length / 2) + (maxLength / 2);
                    } else {
                        System.out.println("Stream - Performance is good. Squaring the length.");
                        // Adjust the length using binary search
                        maxLength = length;
                        length = (length * length) / (maxLength / 2);
                    }

                    previousResponseTimeStream = responseTimeStream;

                    iter++; dpdtMap.put(length, (double) responseTimeStream / length);
                    ddpdtMap.put(length, ((double) responseTimeStream / length) - ((double) previousResponseTimeStream / length) / (length - (length / 2)));
                } catch (Exception e) {
                    System.err.println("Stream - Caught exception: " + e.getMessage());
                    break outOfRam;
                }
            } while ((iter < maxIterations && length > 0));
            System.err.println(String.format("Stream - Final time: %d, Length: %d", previousResponseTimeStream, length));
            System.err.println("Best length: " + dpdtMap.lastEntry().getKey());
            System.err.println("Derivatives");
            System.err.println(String.format("%8s, %9s, %2s", "length", "ddpdt", "=0"));
            ddpdtMap.forEach((key, value) -> {
                System.err.println(String.format("%8d, %1.8f %2b", key, value, value.compareTo(0.00) == 0));
            });
        }
    }
}