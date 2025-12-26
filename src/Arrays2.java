import java.util.Arrays;

public class Arrays2 {
    public static void main(String[] args) {
        // A program to add 2 arrays
        int[] arr1={1,2,3,4,5};
        int[] arr2={6,7,8,9};
        //Creating object to call non-static methods
        Arrays2 a=new Arrays2();
        a.sumArrays(arr1,arr2); //Method Call
        //Calling static methods
        sumOfArrays(arr1,arr2); //Method Call
    }
    public void sumArrays(int[] arr1,int[] arr2) //Works only if both array lengths are same.
    {
        //Check if 2 arrays are of same length
        if(arr1.length==arr2.length)
        {
            //creating a new array to store the result
            int[] res=new int[arr1.length];
            for(int i=0;i<arr1.length;i++)
            {
                res[i]=arr1[i]+arr2[i];
            }
            System.out.println("Resultant Array:"+ Arrays.toString(res));
        }
        else {
            System.out.println("Arrays are not of same length cannot be added...");
        }
    }
    public static void sumOfArrays(int[] arr1,int[] arr2) //Works for different lengths also.
    {
        int n1=arr1.length;
        int n2=arr2.length;
        //Determine the larger size
        int maxSize=Math.max(n1,n2);
        //Creating a new array to store the result
        int[] result=new int[maxSize];
        //Adding Arrays...
        for(int i=0;i<maxSize;i++)
        {
            int value1=(i<n1)?arr1[i]:0;
            int value2=(i<n2)?arr2[i]:0;
            result[i]=value1+value2;
        }
        System.out.println("Resultant Array:"+Arrays.toString(result));
    }
}
