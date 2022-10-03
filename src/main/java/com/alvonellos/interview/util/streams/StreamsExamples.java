package com.alvonellos.interview.util.streams;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class StreamsExamples {
    public static Stream<String> getAlphabetStream() {
        return Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    }

    public static Stream<Optional<String>> getOptionalAlphabetStreamWithNulls() {
        return Stream.of(Optional.ofNullable(null), Optional.of("a"), Optional.of("b"), Optional.of("c"), Optional.of("d"), Optional.of("e"), Optional.of("f"), Optional.of("g"), Optional.of("h"), Optional.of("i"), Optional.of("j"), Optional.of("k"), Optional.of("l"), Optional.of("m"), Optional.of("n"), Optional.of("o"), Optional.of("p"), Optional.of("q"), Optional.of("r"), Optional.of("s"), Optional.of("t"), Optional.of("u"), Optional.of("v"), Optional.of("w"), Optional.of("x"), Optional.of("y"), Optional.of("z"));
    }

    public static Stream<String> convertOptionalAlphabetStreamToStream(Stream<Optional<String>> optionalAlphabetStream) {
        return optionalAlphabetStream.flatMap(
                optional -> optional.map(Stream::of).orElse(Stream.empty())
        );
    }

    public static Stream<String> duplicateStream(Stream<String> stream) {
        return stream.flatMap(
                s -> Stream.of(s, s)
        );
    }

    public static Stream<String> removeDuplicates(Stream<String> stream) {
        return stream.distinct();
    }

    public static Stream<String> removeDuplicatesWithSet(Stream<String> stream) {
        return stream.collect(toSet()).stream();
    }

    public static Stream<String> merge(Stream<String> stream, Stream<String> stream2) {
        return Stream.concat(
                stream.map(Optional::of),
                stream2.map(Optional::of)
        ).flatMap(
                optional -> optional.map(Stream::of).orElse(Stream.empty())
        );
    }

    public static Stream<String> mergeWithNulls(Stream<String> stream, Stream<String> stream2) {
        return Stream.concat(
                stream.map(Optional::of),
                stream2.map(Optional::ofNullable)
        ).flatMap(
                optional -> optional.map(Stream::of).orElse(Stream.empty())
        );
    }


    public static Stream<String> filterByPredicate(Stream<String> stream, Predicate<String> predicate) {
        return stream.filter(predicate::test);
    }
}
