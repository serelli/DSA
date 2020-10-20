package com.algo.stackexamples;

import java.util.Arrays;

public class CustomStack<E> {

    private E[] array;
    private int curr_size;
    private int current_index;
    private static final int default_size = 10;

    @SuppressWarnings("unchecked")
    public CustomStack(int size){

        this.array = (E[]) new Object[size];
        this.current_index= -1;
        this.curr_size=size;
    }

    public CustomStack(){
        this(default_size);
    }

    public void push(E element){
        array[++current_index] = element;
        if(current_index==curr_size-1){
            increaseSizeOfArray();
        }
    }

    public void increaseSizeOfArray(){
        int newSize = 2*curr_size;
        this.array = Arrays.copyOf(this.array,newSize);
        curr_size=newSize;
    }

    public E peek(){
        if(current_index==-1)
            throw new NullPointerException();
        return array[current_index];
    }
    public E pop(){
        if(current_index ==-1)
            throw new NullPointerException();
        E result = array[current_index];
        array[current_index--] = null; //prevent memory leak
        return result;
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "array=" + Arrays.toString(array) +
                ", curr_size=" + curr_size +
                ", current_index=" + current_index +
                '}';
    }

    public static void main(String[] args){
        CustomStack<String> stack = new CustomStack<>();
        stack.push("sandeep");
        System.out.println(stack);
        stack.push("navya");
        System.out.println(stack);
        stack.push("drishya");
        for(int i =0;i<14;i++){
            stack.push("drishya"+i);
            System.out.println(stack);
        }
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
    }

}
