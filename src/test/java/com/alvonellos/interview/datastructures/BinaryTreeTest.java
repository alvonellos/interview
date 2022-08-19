package com.alvonellos.interview.datastructures;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void searchTest() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assert(tree.search(1).getDatum().equals(1));
        assert(tree.search(5).getDatum().equals(5));
    }

    @Test
    void insertTest() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        assert(tree.search(1).getDatum().equals(1));
        assert(tree.search(5).getDatum().equals(5));
    }

    @Test
    void deleteTest() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assert(tree.search(1).getDatum().equals(1));
        assert(tree.search(5).getDatum().equals(5));
        tree.delete(1);
        assert(tree.search(1) == null);
        assert(tree.search(5).getDatum().equals(5));
    }

    @Test
    void iteratorTest() {
        for(int i = 0; i < 10; i++) {
            BinaryTree<Integer> tree = new BinaryTree<>();
            tree.insert(i);
            Iterator<Integer> iterator = tree.iterator();
            while(iterator.hasNext()) {
                assert(iterator.next().equals(i));
            }
        }
    }
}