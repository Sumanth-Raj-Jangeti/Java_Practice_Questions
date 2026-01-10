public class Arrays10{
    public static void main(String[] args) {
        //A program to common elements in 2 arrays...
        int[] a={1,4,6,5,2,1,7,2,1,2};
        int[] b={2,4,4,5,5};
        commonEle(a,b); //Method Call
        commonUniqueEle(a,b);//Method Call

    }
    public static void commonEle(int[] arr1,int[] arr2)
    {   //1. Nested Approach --> TC:O(n * m) & SC:O(1) - This approach also prints duplicates.
        System.out.println("Common Elements(Nested Loops):");
        for (int x : arr1) {
            for (int y : arr2) {
                if (x == y) {
                    System.out.print(x + " ");
                    break;
                }
            }
        }
    }
    public static void commonUniqueEle(int[] arr1,int[] arr2)
    {   //2. Nested Approach --> TC:O(n * m) & SC:O(1) - This method avoids printing the same duplicates again.
        System.out.println("\nCommon Elements(Nested Loops with a feature):");
        for(int i=0;i<arr1.length;i++) //TC:O(n)
        {
            boolean alreadyChecked=false;
            //Check if arr1[i] has appeared before.
            for(int k=0;k<i;k++)      //TC:O(n)
            {
                if(arr1[k]==arr1[i])
                {
                    alreadyChecked=true;
                    break;
                }
            }
            if(alreadyChecked)
                continue;
            for(int j=0;j< arr2.length;j++)  //TC:O(m)
            {
                if(arr1[i]==arr2[j])
                {
                    System.out.print(arr1[i]+" ");
                    break;
                }
            }
        }
    }
    public static void findCommonEle(int[] arr1,int[] arr2)
    {
        //Using Sorting + 2 Pointers --> TC:O(n log n +m log m) & SC:O(1) - This approach also prints duplicates...

    }
}