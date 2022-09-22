package com.aping.algorithm.link;

/**
 * 反转部分单向链表
 *
 * @author Aping
 * @since 2022/9/3
 */
public class ReversePartLinkList {
    public static void main(String[] args) {

        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        node1.print();

        node1 = reversePart2(node1, 1, 5);

        node1.print();
    }


    public static Node<Integer> reversePart2(Node<Integer> head, int from, int to) {

        int length = 0;
        Node<Integer> temp = head;
        Node<Integer> fPre = null;
        Node<Integer> toNode = null;
        Node<Integer> tPos = null;
        while (temp != null) {
            length++;
            fPre = length == from - 1 ? temp : fPre;
            toNode = length == to ? temp : toNode;
            tPos = length == to + 1 ? temp : tPos;
            temp = temp.next;
        }

        toNode.next = null;

        Node<Integer> rNode = reverse(fPre == null ? head : fPre.next);

        if (fPre != null) {
            fPre.next = rNode;
        }
        temp = rNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = tPos;

        return fPre != null ? fPre : rNode;
    }


    public static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> pre = null;
        Node<Integer> next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static Node<Integer> reversePart(Node<Integer> head, int from, int to) {
        int len = 0;

        Node<Integer> node1 = head;
        Node<Integer> fPre = null;
        Node<Integer> tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }

        if (from > to || from < 1 || to > len) {
            return head;
        }

        node1 = fPre == null ? head : fPre.next;
        Node<Integer> node2 = node1.next;
        node1.next = tPos;
        Node<Integer> next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
