package com.algo.string;

import java.util.*;
import java.util.stream.Collectors;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList();
        List<StringBuilder> current = new ArrayList();
        int numOfLetters = 0;

        for (String word : words) {
            StringBuilder w = new StringBuilder(word);

            if (numOfLetters + w.length() + current.size() > maxWidth) {

                for (int i = 0; i < (maxWidth - numOfLetters); i++) {
                    if (current.size() == 1) {
                        current.get(0).append(" ");
                    } else {
                        current.get(i % (current.size() - 1)).append(" ");
                    }
                }

                result.add(String.join("", current));
                            
                current = new ArrayList();
                numOfLetters = 0;
            }

            current.add(w);
            numOfLetters += w.length();

        }

        result.add(String.format("%-" + maxWidth + "s", String.join(" ", current)));

        return result;
    }

    public static void main(String[] args){
        TextJustification tj = new TextJustification();
        List<String> strings = tj.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);
        System.out.println(strings);
    }
}
