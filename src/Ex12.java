import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        //A program to find fibonacci Series using recursion.
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number:");
        int num=sc.nextInt();
        System.out.println("Fibonacci Series:");
        for(int i=0;i<num;i++)
        {
            System.out.print(fibonacci(i)+" ");
        }
    }
    public static int fibonacci(int n)
    {
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
