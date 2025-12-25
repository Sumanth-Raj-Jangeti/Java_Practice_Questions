import java.util.Scanner;

public class Primes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("PRIME CALCULATIONS");
        System.out.println("Enter a Number to check whether a number is prime or not:");
        int num=sc.nextInt();
        isPrime(num); //Method Call
        System.out.println("Enter Start and End Values:");
        int start=sc.nextInt();
        int end=sc.nextInt();
        rangeOfPrime(start,end); //Method Call
        System.out.println("Enter a Number to print prime digits:");
        int number=sc.nextInt();
        extractPrimeDigits(number); //Method Call
    }
    public static void isPrime(int n) //To check whether a given number is prime or not.
    {
        int factorCount=0; //This is a Local Variable-> u can use the same name in other methods also...
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
            {
                factorCount++;
            }
        }
        if(factorCount==2)
        {
            System.out.println(n+" is prime.");
        }
        else {
            System.out.println(n+" is not prime.");
        }
    }
    public static void rangeOfPrime(int a,int b) //This method prints prime no.s within a given range...
    {
        int p_count=0; // To count total no.of prime no.s
        System.out.println("Prime No.s Between "+a+" and "+b+" are:");
        for (int i=a;i<=b;i++)
        {
            int factorCount=0;
            for(int j=1;j<=i;j++)
            {
                if(i%j==0)
                    factorCount++;
            }
            if (factorCount==2)
            {
                System.out.print(i+" ");
                p_count++;
            }
        }
        System.out.println("\nTotal No.of Prime No.s between "+a+" and "+b+" are:"+p_count);
    }
    public static void extractPrimeDigits(int n)  //input:123456789 output:2357
    {
        int prime_count=0,p_sum=0;
        double p_avg;
        System.out.println("\nPrime Digits:");
        while(n!=0)
        {
            int rem=n%10; //Extract the last digit
            int factorCount=0;
            for (int i=1;i<=rem;i++)
            {
                if(rem%i==0)
                {
                    factorCount++;
                }
            }
            if(factorCount==2)
            {
                System.out.print(rem+" ");
                prime_count++;
                p_sum+=rem;
            }
            //Update the n value
            n=n/10;
        }
        p_avg=(double) p_sum/prime_count;
        System.out.println("\nTotal No.of Prime Digits in a given number:"+prime_count+",their Sum is:"+p_sum+",their avg is:"+p_avg);
    }
}
