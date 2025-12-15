import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        // A prog to convert an integer to binary number
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number:");
        int n=sc.nextInt();
        String binary=Integer.toBinaryString(n);
        System.out.println("Binary form of "+n+" is:"+binary);

        //Convert binary to a number
        System.out.println("Enter a binary Number:");
        String binary1=sc.next();
        int num=Integer.parseInt(binary1,2);
        System.out.println("Number for the "+binary1+" is:"+num);
    }
}
