package com.alvonellos.interview.util.GuavaExamples;

import com.google.common.collect.Lists;
import com.google.common.graph.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class GuavaExampleTest {
    @Test
    public void whenReverseList_thenReversed() {
        List<String> names = Lists.newArrayList("John", "Adam", "Jane");

        List<String> reversed = (List<String>) Lists.reverse(names);
        assertArrayEquals(new String[]{"Jane", "Adam", "John"}, reversed.toArray());
    }

    @Test
    public void whenReverseList_thenReverse() {
        List<String> names = Lists.newArrayList("John", "Adam", "Jane");

        Lists.reverse(names);
        assertArrayEquals(new String[]{"Jane", "Adam", "John"}, names.toArray());
    }

    @Test
    public void createGraphAndTraverse() {
        List<String> names = Lists.newArrayList("John", "Adam", "Jane");
        MutableGraph<String> graph = GraphBuilder.directed().build();
        graph.addNode("John");
        graph.addNode("Adam");
        graph.addNode("Jane");

        graph.putEdge("John", "Adam");
        graph.putEdge("John", "Jane");
        graph.putEdge("Adam", "Jane");

        assertThat(graph.nodes()).containsExactlyInAnyOrder("John", "Adam", "Jane");
        assertThat(graph.successors("John")).containsExactlyInAnyOrder("Adam", "Jane");
        assertThat(graph.predecessors("Jane")).containsExactlyInAnyOrder("John", "Adam");
    }

    @Test
    public void createGraphAndTraverse2() {
        List<String> names = Lists.newArrayList();
        MutableValueGraph<String, Integer> graph = ValueGraphBuilder.undirected().build();
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addNode("5");

        graph.putEdgeValue("1", "2", 1);
        graph.putEdgeValue("1", "3", 1);
        graph.putEdgeValue("1", "4", 1);

        graph.putEdgeValue("2", "3", 1);
        graph.putEdgeValue("2", "4", 1);

        graph.putEdgeValue("3", "4", 1);

        graph.putEdgeValue("4", "5", 1);

        System.out.println(graph.toString());

        Traverser.forGraph(graph).depthFirstPostOrder("1").forEach(System.out::println);

    }
}