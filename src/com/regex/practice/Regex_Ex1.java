package com.regex.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Ex1 {
    public static void main(String[] args) {
        int count=0;
        Pattern p = Pattern.compile("ab");
        Matcher m = p.matcher("ababbaba"); //This is our target string
        while(m.find()) //If match is present then stmts inside while will be executed.
        {
            count++;
            System.out.println(m.start()+"..."+m.end()+"..."+m.group());
            /*
                start() -  returns the 1st index
                end() - returns last index + 1
                group() - if you want to know what is matched...  then use group()
            */
        }
        System.out.println("\nTotal no.of occurrences:"+count);
    }
}
