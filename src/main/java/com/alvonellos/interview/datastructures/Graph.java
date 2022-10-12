package com.alvonellos.interview.datastructures;

public class Graph {
    private GraphNode<T> head = null;
    private int vertexCount = 0;
    private int edgeCount = 0;


    public Graph() {
        head = new GraphNode<T>(null);
    }

    /**
     * Add a link between two nodes.
     * @param source
     * @param destination
     */
    public void addEdge() {

    }

    /**
     * Add a node to the graph.
     * @param vertex
     */
    public void addVertex(int vertex) {

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
}
