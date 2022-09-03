package com.alvonellos.interview.util.streams;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamsExamplesTest {

    @Test
    void getAlphabetStreamTest() {
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        val alphabetStream = StreamsExamples.getAlphabetStream();
        assertEquals(abcd, alphabetStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
    }

    @Test
    void getOptionalAlphabetStreamWithNulls() {
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        val optionalAlphabetStream = StreamsExamples.getOptionalAlphabetStreamWithNulls();
        assertEquals(abcd, StreamsExamples.convertOptionalAlphabetStreamToStream(optionalAlphabetStream).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
    }

    @Test
    void convertOptionalAlphabetStreamToStream() {
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        val optionalAlphabetStream = StreamsExamples.getOptionalAlphabetStreamWithNulls();
        assertEquals(abcd, StreamsExamples.convertOptionalAlphabetStreamToStream(optionalAlphabetStream).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());

    }

    @Test
    void duplicateStream() {
        String abcd2 = "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz";
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        val stream = StreamsExamples.getAlphabetStream();
        val duplicatedStream = StreamsExamples.duplicateStream(stream);
        assertEquals(abcd2, duplicatedStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
    }

    @Test
    void removeDuplicates() {
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        val stream = StreamsExamples.getAlphabetStream();
        val duplicatedStream = StreamsExamples.duplicateStream(stream);
        val removedDuplicatesStream = StreamsExamples.removeDuplicates(duplicatedStream);
        assertEquals(abcd, removedDuplicatesStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
    }

    @Test
    void removeDuplicatesWithSet() {
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        val stream = StreamsExamples.getAlphabetStream();
        val duplicatedStream = StreamsExamples.duplicateStream(stream);
        val removedDuplicatesStream = StreamsExamples.removeDuplicatesWithSet(duplicatedStream);
        assertEquals(abcd, removedDuplicatesStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
    }

    @Test
    void merge() {
        val abcd = "abcdefghijklmnopqrstuvwxyz";
        val stream = StreamsExamples.getAlphabetStream();
        val stream2 = StreamsExamples.getAlphabetStream();
        val mergedStream = StreamsExamples.merge(stream, stream2).collect(Collectors.toList());
        assertEquals(abcd.length() * 2, mergedStream.size());
    }

}