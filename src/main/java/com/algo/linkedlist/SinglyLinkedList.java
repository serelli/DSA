package com.algo.linkedlist;

public class SinglyLinkedList {


    public static void main(String[] args){

        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkListNode node1 = new SinglyLinkListNode(1);
        SinglyLinkListNode node2 = new SinglyLinkListNode(2);

        SinglyLinkListNode node3 = new SinglyLinkListNode(3);

        SinglyLinkListNode node4 = new SinglyLinkListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SinglyLinkListNode res = list.reverseLinkedListRecursive(node1);
        while(res!=null){
            System.out.println(res.val);
            res= res.next;
        }

    }
     // iterative way of reversing linkedList
    public SinglyLinkListNode reverseLinkedListIterative(SinglyLinkListNode head){

        SinglyLinkListNode prev = null;
        SinglyLinkListNode curr = head;

        while(curr!=null){
            SinglyLinkListNode temp =  curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }

    // recursive way of reversing Linkedlist
    public SinglyLinkListNode reverseLinkedListRecursive(SinglyLinkListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        //just return last node and append nodes to it.
        SinglyLinkListNode prev = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return prev;

    }

}
