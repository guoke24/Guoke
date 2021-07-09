package com.guoke.algorithmlib.interview;

/**
 * 字节一面
 * 合并两个有序的链表，合并后依然有序
 */
public class MergeLink {

    public static void main(String[] args){
        ListNode a4 = new ListNode(7);
        ListNode a3 = new ListNode(5,a4);
        ListNode a2 = new ListNode(3,a3);
        ListNode a1 = new ListNode(1,a2);

        ListNode b6 = new ListNode(12);
        ListNode b5 = new ListNode(10,b6);
        ListNode b4 = new ListNode(8,b5);
        ListNode b3 = new ListNode(6,b4);
        ListNode b2 = new ListNode(4,b3);
        ListNode b1 = new ListNode(2,b2);

        ListNode root = mergeTwoLists1(a1,b1);

        printList(root);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 实现合并链表
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode cursor = new ListNode();
        ListNode head = cursor;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cursor.next = l1;
                cursor = l1;
                l1 = l1.next;
            }else{
                cursor.next = l2;
                cursor = l2;
                l2 = l2.next;
            }
        }

        if(l1 != null){
            cursor.next = l1;
        }else{
            cursor.next = l2;
        }

        return head.next;
    }

    private static void printList(ListNode root){
        while(root!=null){
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}
