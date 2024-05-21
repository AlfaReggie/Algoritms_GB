package org.example.seminar_3;

import java.util.Comparator;

public class LinkedListTest<R> {

    private Node head;

    public class Node {
        public Node next;
        public R value;
    }

    public void addFirst(R value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void removeFirst(R value) {
        if (head != null) {
            head = head.next;
        }
    }

    public void addLast(R value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        Node node = new Node();
        while (node.next != null) {
            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
        head = null;
    }

    public boolean contains(R value) {
        Node node = head;

        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void sort(Comparator<R> comparator) {
        Node node = head;
        while (node != null) {
            Node minValueNode = node;
            Node node2 = node.next;

            while (node2 != null) {
                if (comparator.compare(minValueNode.value, node2.value) > 0) {
                    minValueNode = node2;
                }
                node2 = node2.next;
            }

            if (minValueNode != node) {
                R buf = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buf;
            }

            node = node.next;
        }
    }

    public void reverse() {
        if (head != null) {
            Node next, curr = head, prev = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.value);
            node = node.next;
            if (node != null) {
                stringBuilder.append(';');
                stringBuilder.append('\n');
            }
        }
        stringBuilder.append(']');

        return stringBuilder.toString();
    }
}
