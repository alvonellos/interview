package com.alvonellos.interview.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LinkedListTest {

    @Test
    void sizeTest() {
        LinkedList<String> l = new LinkedList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        l.add("6");
        l.add("7");
        l.add("8");
        l.add("9");
        l.add("10");
        assert (l.size() == 10);
    }

    @Test
    void isEmptyTest() {
        LinkedList<String> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        l.add("6");
        l.add("7");
        l.add("8");
        l.add("9");
        l.add("10");
        assert (l.size() == 10);

        l.clear();
        assert (l.isEmpty());


    }

    @Test
    void addTest() {
        LinkedList<String> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add("1");

        assert (!l.isEmpty());
        assert (l.get(1).getDatum().equals("1"));
    }

    @Test
    @SuppressWarnings("all") // assert has side effects on purpose
    void removeTest() {
        LinkedList<String> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add("1");
        assert (!l.isEmpty());

        assert (l.remove("1"));
        assert (l.size() == 0);

        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        l.add("6");
        l.add("7");
        l.add("8");
        l.add("9");
        l.add("10");
        assert (l.size() == 10);

        assert (l.remove("10"));
        assert (l.size() == 9);

        assert (!l.remove("-1"));
    }

    @Test
    void clearTest() {
        LinkedList<String> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        l.add("6");
        l.add("7");
        l.add("8");
        l.add("9");
        l.add("10");
        assert (l.size() == 10);

        l.clear();
        assert (l.isEmpty());
    }

    @Test
    void getTest() {
        LinkedList<String> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add("1");

        assert (!l.isEmpty());
        assert (l.get(1).getDatum().equals("1"));
    }

    @Test
    void getTestAndFailMissingIndex() {
        LinkedList<String> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add("1");
        l.add("2");

        assert (!l.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> l.get(0));
        assertThrows(IllegalArgumentException.class, () -> l.get(3));
    }

    @Test
    void indexOfTest() {
        LinkedList<String> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add("1");
        l.add("2");
        l.add("3");

        assert (!l.isEmpty());
        assert (l.indexOf("1") == 1);
        assert (l.indexOf("2") == 2);
        assert (l.indexOf("3") == 3);

        //Not found
        assert (l.indexOf("4") == -1);
    }

    @Test
    void iteratorTest() {
        LinkedList<Integer> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(10);
        assert (l.size() == 10);

        int count = 0;
        for (Integer s : l) {
            count++;
            assert (s == count);
        }
    }

    @Test
    void testToString() {
        LinkedList<Integer> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(10);
        assert (l.size() == 10);

        String expected = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";
        String actual = l.toString();
        assert (actual.equals(expected));
    }

    @Test
    void reverseListTest() {
        LinkedList<Integer> l = new LinkedList<>();
        assert (l.isEmpty());

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(10);
        assert (l.size() == 10);

        l.reverse();

        String expected = "10, 9, 8, 7, 6, 5, 4, 3, 2, 1";
        String actual = l.toString();
        System.err.println(actual);
        assert (actual.equals(expected));
    }
}