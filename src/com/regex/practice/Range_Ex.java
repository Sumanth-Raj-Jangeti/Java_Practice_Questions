package com.regex.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Range_Ex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher("a7b@Z#9");
        while(matcher.find()){
            System.out.println(matcher.start()+"...."+matcher.group());
        }
    }
}
/*
* Predefined character Class...
*  . -> any char
* \w -> any word char & the underscore sign "_" eg:[a-zA-Z0-9_]
* \W -> non word chars eg:[^a-zA-Z0-9_]
* \d -> digits
* \D -> non digits
* \s -> whitespace chars
* \S -> non whitespace chars

* [abc]       -> a or b or c
* [^abc]      -> except a or b or c
* [a-z]       -> Any LC char
* [A-Z]       -> Any UC char
* [^a-z]      -> except LC char
* [^A-Z]      -> except UC char
* [a-zA-Z]    -> any LC,UC char
* [0-9]       -> any digit 0-9
* [a-zA-Z0-9] -> Any alphanumeric char
* */