package com.regex.practice;

public class Quantifiers {
    public static void main(String[] args) {
        String regex1 = "Welcome.*";
        String str1 = "Welcome to India";

        String regex2 = "Welcome to (India|Mysore)";
        String str2 = "Welcome to Mysore";

        String regex3 = "[^Welcome]";
        String str3 = "1";

        String regex4 = "[Employee].?";
        String str4 = "Employee";

        String regex5 = "[Employee].*";
        String str5 = "Employeee";

        String regex6 = "[P-Z]{8,10}";
        String str6 = "QRSTUVW";

        String regex7 = "[Employee]+";
        String str7 = "Employeeeeee";

        String regex8 = "[\\w]+ [\\w]+ [\\d]+";
        String str8 = "Java Training 123";

        String regex9 = "[\\w]+ [\\t] [\\w]+";
        String str9 = "Java 	 Training";

        String regex10 = "[\\w]+ [^\\w]+ [\\d]+";
        String str10 = "Java Training 123";

        String regex11 = "[\\D]+ [\\W]+";
        String str11 = "Java *";

        System.out.println("1:"+str1.matches(regex1));
        System.out.println("2:"+str2.matches(regex2));
        System.out.println("3:"+str3.matches(regex3));
        System.out.println("4:"+str4.matches(regex4));
        System.out.println("5:"+str5.matches(regex5));
        System.out.println("6:"+str6.matches(regex6));
        System.out.println("7:"+str7.matches(regex7));
        System.out.println("8:"+str8.matches(regex8));
        System.out.println("9:"+str9.matches(regex9));
        System.out.println("10:"+str10.matches(regex10));
        System.out.println("11:"+str11.matches(regex11));
    }
}
