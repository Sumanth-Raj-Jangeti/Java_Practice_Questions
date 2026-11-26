package com.strings.practice;

import java.util.*;

public class MaximumNumOfNonOverlappingSubStrings_LC1520 {
    public static void main(String[] args) {
        String str = "adefaddaccc";
        System.out.println(maxNumOfSubstrings(str));
    }
    public static List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        //We can start by finding the starting and ending index for each character.
        int[] start = new int[26];
        int[] end = new int[26];
        boolean[] isValid = new boolean[26];
        Arrays.fill(start,-1);
        Arrays.fill(isValid,true);
        for(int i=0;i<n;i++){
            int index = s.charAt(i) - 'a';
            if(start[index] == -1){
                start[index] = i;
            }
            end[index] = i;
        }
        //From these indices, we can form the substrings by expanding each character's range.
        //Extend end index & mark invalid if possible...
        for(int currChar=0;currChar<26;currChar++){
            if(start[currChar] == -1) continue;
            for(int i=start[currChar];i<=end[currChar];i++){
                int ch = s.charAt(i) - 'a';
                if(start[ch] < start[currChar]){
                    isValid[currChar] = false;
                    break;
                }
                end[currChar] = Math.max(end[currChar],end[ch]);
            }
        }
        List<String> result = new ArrayList<>();
        int lastTakenStart = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            int index = s.charAt(i) - 'a';
            if(!isValid[index]) continue;
            if(i == start[index] && end[index] < lastTakenStart){
                result.add(s.substring(i,end[index]+1));
                lastTakenStart = i;
            }
        }
        return result;
    }
}
/*
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        String s = "adefaddaccc";
        Map<Character, int[]> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!indexMap.containsKey(c)) {
                indexMap.put(c, new int[]{i, i});
            } else {
                indexMap.get(c)[1] = i; // update end index
            }
        }
        for (Map.Entry<Character, int[]> entry : indexMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "': [" +
                    entry.getValue()[0] + ", " +
                    entry.getValue()[1] + "]");
        }
    }
}*/
