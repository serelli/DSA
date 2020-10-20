package com.algo.arraylist;

import java.util.Arrays;

public class ArrayList {


    private final int default_size =10;
    private int[] arr ;
    private int current_index;
    int size;
    public ArrayList(int size){
        arr = new int[size];
        current_index = -1;
        size = size;
    }
    public ArrayList(){
        arr = new int[default_size];
        current_index = -1;
        size = default_size;
    }

    @Override
    public String toString() {
        return "ArrayListCustom{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                ", current_index=" + current_index +
                '}';
    }
    public void customToString() {
        System.out.print("[");
        for(int i =0 ;i<this.current_index+1;i++){
            System.out.print(this.arr[i]);
            if(i!=current_index)
            System.out.print(",");
        }
        System.out.print("]");
    }



    public void add(int val){
        if(current_index+1<size){
            arr[++current_index] = val;
        }else {
            int[] newArray = new int[size*2];
            System.arraycopy(arr,0,newArray,0,size);
            arr = newArray;
            size = size*2;
            arr[++current_index] = val;
        }

    }


    public static void main(String[] args){
        ArrayList custom = new ArrayList();
        for(int i =1; i<45;i++){
            custom.add(i);
        }
        System.out.println(custom.toString());
        custom.customToString();
    }

}

