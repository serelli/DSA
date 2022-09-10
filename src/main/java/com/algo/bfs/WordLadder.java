package com.algo.bfs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength2bfs("hit", "cog", Arrays.asList("hit", "hot", "dot", "dog", "cog")));

    }

    //one-way bfs search
    public int ladderLength(String beginWord, String endWord, List<String> list) {

        Set<String> set = new HashSet<>(list);
        if (set.isEmpty())
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(beginWord, 1));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            String tempWord = temp.word;
            if (tempWord.equals(endWord))
                return temp.level;


            for (int i = 0; i < tempWord.length(); i++) {
                char[] charArray = tempWord.toCharArray();
                char tempChar = charArray[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (tempChar != ch) {
                        charArray[i] = ch;
                        String wordSoFar = String.valueOf(charArray);
                        System.out.println(wordSoFar);
                        if (set.contains(wordSoFar)) {
                            queue.offer(new Node(wordSoFar, temp.level + 1));
                        }
                    }
                }
                charArray[i] = tempChar;
            }
        }

        return 0;


    }

    class Node {
        String word;
        int level;

        public Node(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    // two end bfs
    public int ladderLength2bfs(String beginWord, String endWord, List<String> list) {

        Set<String> wordSet = new HashSet<>(list);
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visitSet = new HashSet<>();

        if (!wordSet.contains(endWord))
            return 0;
        beginSet.add(beginWord);
        endSet.add(endWord);

        int len = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> tempSet = new HashSet<>();

            for (String word : beginSet) {

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char temp = chars[i];
                        chars[i] = ch;
                        if (endSet.contains(String.valueOf(chars)))
                            return len + 1;
                        if (!visitSet.contains(String.valueOf(chars)) && wordSet.contains(String.valueOf(chars))) {
                            tempSet.add(String.valueOf(chars));
                            visitSet.add(String.valueOf(chars));
                        }
                        chars[i] =temp;
                    }
                }

            }
            beginSet = tempSet;
            len++;

        }
        return 0;
    }


}
