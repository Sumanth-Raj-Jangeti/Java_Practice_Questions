package com.recursion.practice;

public class CountOccurrences_of_a_word {
    public static int countSubstring(String inputString, String substring, int count) {
        if (inputString.length() < substring.length()) {
            return count;
        }
        // check if substring matches at beginning
        if (inputString.startsWith(substring)) {
            count++;
        }
        // recursive call (move one character forward)
        return countSubstring(inputString.substring(1), substring, count);
    }
    public static void main(String args[]) {
        int count = countSubstring("I felt happy because I saw the others were Happy and because I knew I should feel happy, but I was not really happy","happy", 0);
        System.out.println(count);
    }
}

