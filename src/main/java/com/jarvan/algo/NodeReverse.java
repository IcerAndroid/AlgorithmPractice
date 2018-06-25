package com.jarvan.algo;

import java.util.Random;

/**
 * 链表翻转
 * 给定一个链表，翻转该链表从m到n的位置。
 * 注意要求是直接翻转而非申请新空间
 * 如：给定0→2→3→5→6→7，m=2,n=4，返回0→5→3→2→6→7
 * 假定给出的1 <= m <= n<= 链表长度
 */
public class NodeReverse {

    //分析：1、将链表空转m-1 找到位置的结点，即开始翻转的第一个结点的前驱，记做head；
    //     2、以Head为起始结点遍历n-m次，在第i次，将找到的结点插入到head的next中

    public static void reverse(Node head, int from, int to) {
        Node cur = head.next;
        int i;
        for (i = 0; i < from - 1; i++) {
            head = cur;
            cur = cur.next;
        }
        Node pre = cur;
        cur = cur.next;//m位置的结点
        Node pNext;
        for (; i < to - 1; i++) {
            pNext = cur.next;
            cur.next = head.next;
            head.next = cur;
            pre.next = pNext;
            cur = pNext;
        }
    }

    public static void main(String[] args) {
        Node pHead = NodeUtil.generateNode(false);
        NodeUtil.printNode(pHead);
        reverse(pHead, 2, 5);
        NodeUtil.printNode(pHead);
    }

}
