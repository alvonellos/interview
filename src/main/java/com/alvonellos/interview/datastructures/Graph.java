package com.alvonellos.interview.datastructures;

import org.jetbrains.annotations.NotNull;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>> {
    private GraphNode<T> head = null;
    private int vertexCount = 0;
    private int edgeCount = 0;

    private boolean allowCycles = true;


    public Graph() {
        head = new GraphNode<T>(null);
    }

    /**
     * Add a link between two nodes.
     * @param source
     * @param destination
     */
    public boolean addEdge(GraphNode<T> source, GraphNode<T> destination) {
        if (source == null || destination == null)      return false;
        if (source == destination && !allowCycles)      return false;

        edgeCount++;
        source.links.add(destination);
        destination.links.add(source);
        return true;
    }

    /**
     * Add a node to the graph.
     * @param vertex
     */
    public void addVertex(int vertex) {
        vertexCount++;
    }

    /**
     * Remove a link between two nodes.
     * @param source
     * @param destination
     */
    public void removeEdge(int source, int destination) {

    }

    /**
     * Remove a node from the graph.
     * @param vertex
     */
    public void removeVertex(int vertex) {

    }




    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Override
    public int compareTo(@NotNull final Graph<T> o) {
        return 0;
    }
}
