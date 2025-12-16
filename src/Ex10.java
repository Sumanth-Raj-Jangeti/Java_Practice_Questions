import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        //A program to convert a given string to uppercase & Lowercase without using built-in methods
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String to convert into Uppercase:");
        String str=sc.nextLine();
        toUpper(str); //Method Call
        System.out.println("Enter a String to convert into lowercase:");
        String str1=sc.nextLine();
        toLower(str1); //Method Call
    }
    public static void toUpper(String s)
    {
        StringBuilder upper=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch>='a'&&ch<='z')
            {
                ch=(char)(ch-32);
            }
            upper.append(ch);
        }
        System.out.println("Upper Case:"+upper);
    }
    public static void toLower(String s1)
    {
        StringBuilder lower=new StringBuilder();
        for(int i=0;i<s1.length();i++)
        {
            char ch=s1.charAt(i);
            if(ch>='A'&&ch<='Z')
            {
                ch=(char)(ch+32);
            }
            lower.append(ch);
        }
        System.out.println("Lower Case:"+lower);
    }
}
