package org.example.lection_4;

import java.util.ArrayList;
import java.util.List;

public class SimpleTree {
    Node root;
    public class Node {
        int value;
        List<Node> children;
    }

    private Node findDeep(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child  : node.children) {
                Node result = findDeep(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
    public boolean exist(int value) {
        if (root != null) {
            Node node = findDeep(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    private Node findInDepth(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }
}
