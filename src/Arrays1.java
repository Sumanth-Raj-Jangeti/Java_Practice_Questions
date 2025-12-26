public class Arrays1 {
    public static void main(String[] args) {
        //A program to print,count & return indexes for even & odd no.s in an array.
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int e_count=0,o_count=0;
        for(int i=0;i<arr.length;i++)
        {
            if((arr[i]&1)==0)
            {
                e_count++;
                System.out.println(arr[i]+" is even and its index is:"+i);
            }
            else
            {
                o_count++;
                System.out.println(arr[i]+" is odd and its index is:"+i);
            }
        }
        System.out.println("Total Even Numbers:"+e_count);
        System.out.println("Total Odd Numbers:"+o_count);
    }
}
