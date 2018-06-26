package com.jarvan.algo.node;

/**
 * 给定一个链表和一个值X，将链表划分两部分，使得划分部分后小于X的结点在前，大于等于X的结点在后，
 * 这两部分中要保持原来链表的出现顺序
 */
public class NodeDivision {
    public static void main(String[] args) {
        Node node = NodeUtils.generateNode(false);
        NodeUtils.printNode(node);
        divisionNode(node,4);
        NodeUtils.printNode(node);
    }

    public static void divisionNode(Node head, int pivotKey) {
        Node pLeftHead = new Node(0);
        Node pRightHead = new Node(0);

        Node left = pLeftHead;
        Node right = pRightHead;
        Node p = head.next;
        while (p != null) {
            if (p.data < pivotKey) {
                left.next = p;
                left = p;
            } else {
                right.next = p;
                right = p;
            }
            p = p.next;
        }
        left.next = pRightHead.next;
        right.next = null;
        head.next = pLeftHead.next;
    }
}
