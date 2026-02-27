package com.arrays.practice;

import java.util.*;

public class Largest_And_Smallest {
    public static void main(String[] args) {
        int[] arr={1,4,6,5,2,1,7,2,1,2};
        findFirstLargestSmallest(arr);
        findSecondLargestSmallest(arr);
        findThirdLargestSmallest(arr);
        //To find kth Largest element...
        int k=4;
        Integer result=findKthLargestElement(arr,k);
        System.out.println("\n"+k+"th Largest Element:"+result);
        //To find kth smallest element...
        Integer res=findKthSmallestElement(arr,k);
        System.out.println("\n"+k+"th Smallest Element:"+res);
        //To find K largest elements
        findKLargestElements(arr,k);
        //To find K Smallest elements
        findKSmallestElements(arr,k);
    }
    public static void findFirstLargestSmallest(int[] arr)
    {
        //To find firstLargest and firstSmallest --> TC:O(n) & SC:O(1)
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
        //Single Traversal Comparison Technique --> TC:O(n) & SC:O(1)
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
        //Single Traversal Comparison Technique --> TC:O(n) & SC:O(1)
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
    public static Integer findKthLargestElement(int[] arr,int k)
    {
        //Here we are using priority queue
        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        //We need to iterate over the given array
        for(int i=0;i<arr.length;i++)
        {
            pq_min.offer(arr[i]);
            if(pq_min.size()>k)
            {
                pq_min.poll();
            }
        }
        return pq_min.peek();
    }
    public static Integer findKthSmallestElement(int[] arr,int k)
    {
        //here we'll use only distinct elements
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());
        //Since we have duplicates in the array --> to remove them we use HashSet.
        HashSet<Integer> set = new HashSet<>();
        //We need to iterate over the given array.
        for (int j : arr) {
            set.add(j); //Duplicates are automatically removed.
        }
        for(int num:set)
        {
            pq_max.offer(num);
            if(pq_max.size()>k)
            {
                pq_max.poll();
            }
        }
        return pq_max.peek();
    }
    public static void findKLargestElements(int[] arr,int k)
    {

        //Here we are using priority queue
        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        //We need to iterate over the given array
        for (int j : arr) //TC:O(n)
        {
            pq_min.offer(j); //TC:O(log k)
            if (pq_min.size() > k) //TC:O(1)
            {
                pq_min.poll();//TC:O(log k)
            }
        }
        int[] res=new int[k];
        int newIndex=0;
        while(!pq_min.isEmpty())
        {
            res[newIndex++]=pq_min.poll();
        }
        System.out.println("\n"+k+" largest Elements:");
        for(int i=res.length-1;i>=0;i--) //TC:O(n)
        {
            System.out.print(res[i]+" ");
        }
    }
    public static void findKSmallestElements(int[] arr,int k)
    {
        //Since we have duplicates in the array --> to remove them we use Set.
        Set<Integer> set = new LinkedHashSet<>();
        //We need to iterate over the given array.
        for (int j : arr) {
            set.add(j); //Duplicates are automatically removed.
        }
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:set) //here we'll use only distinct elements
        {
            pq_max.offer(num);
            if(pq_max.size()>k) //We are exceeding heap to grow.
            {
                pq_max.poll(); //removes all largest elements
            }
        }
        int[] res=new int[k];
        int index=0;
        while(!pq_max.isEmpty())
        {
            res[index++]= pq_max.poll();
        }
        System.out.println("\n"+k+" Smallest Elements:");
        for(int i=res.length-1;i>=0;i--)
        {
            System.out.print(res[i]+" ");
        }
    }
}
