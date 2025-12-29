import java.util.Arrays;

public class Arrays6 {
    public static void main(String[] args) {
        int[] arr1={2,4,6};
        int[] arr2={1,3,5,7,9};
        mergeAlternatively(arr1,arr2);
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
        System.out.println("Merged Array-Alternatively:"+ Arrays.toString(mergedArray));
    }
}
