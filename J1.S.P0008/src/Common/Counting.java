/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author 84945
 */
public class Counting {
    public static Map<String, Integer> countCharacter(String s) {
        Map<String, Integer> characterCounts = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(s);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            if (characterCounts.containsKey(word)) {
                int count = characterCounts.get(word);
                characterCounts.put(word, count + 1);
            } else {
                characterCounts.put(word, 1);
            }
        }
        return characterCounts;
    }

    public static void displayCharacterCounts(Map<String, Integer> characterCounts) {
        System.out.print("{");
        for (Map.Entry<String, Integer> entry : characterCounts.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("}");
    }
    
    public static Map<Character, Integer> countLetters(String s) {
        Map<Character, Integer> letterCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowercase = Character.toLowerCase(c);
                if (letterCounts.containsKey(lowercase)) {
                    int count = letterCounts.get(lowercase);
                    letterCounts.put(lowercase, count + 1);
                } else {
                    letterCounts.put(lowercase, 1);
                }
            }
        }
        return letterCounts;
    }

    public static void displayLetterCounts(Map<Character, Integer> letterCounts) {
        System.out.print("{");
        for (Map.Entry<Character, Integer> entry : letterCounts.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("}");
    }
}
