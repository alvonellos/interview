package com.alvonellos.interview.util.streams;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
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

    @Test
    void mergeWithNullsTest() {
        val abcd = "abcdefghijklmnopqrstuvwxyz";
        val stream = StreamsExamples.getAlphabetStream();
        val stream2 = StreamsExamples.convertOptionalAlphabetStreamToStream(
                StreamsExamples.getOptionalAlphabetStreamWithNulls());
        val mergedStream = StreamsExamples.merge(stream, stream2).collect(Collectors.toList());
        assertEquals(false, mergedStream.contains(null));
    }

    @Test
    void filterByPredicateTest() {
        val abcd = "abcdefghijklmnopqrstuvwxyz";
        val stream = StreamsExamples.getAlphabetStream();
        val filteredStream = StreamsExamples.filterByPredicate(stream, s -> s.equals("a")).collect(Collectors.toList());
        assertEquals(1, filteredStream.size());
        assertEquals("a", filteredStream.get(0));
    }

    @Test
    void reverseStreamTest() {
        val abcd = "abcdefghijklmnopqrstuvwxyz";
        val stream = StreamsExamples.getAlphabetStream();
        val reversedStream = StreamsExamples.reverseStream(stream).collect(Collectors.toList());
        assertEquals(abcd.length(), reversedStream.size());
        assertEquals("z", reversedStream.get(0));
    }

    @Test
    void reverseStreamWithStream() {
    }
}