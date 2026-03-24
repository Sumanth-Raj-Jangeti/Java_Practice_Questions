package com.arrays.practice;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int k=3;
        rotate(arr,3);
        //Verification.
        for(int x:arr)
        {
            System.out.print(x+" ");
        }
    }
    //Method 1.
    public static void rotateArray(int[] arr,int k)
    {
        //TC:O(n*k) & SC:O(1)
        //To repeat for k-steps...
        for(int i=0;i<k;i++) //This runs for k times --> O(k)
        {
            rotateOneStep(arr); //This runs for n times --> O(n)
        }
    }
    public static void rotateOneStep(int[] arr)
    {
        //TC:O(n) & SC:O(1)
        //Rotating array to the right.
        int last=arr[arr.length-1]; //Here, we are storing the last element of the array.
        //Iterating from right to left.
        for(int i=arr.length-1;i>0;i--)
        {
            //Shifting elements to one step right.
            arr[i]=arr[i-1];
        }
        //After shifting --> updating the 0th index.
        arr[0]=last;
    }
    //Method 2.
    public static void rotateArr(int[] arr,int k)
    {
        //TC:O(n) & SC:O(n)
        //Creating a temp[]
        int[] temp=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            temp[(i+k)% arr.length]=arr[i];
        }
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=temp[i]; //copy back to original array
        }
    }
    //Method 3.
    public static void rotate(int[] arr,int k)
    {
        k = k % arr.length; //To reduce unnecessary rotations.
        //1. reverse entire array.
        reverse(arr,0,arr.length-1);
        //2. reverse a part of array from 0 to k-1 i.e 3-1=2
        reverse(arr,0,k-1);
        //3. Again, reverse a part of array from k to n-1
        reverse(arr,k,arr.length-1);
    }
    public static void reverse(int[] arr,int left,int right)
    {
        while(left < right)
        {
            //Swapping Logic.
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            //Move Pointers.
            left++;
            right--;
        }
    }
}
