package com.alvonellos.interview.datastructures;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T extends Comparable<? super T>> implements Comparable<GraphNode<T>> {
    T data;
    List<GraphNode<T>> links;

    /**
     * Constructor for the GraphNode class
     */
    public GraphNode() {
        this.data = null;
        this.links = new ArrayList<GraphNode<T>>();
    }

    /**
     * Constructor for the GraphNode class
     * @param data the data objects
     * @param links the links
     */
    public GraphNode(T data) {
        this.data = data;
        this.links = new ArrayList<GraphNode<T>>();
    }


    /**
     * Constructor for the GraphNode class
     * @param data the data objects
     * @param links the links
     */
    public GraphNode(T data, List<GraphNode<T>> links) {
        this.data = data;
        this.links = links;
    }

    /**
     * Get the data object
     * @return the data object
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data object
     * @param data the data object
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Get the links
     * @return the links
     */
    public List<GraphNode<T>> getLinks() {
        return links;
    }

    /**
     * Set the links
     * @param links the links
     */
    public void setLinks(List<GraphNode<T>> links) {
        this.links = links;
    }

    @Override
    public int compareTo(@NotNull GraphNode<T> o) {
        return o.compareTo(this);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
