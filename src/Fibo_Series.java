import java.util.Scanner;

public class Fibo_Series {
    public static void main(String[] args) {
        /*Scanner sc=new Scanner(System.in);
        System.out.println("Enter Start:");
        int start=sc.nextInt();
        System.out.println("Enter End:");
        int end=sc.nextInt();
        int n1=0,n2=1,sum;
        System.out.println("Fibonacci Series within a given range:");
        while(n1<=end)
        {
            if(n1>=start)
            {
                System.out.print(n1+" ");
            }
            sum=n1+n2;
            n1=n2;
            n2=sum;
        }*/
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number:");
        int n=sc.nextInt();
        int n1=0,n2=1,sum=0;
        System.out.println("Fibonacci Series:");
        System.out.print(n1+" "+n2);
        int i=2;//Because we already printed two values
        while(i<n)
        {
            sum=n1+n2;
            System.out.print(" "+sum);
            n1=n2;
            n2=sum;
            i++;
        }
    }
}
