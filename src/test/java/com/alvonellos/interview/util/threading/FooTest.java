package com.alvonellos.interview.util.threading;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/print-in-order/">...</a>
 *
 */
class FooTest {

    @Test
    void runFoo() throws InterruptedException {
        Foo foo = new Foo();
        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        List<Thread> threads = Stream.of(t2, t1, t3).collect(Collectors.toList());
        Collections.shuffle(threads);
        threads.forEach(Thread::start);

        while (threads.stream().anyMatch(t -> t.isAlive())) {
            Thread.sleep(100);
        }

        assert(foo.order.equals(Stream.of(1, 2, 3).collect(Collectors.toList())));

    }
}