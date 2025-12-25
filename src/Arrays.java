public class Arrays {
    public static void main(String[] args) {
        //A program to find the sum & avg of elements in an array
        int[] arr={10,20,30,40,50};
        int sum=0;
        double avg=0;
        for (int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        System.out.println("Sum of Elements in the array:"+sum);
        avg=(double) sum/ arr.length;
        System.out.println("Avg of elements int the array:"+avg);
    }
}
