package com.strings.practice;

import java.util.HashMap;
import java.util.Map;

public class Find_HighestOccurrence {
    public static void main(String[] args) {
        String str = "success";
        System.out.println(highestOccurrence(str));
    }
    public static int findHighestOccurrence(String str)
    {
        //Creating a freq[].
        int[] freq=new int[256];
        //Store freq's of each & every character in freq[]
        for(int i=0;i<str.length();i++)
        {
            freq[str.charAt(i)]++;
        }
        int high=0;
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]>high)
            {
                high=freq[i];
            }
        }
        return high;
    }
    public static int highestOccurrence(String str)
    {
        //Converting a string to char[].
        char[] chars = str.toCharArray();
        //Creating a map & storing <K,V> pairs where, keys=chars & Values=freq's
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<chars.length;i++)
        {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        int max=0;
        for(char key:map.keySet())
        {
            if(map.get(key)>max)
            {
                max=map.get(key);
            }
        }
        return max;
    }
}
