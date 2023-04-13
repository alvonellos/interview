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
class RedBlackBSTTest {

    @Test
    void sizeTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        assertEquals(0, redBlackBST.size());
        redBlackBST.put("a", "b");
        assertEquals(1, redBlackBST.size());
    }

    @Test
    void isEmptyTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        assertTrue(redBlackBST.isEmpty());
        redBlackBST.put("a", "b");
        assertFalse(redBlackBST.isEmpty());
    }

    @Test
    void getTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        assertEquals("b", redBlackBST.get("a"));
    }

    @Test
    void getTestAndFailMissingIndex() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        assertNull(redBlackBST.get("c"));
    }

    @Test
    void containsTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        assertTrue(redBlackBST.contains("a"));
    }

    @Test
    void containsTestAndFailMissingIndex() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        assertFalse(redBlackBST.contains("c"));
    }

    @Test
    void put() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        assertEquals("b", redBlackBST.get("a"));
    }

    @Test
    void deleteMinTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        redBlackBST.put("d", "e");
        redBlackBST.deleteMin();

        assert(!redBlackBST.contains("a"));

    }

    @Test
    void deleteMax() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        redBlackBST.put("d", "e");
        redBlackBST.deleteMax();

        assert(!redBlackBST.contains("d"));
    }

    @Test
    void deleteTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        redBlackBST.put("d", "e");
        redBlackBST.delete("a");
        assert(!redBlackBST.contains("a"));
    }

    @Test
    void heightTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        assert(redBlackBST.height() == 1); // should be balanced
    }

    @Test
    void minTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        assert(redBlackBST.min().equals("a"));
    }

    @Test
    void maxTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        assert(redBlackBST.max().equals("c"));
    }

    @Test
    void floorTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        assert(redBlackBST.floor("a").equals("a"));
    }

    @Test
    void ceilingTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        assert(redBlackBST.ceiling("a").equals("a"));
    }

    @Test
    void selectTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        assert(redBlackBST.select(0).equals("a"));
        assert(redBlackBST.select(1).equals("b"));
        assert(redBlackBST.select(2).equals("c"));
    }

    @Test
    void rankTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        assert(redBlackBST.rank("a") == 0);
        assert(redBlackBST.rank("b") == 1);
        assert(redBlackBST.rank("c") == 2);
    }

    @Test
    void keysTest() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("a", "b");
        redBlackBST.put("b", "c");
        redBlackBST.put("c", "d");
        Iterable<String> keys = redBlackBST.keys();
        int i = 0;
        for (String key : keys) {
            assert(key.equals(redBlackBST.select(i)));
            i++;
        }
    }
}