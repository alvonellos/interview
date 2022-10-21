package com.alvonellos.interview.datastructures;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph<T extends Comparable<? super T>> implements Comparable<UndirectedGraph<T>> {
    private GraphNode<T> head = null;
    private List<GraphNode<T>> nodes = new ArrayList<GraphNode<T>>();
    private int vertexCount = 0;
    private int edgeCount = 0;

    private boolean allowCycles = true;


    public UndirectedGraph() {
        head = new GraphNode<T>(null);
    }


    public UndirectedGraph(boolean allowCycles) {
        head = new GraphNode<T>(null);
        this.allowCycles = allowCycles;
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
     * Add a link between two nodes, adding the nodes if they don't exist.
     * @param source
     * @param destination
     */
    public boolean addEdge(T source, T destination) {
        if (source == null || destination == null) return false;
        if (source == destination && !allowCycles) return false;

        edgeCount++;
        GraphNode<T> sourceNode = find(source);
        GraphNode<T> destinationNode = find(destination);

        if (sourceNode == null) {
            sourceNode = new GraphNode<T>(source);
            nodes.add(sourceNode);
        }

        if (destinationNode == null) {
            destinationNode = new GraphNode<T>(destination);
            nodes.add(destinationNode);
        }

        sourceNode.links.add(destinationNode);
        destinationNode.links.add(sourceNode);
        return true;
    }

    /**
     * Add a node to the graph.
     * @param vertex
     */
    public void addVertex(T vertex) {
        vertexCount++;
        nodes.add(new GraphNode<T>(vertex));
    }

    public GraphNode<T> depthFirstSearch(T data, GraphNode<T> head) {
        if (head == null) return null;
        if (head.data == data) return head;
        for (GraphNode<T> node : head.links) {
            GraphNode<T> result = depthFirstSearch(data, node);
            if (result != null) return result;
        }
        return null;
    }

    /** Find a node in the graph by its data
     * @param data the data to search for
     * @return the node if found, null otherwise
     */
    public GraphNode<T> find(T data) {
        for (GraphNode<T> node : nodes) {
            if (node.getData().equals(data)) {
                return node;
            }
        }
        return null;
    }

    /**
     * Remove a link between two nodes.
     * @param source
     * @param destination
     */
    public void removeEdge(T source, T destination) {
        GraphNode<T> sourceNode = find(source);
        GraphNode<T> destinationNode = find(destination);

        if (sourceNode == null || destinationNode == null)      return;

        edgeCount--;
        sourceNode.links.remove(destinationNode);
        destinationNode.links.remove(sourceNode);
    }

    /**
     * Remove a node from the graph.
     * @param vertex
     */
    public void removeVertex(T vertex) {
        vertexCount--;
        for(GraphNode<T> node : nodes) {
            node.links.remove(find(vertex));
        }
        nodes.remove(find(vertex));
    }


    @Override
    public int compareTo(@NotNull final UndirectedGraph<T> o) {
        if (this.vertexCount < o.vertexCount) return -1;
        if (this.vertexCount > o.vertexCount) return 1;
        if (this.vertexCount == o.vertexCount) return 0;
        throw new RuntimeException("Invalid comparison");
    }


    public void depthFirstTraversal() {

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
