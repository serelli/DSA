package com.algo.linkedlist;

public class ReorderList {

    public static void main(String[] args){
        ReorderList list = new ReorderList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        list.reorderList(node1);
    }

    public void reorderList(ListNode head) {

        ListNode slow =head;
        ListNode fast =head;
        while(fast !=null&& fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow);
        while(head!=slow){
            ListNode temp = head.next;
            head.next = second;
            head.next.next = temp;
            head = temp;
            second = second.next;
        }

        return;
    }
    public ListNode reverse(ListNode head){

        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
     //Definition for singly-linked list.
     static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }

         @Override
         public String toString() {
             return "ListNode{" +
                     "val=" + val +
                     ", next=" + next +
                     '}';
         }
     }
}
