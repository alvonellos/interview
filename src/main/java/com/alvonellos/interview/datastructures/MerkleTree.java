package com.alvonellos.interview.datastructures;
import java.util.ArrayList;
import java.util.Iterator;

import static com.alvonellos.interview.util.crypto.CryptoAlgorithms.sha512;


public class MerkleTree<T extends Comparable<T>> extends BinaryTree<T> implements Iterable<T> {
    public MerkleTree() {
        super();
    }

    public static Node generateTree(ArrayList<String> dataBlocks) {
        ArrayList<Node> childNodes = new ArrayList<>();

        for (String message : dataBlocks) {
            childNodes.add(new Node(null, null, sha512(message)));
        }

        return buildTree(childNodes);
    }

    private static Node buildTree(ArrayList<Node> children) {
        ArrayList<Node> parents = new ArrayList<>();

        while (children.size() != 1) {
            int index = 0, length = children.size();
            while (index < length) {
                Node leftChild = children.get(index);
                Node rightChild = null;

                if ((index + 1) < length) {
                    rightChild = children.get(index + 1);
                } else {
                    rightChild = new Node(null, null, leftChild.getDatum());
                }

                String parentHash = sha512(leftChild.getDatum() + (String) rightChild.getDatum());
                parents.add(new Node(leftChild, rightChild, parentHash));
                index += 2;
            }
            children = parents;
            parents = new ArrayList<>();
        }
        return children.get(0);
    }

    public static void main(String... args) {
        ArrayList<String> dataBlocks = new ArrayList<>();
        dataBlocks.add("2112 ethereum");
        dataBlocks.add("merkle trees");
        dataBlocks.add("content addressability");
        MerkleTree<String> tree = new MerkleTree<>();
        tree.root = generateTree(dataBlocks);
        for (Iterator<String> it = tree.iterator(); it.hasNext(); ) {
            String node = it.next();
            System.out.println(node);
        }
        System.out.println(tree.root.getDatum());
    }
}
