package com.strings.practice;

class CheckPalindrome {
    public static void main(String[] args){
        String str = "radar";
        if(checkPalindrome(str))
            System.out.println("The string is a palindrome!");
        else
            System.out.println("The string is not a palindrome!");
    }
    public static boolean checkPalindrome(String str){
        StringBuilder sbl = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            sbl.append(str.charAt(i));
        }
        String revStr = sbl.toString();
        return str.equals(revStr);
    }
}
