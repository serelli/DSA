package com.algo.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

     private final TrieNode root;
     public Trie(){
         root = new TrieNode();
     }

     // iterative implementation of insert into trie
    public void insert(String word){
         TrieNode current = root;
         for(int i=0;i<word.length();i++){
             char ch = word.charAt(i);
             TrieNode node = current.children.get(ch);
             if(node==null){
                 node = new TrieNode();
                 current.children.put(ch, node);
             }
             current = node;
         }
         current.endOfWord = true;
    }

    // recursive way of insertion

    public void insertRec(String word){
         insertRecursivley(word, root, 0);
    }

    public void insertRecursivley(String word, TrieNode current, int index){


         if(index==word.length()) {
             current.endOfWord=true;
             return;
         }

         char ch = word.charAt(index);
         TrieNode node = current.children.get(ch);

         if(node==null){
             node = new TrieNode();
             current.children.put(ch,node);
         }
         insertRecursivley(word,node,index+1);
    }

    public boolean search(String word){
         TrieNode current = root;

         for(int i=0;i<word.length();i++){
             char ch = word.charAt(i);
             TrieNode node = current.children.get(ch);
             if(node==null)
                 return false;
             current = node;
         }
         return current.endOfWord;
    }

    // recursive way of search

    public boolean searchRecur(String word){

         return searchRecur(word,root,0);
    }

    public boolean searchRecur(String word, TrieNode current, int index){

         if(index==word.length())
             return current.endOfWord;
         char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null)
            return false;
        return searchRecur(word,node,index+1);
    }

    // recursive way of deleteTrieNode
    public boolean deleteTrieNode(String word){
         return deleteTrieNode(word,root, 0);
    }

    public boolean deleteTrieNode(String word, TrieNode current, int index){
         if(index== word.length()){
             if(!current.endOfWord) {
                 return false;
             }
             current.endOfWord=false;
             return current.children.size()==0;
         }
         char ch = word.charAt(index);
         TrieNode node = current.children.get(ch);
         if(node==null)
             return false;
         boolean shouldDeleteCurrentNode = deleteTrieNode(word,node,index+1);
         if(shouldDeleteCurrentNode){
             current.children.remove(ch);
             return current.children.size()==0;
         }
         return false;
    }
    
    class TrieNode{
        Map<Character,TrieNode> children;
        boolean endOfWord;
        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }
}
