package org.example.intermediateCertification;

class RBNode {
    int value;
    String color;
    RBNode parent, left, right;

    public RBNode(int value) {
        this.value = value;
        color = "RED"; // Новые узлы всегда красные
        parent = left = right = null;
    }
}

public class RBTree {
    private RBNode root;

    public RBTree() {
        root = null;
    }

    // Вспомогательный метод для левого поворота
    private void leftSwap(RBNode rbNode) {
        RBNode rbyNode = rbNode.right;
        rbNode.right = rbyNode.left;
        if (rbyNode.left != null)
            rbyNode.left.parent = rbNode;
        rbyNode.parent = rbNode.parent;
        if (rbNode.parent == null)
            root = rbyNode;
        else if (rbNode == rbNode.parent.left)
            rbNode.parent.left = rbyNode;
        else
            rbNode.parent.right = rbyNode;
        rbyNode.left = rbNode;
        rbNode.parent = rbyNode;
    }

    // Вспомогательный метод для правого поворота
    private void rightSwap(RBNode rbyNode) {
        RBNode rbxNode = rbyNode.left;
        rbyNode.left = rbxNode.right;
        if (rbxNode.right != null)
            rbxNode.right.parent = rbyNode;
        rbxNode.parent = rbyNode.parent;
        if (rbyNode.parent == null)
            root = rbxNode;
        else if (rbyNode == rbyNode.parent.right)
            rbyNode.parent.right = rbxNode;
        else
            rbyNode.parent.left = rbxNode;
        rbxNode.right = rbyNode;
        rbyNode.parent = rbxNode;
    }

    // Метод для добавления нового элемента
    public void insert(int value) {
        RBNode newNode = new RBNode(value);
        if (root == null) {
            root = newNode;
            root.color = "BLACK"; // Корень всегда черный
            return;
        }
        insertHelper(root, newNode);
        rebalanced(newNode);
    }

    // Вспомогательный метод для добавления нового элемента
    private void insertHelper(RBNode root, RBNode newNode) {
        if (root.value < newNode.value) {
            if (root.right == null) {
                root.right = newNode;
                newNode.parent = root;
            } else
                insertHelper(root.right, newNode);
        } else {
            if (root.left == null) {
                root.left = newNode;
                newNode.parent = root;
            } else
                insertHelper(root.left, newNode);
        }
    }

    // Метод для балансировки дерева
    private void rebalanced(RBNode node) {
        RBNode parent, grandparent;
        while (node != root && node.color.equals("RED") && node.parent.color.equals("RED")) {
            parent = node.parent;
            grandparent = parent.parent;
            if (parent == grandparent.left) {
                RBNode uncle = grandparent.right;
                if (uncle != null && uncle.color.equals("RED")) {
                    grandparent.color = "RED";
                    parent.color = "BLACK";
                    uncle.color = "BLACK";
                    node = grandparent;
                } else {
                    if (node == parent.right) {
                        leftSwap(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rightSwap(grandparent);
                    String temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            } else {
                RBNode uncle = grandparent.left;
                if (uncle != null && uncle.color.equals("RED")) {
                    grandparent.color = "RED";
                    parent.color = "BLACK";
                    uncle.color = "BLACK";
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        rightSwap(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    leftSwap(grandparent);
                    String temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            }
        }
        root.color = "BLACK";
    }

    // Вспомогательный метод для вывода дерева в порядке возрастания
    private void ascendOutAssist(RBNode root) {
        if (root != null) {
            ascendOutAssist(root.left);
            System.out.println(root.value + " " + root.color);
            ascendOutAssist(root.right);
        }
    }

    // Метод для вывода дерева в порядке возрастания
    public void ascendOut() {
        ascendOutAssist(root);
    }

    public static void main(String[] args) {
        RBTree tree = new RBTree();
        int[] elements = {5, 6, 8, 12, 3, 1, 76, 89, 34, 56, 23};
        for (int element : elements) {
            tree.insert(element);
        }
        tree.ascendOut();
    }
}
