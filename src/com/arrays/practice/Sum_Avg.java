package com.arrays.practice;

public class Sum_Avg {
    public static void main(String[] args) {
        //A program to find the sum & avg of elements in an array
        int[] arr1={10,20,30,40,50};
        sum_avgAll(arr1);
        int[] arr2={-3,-2,0,-7,25,12,-11};
        sum_avgOnlyPositives_Negatives(arr2);
        int[] arr3={1,4,6,5,2,1,7,2,1,2};
        sum_avgOnlyDistinct(arr3);
        sum_avgOnlyUnique(arr3);
    }
    public static void sum_avgAll(int[] arr)
    {
        System.out.println("\nFor All Elements:");
        int sum=0;
        double avg;
        for (int j : arr) {
            sum += j;
        }
        avg=(double) sum/arr.length;
        System.out.println("Sum of all Elements in the array:"+sum+"\nAvg of all elements in the array:"+avg);
    }
    public static void sum_avgOnlyPositives_Negatives(int[] arr)
    {
        int p_sum=0,p_count=0,n_sum=0,n_count=0;
        double p_avg,n_avg;
        System.out.println("\nPositive No.s:");
        for(int num:arr) {
            if (num > 0) {
                System.out.print(num + " ");
                p_sum += num;
                p_count++;
            }
        }
        System.out.println("\nNegative No.s:");
        for(int num:arr)
        {
            if (num<0){
                System.out.print(num+" ");
                n_sum+=num;
                n_count++;
            }
        }
        p_avg=(double)p_sum/p_count;
        n_avg=(double)n_sum/n_count;
        System.out.print("\nSum of +ve Elements:"+p_sum+"\nAvg of +ve Elements:"+ p_avg);
        System.out.print("\nSum of -ve Elements:"+n_sum+"\nAvg of -ve Elements:"+ n_avg);
    }
    public static void sum_avgOnlyDistinct(int[] arr)
    {   //Same remove duplicates logic.
        System.out.println("\n\nDistinct Elements:");
        int sum=0,count=0;
        double avg;
        for(int i=0;i<arr.length;i++)
        {
            boolean isDistinct=false;
            //Check if arr[i] has appeared before.
            for(int k=0;k<i;k++)
            {
                if(arr[k]==arr[i])
                {
                    isDistinct=true;
                    break;
                }
            }
            if(!isDistinct)
            {
                System.out.print(arr[i]+" ");
                sum+=arr[i];
                count++;
            }
        }
        avg=(double) sum/count;
        System.out.print("\nSum of Distinct Elements:"+sum+"\nAvg of Distinct Elements:"+avg);
    }
    public static void sum_avgOnlyUnique(int[] arr)
    {
        /*System.out.println("\n\nUnique Elements:");
        int u_sum=0,u_count=0;
        for(int i=0;i<arr.length;i++)
        {
            int freq=0;
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    freq++;
                }
            }
            if(freq==1)
            {
                System.out.print(arr[i]+" ");
                u_sum+=arr[i];
                u_count++;
            }
        }
        double u_avg=(double) u_sum/u_count;
        System.out.println("\nSum of Unique Elements:"+u_sum+"\nAvg of Unique Elements:"+u_avg);
        */
        //Method 2.
        System.out.println("\n\nUnique Elements:");
        int u_sum=0,u_count=0;
        //1. Find the max element.
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max=arr[i];
        }
        //2. Determine the size.
        int size=max+1;
        //3. Creating a freq[].
        int[] freq=new int[size];
        //4. Store freq's of each element in freq[].
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]]++;
        }
        //5. Print Unique Elements.
        for(int i=0;i<arr.length;i++)
        {
            if(freq[arr[i]]==1)
            {
                System.out.print(arr[i]+" ");
                u_sum+=arr[i];
                u_count++;
            }
        }
        double u_avg=(double) u_sum/u_count;
        System.out.println("\nSum of Unique Elements:"+u_sum+"\nAvg of Unique Elements:"+u_avg);
    }
}
