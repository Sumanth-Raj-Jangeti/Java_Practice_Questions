import java.util.Arrays;
import java.util.HashSet;

public class Arrays7 {
    public static void main(String[] args) {
        //A program to find duplicate elements in an array...
        int[] arr1={1,4,6,5,2,1,7,2,1,2};
        int[] arr2={8,8,9,9,9,1,2,2,5,5,5,10,10};
        duplicates(arr1);      //Method Call
        uniqueDuplicates(arr1);//Method Call
        knowDuplicates(arr2);  //Method Call
        findDuplicates(arr1);  //Method Call
        extractDuplicates(arr1);//Method Call
    }
    public static void duplicates(int[] arr) //TC:O(n^2) & SC:O(1)-> in-place
    {
        System.out.println("Duplicates by using Nested Loops:");
        for (int i=0;i< arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    System.out.print(arr[i]+" ");
                    break;
                }
            }
        }
    }
    public static void uniqueDuplicates(int[] arr) //TC:O(n^2) & SC:O(1)-> in-place
    {
        System.out.println("\nDuplicates using Nested-Loops & Avoid Printing same duplicates:");
        for(int i=0;i< arr.length;i++)
        {
            boolean alreadyChecked=false;
            //Check if arr[i] element has appeared before or not...
            for(int k=0;k<i;k++) //k always starts with '0' when outer loop begins...
            {
                if(arr[k]==arr[i])
                {
                    alreadyChecked=true;
                    break;
                }
            }
            if(alreadyChecked)
                continue;
            for(int j=i+1;j< arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    System.out.print(arr[i]+" ");
                    break;
                }
            }
        }
    }
    public static void knowDuplicates(int[] arr) //TC:O(n log n) & SC:O(1)-> in-place
    {
        Arrays.sort(arr); //Sorts the array->This method is used only when array order is not mandatory...
        System.out.println("\nDuplicate elements are:");
        for(int i=1;i< arr.length;i++)
        {
            if(arr[i]==arr[i-1]) //finds duplicates.
            {
                if(i==1||arr[i]!=arr[i-2]) //Avoids printing same duplicates.
                {
                    System.out.print(arr[i]+" ");
                }
            }
        }
    }
    public static void findDuplicates(int[] arr) //TC:O(n) & SC:O(n)
    {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> duplicates=new HashSet<>();
        for(int numbers:arr)
        {
            //If the number already in set then it is a duplicate.
            if(!set.add(numbers))
            {
                duplicates.add(numbers);
            }
        }
        System.out.println("\nDuplicate Elements by using HashSet:"+duplicates);
    }
    public static void extractDuplicates(int[] arr) //TC:O(n) & SC:O(1)
    {   //Index Marking...
        System.out.print("Duplicates Elements by using Index Marking:");
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index] < 0) {
                System.out.print(index + " ");
                arr[index] = 0;   // mark as already printed
            }
            else if (arr[index] > 0) {
                arr[index] = -arr[index]; // first visit
            }
        }
    }
}
