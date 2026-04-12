package com.OOPs.practice;

import java.util.Scanner;

/*
    Problem Statement:
    You are given N bank Transactions.
    Each transaction has : sender receiver amount timestamp
    --> A transaction is considered fraud if
        1. sender,receiver and amount are same.
        2. timestamp difference is <= 60 seconds
    Find and print all such fraud transactions.
    Example:
    INPUT:                     OUTPUT:
    5
    ANU JON 200.50 1000        ANU JON 200.50 1050
    ANU JON 200.50 1050        RAM SAM 300.00 2050
    RAM SAM 300.00 2000
    ANU JON 200.50 2000
    RAM SAM 300.00 2050
 */
class Transactions
{
    //Declaring instance var's.
    String sender;
    String receiver;
    double amount;
    long timeStamp;

    //Creating a constructor.
    public Transactions(String sender,String receiver,double amount,long timeStamp)
    {
        this.sender=sender;
        this.receiver=receiver;
        this.amount=amount;
        this.timeStamp=timeStamp;
    }
}
public class Concept1EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of transactions:");
        int n=sc.nextInt();
        //Creating an array of type Transactions.
        Transactions[] t = new Transactions[n];
        System.out.println("Enter Inputs:(Reference - sender receiver amount timeStamp)");
        //taking input from user.
        for(int i=0;i<n;i++)
        {
            t[i]=new Transactions(sc.next(),sc.next(),sc.nextDouble(), sc.nextLong());
        }
        //FRAUD TRANSACTIONS
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(t[j].timeStamp-t[i].timeStamp <= 60)
                {
                    if(t[j].sender.equals(t[i].sender) && (t[j].receiver.equals(t[i].receiver)) && t[i].amount==t[j].amount)
                    {
                        System.out.print(t[j].sender+" "+t[j].receiver+" ");
                        System.out.printf("%.2f",t[j].amount);
                        System.out.println(" "+t[j].timeStamp);
                    }
                }
            }
        }
    }
}
