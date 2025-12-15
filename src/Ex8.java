import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        //A program to count the freq of a given char...
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String:");
        String str=sc.nextLine();
        System.out.println("Enter a Character to count:");
        char targetchar=sc.next().charAt(0);
        int count=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==targetchar)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
