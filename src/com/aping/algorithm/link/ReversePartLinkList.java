package com.aping.algorithm.link;

/**
 * 反转部分单向链表
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

        node1 = reversePart(node1, 1, 3);

        node1.print();
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
