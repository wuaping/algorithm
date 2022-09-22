package com.aping.algorithm.link;

/**
 * <p>
 * 链表重排序
 * </p>
 *
 * @author Aping
 * @since 2022/9/13 21:18
 */
public class ReorderLinkList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.print();
        reorderList(node1);
        node1.print();
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode temp = head;
        int length = 1;

        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        if (length == 2) {
            return;
        }
        temp = head;
        ListNode mid;
        for (int i = 1; i < length >> 1; i++) {
            temp = temp.next;
        }
        mid = temp.next;

        ListNode list1 = head;
        ListNode list2 = reverseList(mid);

        ListNode next1 = head.next;
        ListNode next2 = list2.next;
        while (next2 != null) {
            list1.next = list2;
            list2.next = next1;

            list1 = next1;
            list2 = next2;

            next1 = next1.next;
            next2 = next2.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (head.next != null) {
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }
        head.next = pre;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public void print() {
            ListNode cur = this;
            System.out.print(val);
            while (cur.next != null) {
                cur = cur.next;
                System.out.print(" -> " + cur.val);
            }
            System.out.print("\n");
        }
    }
}
