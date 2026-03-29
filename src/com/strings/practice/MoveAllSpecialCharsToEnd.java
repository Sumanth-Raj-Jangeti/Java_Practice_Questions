package com.strings.practice;

public class MoveAllSpecialCharsToEnd {
    public static void main(String[] args) {
        String str = "He@#$llo!*&";
        System.out.println("Original String:"+str);
        System.out.println("Modified String:"+moveSpecialCharsToEnd(str));
    }
    public static String move(String str)
    {
        //Creating two Strings.
        String letters = "";
        String specialChars = "";
        //Iterating over the given string.
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                letters += ch;
            }else{
                specialChars += ch;
            }
        }
        return (letters +specialChars);
    }
    public static String moveSpecialCharacters(String str)
    {
        StringBuilder letters = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(Character.isLetter(ch))
            {
                letters.append(ch);
            }
            else{
                specialChars.append(ch);
            }
        }
        return (letters.toString() + specialChars.toString());
    }
    public static String moveSpecialCharsToEnd(String str)
    {
        //Using two pointers technique --> TC:O(n) & SC:O(1)
        //Creating a char[]
        char[] arr = str.toCharArray();
        int j=0; // A new index for overwriting array elements...
        for(int i=0;i<arr.length;i++){
            if(Character.isLetter(arr[i])){
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp; // gets all letters to the start of the array.
                j++;
            }
        }
        //Now I'll pass this modified char[] to str obj.
        return new String(arr);
    }
}
