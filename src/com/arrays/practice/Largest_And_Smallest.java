package com.arrays.practice;

public class Largest_And_Smallest {
    public static void main(String[] args) {
        int[] arr={1,4,6,5,2,1,7,2,1,2};
        findFirstLargestSmallest(arr);
        findSecondLargestSmallest(arr);
        findThirdLargestSmallest(arr);
    }
    public static void findFirstLargestSmallest(int[] arr)
    {
        System.out.println("FIRST LARGEST & SMALLEST:");
        int largest=Integer.MIN_VALUE;//-2147483648 --> Because any number in your array will definitely be greater than this.
        int smallest=Integer.MAX_VALUE;//2147483647 --> Because any number in your array will definitely be less than this.
        //We need to iterate over the array.
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>largest)
            {
                largest=arr[i];
            }
            if(arr[i]<smallest)
            {
                smallest=arr[i];
            }
        }
        System.out.println("First Largest Element:"+largest+"\nFirst Smallest Element:"+smallest);
    }
    public static void findSecondLargestSmallest(int[] arr)
    {
        System.out.println("\nSECOND LARGEST & SMALLEST:");
        int largest=Integer.MIN_VALUE;
        int secondLargest= Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;
        //We need to iterate over the array.
        for(int i=0;i<arr.length;i++)
        {
            //Largest
            if(arr[i]>largest)
            {
                secondLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest && arr[i]!=largest)
            {
                secondLargest=arr[i];
            }
            //smallest
            if(arr[i]<smallest)
            {
                secondSmallest=smallest;
                smallest=arr[i];
            }
            else if(arr[i]<secondSmallest && arr[i]!=smallest)
            {
                secondSmallest=arr[i];
            }
        }
        System.out.println("First Largest:"+largest+",Second Largest:"+secondLargest);
        System.out.println("First Smallest:"+smallest+",Second Smallest:"+secondSmallest);
    }
    public static void findThirdLargestSmallest(int[] arr)
    {
        System.out.println("\nTHIRD LARGEST & SMALLEST:");
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        int thirdLargest=Integer.MIN_VALUE;

        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;
        int thirdSmallest=Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            //Largest
            if(arr[i]>largest)
            {
                thirdLargest=secondLargest;
                secondLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest && arr[i]!=largest)
            {
                thirdLargest=secondLargest;
                secondLargest=arr[i];
            }
            else if(arr[i]>thirdLargest && arr[i]!=largest && arr[i]!=secondLargest)
            {
                thirdLargest=arr[i];
            }

            //Smallest
            if(arr[i]<smallest)
            {
                thirdSmallest=secondSmallest;
                secondSmallest=smallest;
                smallest=arr[i];
            }
            else if(arr[i]<secondSmallest && arr[i]!=smallest)
            {
                thirdSmallest=secondSmallest;
                secondSmallest=arr[i];
            }
            else if(arr[i]<thirdSmallest && arr[i]!=smallest && arr[i]!=secondSmallest)
            {
                thirdSmallest=arr[i];
            }
        }
        System.out.println("First Largest:"+largest+",Second Largest:"+secondLargest+",Third Largest:"+thirdLargest);
        System.out.println("First Smallest:"+smallest+",second Smallest:"+secondSmallest+",Third Smallest:"+thirdSmallest);
    }
}
