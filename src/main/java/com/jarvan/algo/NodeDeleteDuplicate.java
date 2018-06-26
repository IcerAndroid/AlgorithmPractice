package com.jarvan.algo;

/**
 * 给定排序的链表，删除重复的元素，只保留重复元素的第一个出现的结点
 * 分析：若p.next的值和p的值相等，则将p.next.next的值赋给p;重复上述过程，直至链表尾端。
 */
public class NodeDeleteDuplicate {
    public static void main(String[] args) {
        Node node = NodeUtils.generateNode(true);
        NodeUtils.printNode(node);
        // deleteDuplicate(node);
        deleteDuplicate3(node);
        NodeUtils.printNode(node);
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

    public static void deleteDuplicate2(Node head) {
        Node pPre = head;
        Node pCur = pPre.next;
        Node pNext;
        while (pCur != null) {
            pNext = pCur.next;
            while (pNext != null && pCur.data == pNext.data) {
                pPre.next = pNext;
                pCur = pNext;
                pNext = pCur.next;
            }
            pPre = pCur;
            pCur = pNext;
        }
    }

    //删除所有的重复数据
    public static void deleteDuplicate3(Node head) {
        Node pPre = head;
        Node pCur = pPre.next;
        Node pNext;
        boolean isDup;
        while (pCur != null) {
            isDup = false;
            pNext = pCur.next;
            while (pNext != null && pCur.data == pNext.data) {
                pPre.next = pNext;
                pCur = pNext;
                pNext = pCur.next;
                isDup = true;
            }
            if (isDup) {
                pPre.next = pNext;
            } else {
                pPre = pCur;
            }
            pCur = pNext;
        }
    }


}
