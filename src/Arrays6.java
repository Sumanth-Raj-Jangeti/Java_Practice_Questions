import java.util.Arrays;
import java.util.stream.IntStream;

public class Arrays6 {
    public static void main(String[] args) {
        int[] arr1={2,4,6};
        int[] arr2={1,3,5,7,9};
        mergeAlternatively(arr1,arr2); //Method Call
        mergeSorted(arr1,arr2);        //Method Call
        merge(arr1,arr2);              //Method Call
    }
    public static void mergeAlternatively(int[] arr1,int[] arr2)
    {
        int n1=arr1.length;
        int n2=arr2.length;
        //Determine the larger length...
        int maxLength=Math.max(n1,n2);
        //Creating a new array to store the result...
        int[] mergedArray=new int[n1+n2];
        int k=0;
        //We need to loop through the maximum length of 2 arrays...
        for (int i=0;i<maxLength;i++)
        {
            if(i<n1)
            {
                mergedArray[k++]=arr1[i]; //Selects elements from 1st array.
            }
            if (i<n2)
            {
                mergedArray[k++]=arr2[i]; //Selects elements from 2nd array.
            }
        }
        System.out.println("Merged Array(Alternatively):"+ Arrays.toString(mergedArray));
    }
    public static void mergeSorted(int[] arr1,int[] arr2)
    {
        int n1=arr1.length;
        int n2=arr2.length;
        //Creating a new array to store the result...
        int[] mergedArray=new int[n1+n2];
        int i=0,j=0,k=0;
        //Merge elements in sorted order.
        while(i<n1&&j<n2)
        {
            if(arr1[i]<arr2[j])
            {
                mergedArray[k++]=arr1[i++]; //Selects element from arr1
            }
            else {
                mergedArray[k++]=arr2[j++]; //Selects element from arr2
            }
        }
        //Now we need to copy the remaining elements from arr1.
        while (i<n1)
        {
            mergedArray[k++]=arr1[i++];
        }
        //Now we need to copy the remaining elements from arr2.
        while (j<n2)
        {
            mergedArray[k++]=arr2[j++];
        }
        System.out.println("Merged Array in sorted order:"+Arrays.toString(mergedArray));
    }
    public static void merge(int[] arr1,int[] arr2) //By using streams...
    {
        int[] merged= IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).toArray();
        System.out.println("Merged Array:"+Arrays.toString(merged));
    }
}
