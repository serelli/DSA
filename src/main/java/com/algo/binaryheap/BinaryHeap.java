package com.algo.binaryheap;


import java.lang.reflect.Array;
import java.util.Arrays;

/*
Let us first define a Complete Binary Tree. A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible
A Binary Heap is a Complete Binary Tree where items are stored in a special order such that value in a parent node is greater(or smaller) than the values in its two children nodes. The former is called as max heap and the latter is called min heap. The heap can be represented by binary tree or array.

1) BinaryHeap is a binary tree which is complete except the last level all its levels are strictly completely filled.(all nodes are as left as possible)
2) A BinaryHeap is either a min-heap or a max-heap and is suitable to be store in array.
3) BinaryHeap has many applications like implementation of priority Queue, heap sort etc.

Binary Heap properties
1) It's a complete tree(all levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of binaryheap makes them suitable to be stored in an array.
2) A Binary heap is either min heap or max heap. In a min binary heap, the key at root must be minimum among all keys present in Binary heap. The same property must be recursively true for all nodes in Binary tree.
How is Binary tree represented?
A Binary tree is a complete binary tree, A Binary heap is typically represented as an array.
The root element will be at Arr[0]
below table shows indexes of other nodes for the ith node, i.e.,Arr[i];
Arr[(i-1)/2] returns the parent node.
Arr[(2*i)+1] returns the left child node.
Arr[(2*i)+2] returns the right child node.
The traversal method used to achieve Array representation is level order.
Last internal node in a binary heap is at index (N-2)/2 (where N is mumber of nodes)

Priority Queue is used when the objects are supposed to be processed based on the priority. It is known that a queue follows FIFO algorithm. but sometimes the elements of the queue are needed to be processed according to the priority that's when the priority queue comes into play. the priority queue is based on the priority heap.

priority queue is implemented using Heap data structures and heap has O(log n) time complexity to insert and delete element.
Poll() or remove() -> log(n)
element retrieval peek() min or max based on heap -> O(1)
insert -> log(n)
contains -> O(n)
 */
public class BinaryHeap<T extends Comparable<T>> {
    protected T[] heap;
    protected final int maxSize;
    protected int size;
    public BinaryHeap(Class<T> clazz, int maxSize){
        this.heap = (T[]) Array.newInstance(clazz,maxSize);
        this.maxSize= maxSize;
        this.size=0;
    }

    @Override
    public String toString() {
        return "BinaryHeap{" +
                "heap=" + Arrays.toString(heap) +
                ", maxSize=" + maxSize +
                ", size=" + size +
                '}';
    }

    // inserts an element into the heap.
    public void insert(T data) throws HeapException{
        if(this.size>=this.maxSize){
            throw new HeapException();
        }
        this.heap[this.size]=data;
        upHeap();
        this.size++;
    }
    /* percolates-up/heapify or bubbles-up an item from the bottom of the heap (tail of the array) into its
    appropriate spot, following the rules of a min heap property.
     */

    protected void upHeap(){
        int currentIndex = this.size;
        while(currentIndex>0){
            int parentIndex = (currentIndex-1)/2;
            if(upHeapComparator(currentIndex,parentIndex)){
                break;
            }
            swap(currentIndex,parentIndex);
            currentIndex= parentIndex;
        }
    }

    protected boolean upHeapComparator(int xIndex, int yIndex){
        return this.heap[xIndex].compareTo(this.heap[yIndex])>=0;
    }

    /*
    method used to swap two items within the underlying heap array

     */
    protected void swap(int xIndex, int yIndex) throws IndexOutOfBoundsException{
        if(xIndex>this.size || yIndex> this.size)
            throw new IndexOutOfBoundsException();

        T temp = this.heap[xIndex];
        this.heap[xIndex] = this.heap[yIndex];
        this.heap[yIndex] = temp;
    }

    /*
    determines whether or not the heap contains any elements
     */
    public boolean isEmpty(){
        return this.size<=0;
    }

    public T getExtreme() throws HeapException{
        if(isEmpty()){
            throw new HeapException();
        }
        return this.heap[0];
    }

    /*
    Returns & removes the current extreme value from within the heap, replacing the old extreme value with the next candidate.
     */
    public T removeExtreme() throws HeapException{
        if(isEmpty()){
            throw new HeapException();
        }
        T extreme = this.heap[0];
        this.heap[0]= this.heap[this.size-1];
        this.heap[this.size-1] = null;
        this.size--;
        downHeap();
        return extreme;
    }
    /*
    percolates-down an item from the top of the heap (head of the array) into it's appropriate spot, following the rules of the underlying heap class.

     */
    protected void downHeap(){
        int currentIndex = 0;
        for(int left = 2* currentIndex+1;left<size; left=2*currentIndex+1){
            int right = left+1;
            int extremeIndex = right<size?findExtremeIndex(left, right):left;
            if(!downHeapComparator(currentIndex, extremeIndex)){
                     return;
            }
            swap(currentIndex, extremeIndex);
            currentIndex = extremeIndex;
        }
    }
    protected boolean downHeapComparator(int xIndex, int yIndex){
        return this.heap[xIndex].compareTo(this.heap[yIndex])>=0;
    }

    protected int findExtremeIndex(int leftIndex, int rightIndex){
        return this.heap[leftIndex].compareTo(this.heap[rightIndex])>=0?rightIndex:leftIndex;
    }

    public static void main(String[] args) throws HeapException{
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(Integer.class,5);
        binaryHeap.insert(4);
        binaryHeap.insert(2);
        binaryHeap.insert(3);
        binaryHeap.insert(1);
        binaryHeap.insert(5);
        System.out.println(binaryHeap);

        System.out.println(binaryHeap.removeExtreme());
        System.out.println(binaryHeap);
        binaryHeap.insert(6);

        System.out.println(binaryHeap);

        System.out.println(binaryHeap.removeExtreme());
        System.out.println(binaryHeap);
        System.out.println(binaryHeap.removeExtreme());
        System.out.println(binaryHeap);
    }
}


