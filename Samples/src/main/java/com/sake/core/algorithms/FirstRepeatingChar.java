package com.sake.core.algorithms;

import java.util.*;

/**
 * Created by sakez on 07/08/17
 * This class returns the first repeating character a string
 */
public class FirstRepeatingChar {

    public static void main(String[] args) {

        String s = firstRepeatingLetter("babcba");
        System.out.println(s);

    }

    public static String firstRepeatingLetter(String document){
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        char[] charArr = document.toCharArray();

        for (char c : charArr) {
            if(charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            }
            else {
                charMap.put(c, 1);
            }
        }

        for (Map.Entry<Character,Integer> entry : charMap.entrySet()) {
            if(entry.getValue()>1){
                return String.valueOf(entry.getKey());
            }
        }
        return "";
    }
}
