import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        //A program to convert a given string to uppercase without using built-in methods
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String:");
        String str=sc.nextLine();
        StringBuilder upper=new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch!=' ')
            {
                ch=(char)(ch-32);
            }
            upper.append(ch);
        }
        System.out.println("Upper Case:"+upper);
    }
}
