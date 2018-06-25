package com.jarvan.algo;

/**
 * 给定排序的链表，删除重复的元素，只保留重复元素的第一个出现的结点
 * 分析：若p.next的值和p的值相等，则将p.next.next的值赋给p;重复上述过程，直至链表尾端。
 */
public class NodeDeleteDuplicate {
    public static void main(String[] args) {
        Node node = NodeUtil.generateNode(true);
        NodeUtil.printNode(node);
        deleteDuplicate(node);
        NodeUtil.printNode(node);
    }

    public static void deleteDuplicate(Node head) {
        Node pPre = head.next;
        Node pCur;

        while (pPre != null) {
            pCur = pPre.next;
            if (pCur != null && pCur.data == pPre.data) {
                pPre.next = pCur.next;
            } else {
                pPre = pCur;
            }
        }

    }

}
