package com.algo.linkedlist;

public class DoublyLinkedListNode<T> {

    public T value;
    public DoublyLinkedListNode<T> prev;
    public DoublyLinkedListNode<T> next;


    public DoublyLinkedListNode(T value){
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedListImpl{

    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public void addLast(Integer value){
        DoublyLinkedListNode<Integer> new_node = new DoublyLinkedListNode<>(value);

        if(head==null){
            head = tail = new_node;
            head.prev =null;
            tail.next = null;
        }else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
        }

    }

    public void addFirst(Integer value){
        DoublyLinkedListNode<Integer> new_node = new DoublyLinkedListNode<Integer>(value);

        if(head==null){
            head = tail = new_node;
            head.prev =null;
            tail.next = null;
        }else {
            head.prev = new_node;
            new_node.next = head;
            head = new_node;
        }

    }

    public void printElements(DoublyLinkedListNode head){

        while(head!=null){
            System.out.print(head.value);
            head= head.next;
        }
    }
    public void printElementsReverse(DoublyLinkedListNode tail){

        while(tail!=null){
            System.out.print(tail.value);
            tail= tail.prev;
        }
    }

}

class MainTest{
    public static void main(String[] args){
        DoublyLinkedListImpl doublyLinkedList = new DoublyLinkedListImpl();

        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);
        doublyLinkedList.addFirst(4);
        doublyLinkedList.addFirst(5);

        doublyLinkedList.addLast(6);
        doublyLinkedList.addLast(7);
        doublyLinkedList.addLast(8);
        doublyLinkedList.addLast(9);
        doublyLinkedList.addLast(10);


        doublyLinkedList.printElements(doublyLinkedList.head);
        System.out.println();
        doublyLinkedList.printElementsReverse(doublyLinkedList.tail);
    }
}
