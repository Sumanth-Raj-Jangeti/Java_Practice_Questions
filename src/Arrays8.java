import java.util.Arrays;

public class Arrays8 {
    public static void main(String[] args) {
        //A program to remove duplicates from an array...
        int[] arr={1,4,6,5,2,1,7,2,1,2};
        int[] uniqueArr= removeDuplicates(arr);
        System.out.println("Array after removing duplicates:"+Arrays.toString(uniqueArr));
    }
    public static int[] removeDuplicates(int[] arr)
    {
        //Creating a temp[] to store unique elements.
        int[] temp=new int[arr.length];
        int uniqueCount=0; //Global Scope
        for (int k : arr) {
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++)  //j value always starts with '0'
            {
                if (k == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            //If not a duplicate then add it to temp[]
            if (!isDuplicate) {
                temp[uniqueCount++] = k;
            }
        }
        //Copy elements from temp[] to an array of correct size...
        return Arrays.copyOf(temp,uniqueCount);
    }
}
