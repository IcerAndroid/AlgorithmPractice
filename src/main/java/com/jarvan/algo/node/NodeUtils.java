package com.jarvan.algo.node;

import java.util.Arrays;
import java.util.Random;

public class NodeUtils {
    public static Node generateNode(boolean isSort) {
        Node pHead = new Node(0);
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(10) + 1;
        }
        if (isSort) {
            Arrays.sort(array);
        }
        Node cur = pHead;
        for (int i = 0; i < 10; i++) {
            Node p = new Node(array[i]);
            cur.next = p;
            cur = p;
        }
        return pHead;
    }

    public static void printNode(Node head) {
        Node p = head.next;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(p.data);
            p = p.next;
        }
        System.out.println(sb.toString());
    }
}
