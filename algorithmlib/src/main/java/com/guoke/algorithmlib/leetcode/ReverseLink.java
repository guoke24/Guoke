package com.guoke.algorithmlib.leetcode;

/**
 * 反转链表
 */
public class ReverseLink {

    public static void main(String[] args){
        // 构造一个链表
        Node n6 = new Node(6,null);
        Node n5 = new Node(5,n6);
        Node n4 = new Node(4,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);

        printLink(n1);

        reverseLink(n1);

        printLink(n6);
    }

    private static void reverseLink(Node root){
        if( root == null || root.next == null) return;

        Node cur = root;
        Node rear = root.next;
        Node temp = null;

        cur.next = null;

        while(rear != null){
            temp = rear.next; // 暂存
            rear.next = cur;  // 反转！
            cur = rear;  // 移到下一位
            rear = temp;
        }
    }

    private static void printLink(Node root){
        if (root != null) {
            System.out.print( root.value + " ");
            printLink(root.next);
        }else {
            System.out.println("");
        }

    }

    static class Node{
        Node next;
        int value;

        private Node(int v,Node next){
            this.value = v;
            this.next = next;
        }

    }

}
