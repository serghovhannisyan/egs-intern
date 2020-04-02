package com.egs.suzy.task3;

import com.egs.suzy.task3.CustomLinkedList.Node;

public class CustomLinkedListUtils {
    CustomLinkedListUtils() {

    }

    public static boolean detectLoop(Node head) {
        Node temp = new Node();
        while (head != null) {
            if (head.next == null) {
                return false;
            }
            if (head.next == temp)
                return true;
            Node next = head.next;
            head.next = temp;
            head = next;
        }
        return false;
    }

    public static Node findLastNthNode(Node head, int n) {
        Node slow = head, fast = head;
        int i = 0;
        if (head == null) {
            throw new NullPointerException("null list");
        }
        while (fast.next != null) {
            while (i < n) {
                fast = fast.next;
                i++;
            }
            slow = slow.next;
        }
        return slow;
    }
}
