package com.aping.algorithm.link;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 反转链表
 * </p>
 *
 * @author Aping
 * @since 2022/9/19 11:47
 */
public class ReverseLinkList {

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

        node1 = reverse(node1);

        node1.print();
    }

    private static Node<Integer> reverse(Node<Integer> head) {
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

}
