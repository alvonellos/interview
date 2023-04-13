package com.alvonellos.interview.datastructures;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
class QueueTest {

    @Test
    void enqueueTest() {
        Queue<String> queue = new Queue<>(1);
        assertTrue(queue.isEmpty());
        queue.enqueue("a");
        assertFalse(queue.isEmpty());
        assertEquals("a", queue.peek());
    }

    @Test
    void dequeueTest() {
        Queue<String> queue = new Queue<>(1);
        queue.enqueue("a");
        assertEquals("a", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmptyTest() {
        Queue<String> queue = new Queue<>(1);
        assertTrue(queue.isEmpty());
        queue.enqueue("a");
        assertFalse(queue.isEmpty());
    }

    @Test
    void isFullTest() {
        Queue<String> queue = new Queue<>(1);
        assertFalse(queue.isFull());
        queue.enqueue("a");
        assertTrue(queue.isFull());
    }

    @Test
    void peekTest() {
        Queue<String> queue = new Queue<>(1);
        queue.enqueue("a");
        assertEquals("a", queue.peek());
    }

    @Test
    void iteratorTest() {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(1);;
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        int i = 1;
        for (Integer s : queue) {
            assertEquals(i, s);
            i++;
        }
    }
}