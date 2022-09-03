package com.aping.algorithm.link;

/**
 * @author Aping
 * @since 2022/9/3
 */
public class Node<T> {
    public final T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void print() {
        Node<T> thisNode = this;
        System.out.print(thisNode.value.toString());
        while (thisNode.next != null) {
            thisNode = thisNode.next;
            System.out.print(" -> " + thisNode.value.toString());
        }
        System.out.print("\n");
    }
}
