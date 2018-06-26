package com.jarvan.algo;

/**
 * 找出两个链表的公共结点
 */
public class NodeCommon {

    public static void main(String[] args) {
        Node nodeA = NodeUtils.generateNode(false);
        Node nodeB = NodeUtils.generateNode(false);
        NodeUtils.printNode(nodeA);
        NodeUtils.printNode(nodeB);
        findFirstSame(nodeA, nodeB);
    }

    private static Node findFirstSame(Node headA, Node headB) {
        int lenA = 0, lenB = 0;
        Node p = headA;
        while (p != null) {
            lenA++;
            p = p.next;
        }
        p = headB;
        while (p != null) {
            lenB++;
            p = p.next;
        }

        Node pa = headA;
        Node pb = headB;
        if (lenA > lenB) {
            for (int diff = lenA - lenB; diff > 0; diff--) {
                pa = pa.next;
            }
        } else {
            for (int diff = lenB - lenA; diff > 0; diff--) {
                pb = pb.next;
            }
        }
        while (pa != null) {
            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }
}
