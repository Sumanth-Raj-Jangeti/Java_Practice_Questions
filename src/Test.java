import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the values of a,b and c:");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        System.out.println("Addition of "+a+" and "+b+" is:"+add(10,20));       //Method Call
        System.out.println("Addition of "+a+","+b+" and "+c+" is:"+add(10,20,30)); //Method Call
    }
    public static int add(int a,int b)
    {
        return a+b;
    }
    public static int add(int a,int b,int c)
    {
        return a+b+c;
    }
}
