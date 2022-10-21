package com.alvonellos.interview.datastructures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphNodeTest {

    @Test
    void getDataTest() {
        GraphNode<Integer> node = new GraphNode<>(1);
        assertEquals(1, node.getData());
    }

    @Test
    void setDataTest() {
        GraphNode<Integer> node = new GraphNode<>(1);
        node.setData(2);
        assertEquals(2, node.getData());
    }

    @Test
    void getLinksTest() {
        GraphNode<Integer> node = new GraphNode<>(1);
        assertEquals(0, node.getLinks().size());

        node.getLinks().add(new GraphNode<>(2));
        assertEquals(1, node.getLinks().size());
    }

    @Test
    void setLinks() {
        GraphNode<Integer> node = new GraphNode<>(1);
        node.setLinks(new ArrayList<>());
        assertEquals(0, node.getLinks().size());
        node.getLinks().add(new GraphNode<>(2));
        assertEquals(1, node.getLinks().size());
    }

    @Test
    void compareTo() {
        GraphNode<Integer> node1 = new GraphNode<>(1);
        GraphNode<Integer> node2 = new GraphNode<>(2);
        assertEquals(-1, node1.compareTo(node2));
        assertEquals(1, node2.compareTo(node1));
        assertEquals(0, node1.compareTo(node1));
    }

    @Test
    void testHashCode() {
        GraphNode<Integer> node1 = new GraphNode<>(1);
        GraphNode<Integer> node2 = new GraphNode<>(2);
        assertNotEquals(node1.hashCode(), node2.hashCode());
        assertEquals(node1.hashCode(), node1.hashCode());
    }
}