import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Arrays7 {
    public static void main(String[] args) {
        //A program to find duplicate elements in an array...
        int[] arr1={1,4,6,5,2,1,7,2,1,2}; //Modified because of index marking
        duplicates(arr1);      //Method Call - Nested Approach
        uniqueDuplicates(arr1);//Method Call - Nested Approach with a feature(print duplicates only once)
        knowDuplicates(arr1);  //Method Call - Sorted+scan
        fastDuplicates(arr1);  //Method Call - Freq[] Approach
        findDuplicates(arr1);  //Method Call - HashSet Approach
        searchDuplicates(arr1);//Method Call - HashMap Approach
        //extractDuplicates(arr1);//Method Call - Index Marking Approach
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
        System.out.println("\nDuplicates by using sorted+scan:");
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
    public static void fastDuplicates(int[] arr) //TC:O(n) & SC:O(n)
    {
        //By using freq[].But this method fails if array has -ve values, elements are large.
        int max=arr[0];
        for(int i=1;i< arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        //Creating a freq[].
        int[] freq=new int[max+1];
        //Store freq's of each element in freq[].
        for(int i=0;i<freq.length;i++)
        {
            freq[arr[i]]++;
        }
        System.out.println("\nDuplicates by using freq[]:");
       /* for (int i=0;i< freq.length;i++) //It doesn't preserve the original order
        {
            if(freq[i]>1)
            {
                System.out.print(i+" ");
            }
        }*/
        for(int i=0;i<arr.length;i++) //Preserves the original order
        {
            if(freq[arr[i]]>1)
            {
                System.out.print(arr[i]+" ");
                freq[arr[i]]=0;
            }
        }
    }
    public static void findDuplicates(int[] arr) //TC:O(n) & SC:O(n)
    {                                            //Handles -ve values.
        LinkedHashSet<Integer> set=new LinkedHashSet<>(); //To preserve the insertion order...
        HashSet<Integer> duplicates=new HashSet<>();
        for(int numbers:arr)
        {
            //If the number already in set then it is a duplicate.
            if(!set.add(numbers))
            {
                duplicates.add(numbers);
            }
        }
        //System.out.println("\nUnique Elements are:"+set);
        System.out.println("\nDuplicate Elements by using HashSet:"+duplicates);
    }
    public static void searchDuplicates(int[] arr)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr)
        {
            //counting freq's...
            if(map.containsKey(num)) //.containsKey(obj key)->checks if key exists or not & it returns true or false.
            {
                map.put(num,map.get(num)+1);
            }
            else
            {
                map.put(num,1);
            }
        }
        System.out.println("Duplicates by using HashMap:");
        for(int key:map.keySet()) //.keySet()->returns a set of all keys.
        {
            if(map.get(key)>1)  //.get(obj key)->returns a value for the key (or) null if key is not found.
            {
                System.out.println(key);
            }
        }
        /*
        for(int num:arr)
        {
             map.put(num,map.getOrDefault(num,0)+1)
        }
        sout("Duplicate Elements:");
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
             if(entry.getValue()>1)
             {
                 sout(entry.getKey());
             }
        }
         */
    }
    public static void extractDuplicates(int[] arr) //TC:O(n) & SC:O(1)
    {   //Index Marking...
        System.out.print("Duplicates Elements by using Index Marking:");
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index] > 0) {
                arr[index] = -arr[index]; // first visit
            }
            else if (arr[index] < 0) {
                System.out.print(index + " ");
                arr[index] = 0;   // mark as already printed
            }
        }
    }
}
