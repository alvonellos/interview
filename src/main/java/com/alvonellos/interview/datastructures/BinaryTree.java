package com.alvonellos.interview.datastructures;

import com.alvonellos.interview.util.crypto.CryptoAlgorithms;

import java.util.Iterator;

public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {
    protected class BinaryTreeIterator implements Iterator<T> {
        private Node<T> cursor;

        public BinaryTreeIterator(Node<T> node) {
            this.cursor = node;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            if (cursor != null) {
                T datum = cursor.getDatum();
                cursor = cursor.getPrev();
                return datum;
            }
            return null;
        }
    }

    //initialize the root node
    protected Node<T> root;

    /**
     * Constructor for the binary tree.
     */
    public BinaryTree() {
        this.root = null;
    }


    /**
     * Search the tree for the specified data.
     *
     * @param datum the data to search for
     * @return the node containing the data, or null if not found
     */
    public Node<T> search(T datum) {
        return search(this.root, datum);
    }

    /**
     * Search the tree for a node.
     *
     * @param node  the node to start searching from
     * @param datum the datum to search for
     * @return the node if found, null otherwise
     */
    private Node<T> search(Node<T> node, T datum) {
        if (node == null) {
            return null;
        }
        if (node.getDatum().compareTo(datum) == 0) {
            return node;
        }
        if (node.getDatum().compareTo(datum) > 0) {
            return search(node.getPrev(), datum);
        }
        return search(node.getNext(), datum);
    }

    /**
     * Inserts a node into the tree.
     *
     * @param datum
     */
    public void insert(T datum) {
        Node<T> newNode = new Node<T>(datum);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node<T> current = this.root;
            Node<T> parent;
            while (true) {
                parent = current;
                if (datum.compareTo(current.getDatum()) < 0) { // if datum is less than current, go left
                    current = current.getPrev();
                    if (current == null) {
                        parent.setPrev(newNode);
                        return;
                    }
                } else { // if datum is greater than current, go right
                    current = current.getNext();
                    if (current == null) {
                        parent.setNext(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Delete a node from the tree.
     *
     * @param datum
     */
    public void delete(T datum) {
        Node<T> current = this.root;
        Node<T> parent = this.root;
        boolean isLeftChild = true;
        while (current.getDatum() != datum) {
            parent = current;
            if (datum.compareTo(current.getDatum()) < 0) {
                isLeftChild = true;
                current = current.getPrev();
            } else {
                isLeftChild = false;
                current = current.getNext();
            }
            if (current == null) {
                return;
            }
        }
        if (current == this.root) {
            this.root = current.getNext();
        } else if (isLeftChild) {
            parent.setPrev(current.getNext());
        } else {
            parent.setNext(current.getNext());
        }
    }

    /**
     * Prints the tree in order starting at the root
     */
    public void printInOrder() {
        printInOrder(this.root);
    }

    /**
     * Prints the tree in order (left, root, right)
     *
     * @param node the node to print; if null, prints nothing
     */
    private void printInOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getPrev());
        System.out.println(node.getDatum());
        printInOrder(node.getNext());
    }

    /**
     * Print the tree in pre-order (root, left, right)
     */
    public void printPreOrder() {
        printPreOrder(this.root);
    }

    /**
     * Prints the tree in preorder.
     *
     * @param node
     */
    private void printPreOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getDatum());
        printPreOrder(node.getPrev());
        printPreOrder(node.getNext());
    }

    /**
     * Print the tree in postorder (left, right, root)
     */
    public void printPostOrder() {
        printPostOrder(this.root);
    }

    /**
     * Print the tree in postorder.
     *
     * @param node The root of the tree.
     */
    private void printPostOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.getPrev());
        printPostOrder(node.getNext());
        System.out.println(node.getDatum());
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeIterator(this.root);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        CryptoAlgorithms.shuffle(integers);
        for (Integer i : integers) {
            tree.insert(i);
        }

        System.out.println("In order:");
        tree.printInOrder();

        System.out.println("Pre order:");
        tree.printPreOrder();

        System.out.println("Post order:");
        tree.printPostOrder();

        System.out.println("Searching for 3:");
        System.out.println(tree.search(3));
        System.out.println(tree.search(1));
        System.out.println(tree.search(2));
        System.out.println(tree.search(4));
        System.out.println(tree.search(5));
        System.out.println(tree.search(6));

        System.out.println("Deleting 3:");
        tree.delete(3);
        tree.printInOrder();

        for (Integer n : tree) {
            System.out.println(n);
        }
    }
}
