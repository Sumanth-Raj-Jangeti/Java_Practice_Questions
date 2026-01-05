public class Arrays9 {
    public static void main(String[] args) {
       int[] a={1,4,6,5,2,1,7,2,1,2};
       int sum=0,p_count=0;
       double avg=0;
       for(int i=0;i<a.length;i++)
       {
           int n=a[i]; //Storing all array elements one by one is n
           int factorCount=0;
           for(int j=1;j<=n;j++)
           {
               if(n%j==0)
               {
                   factorCount++;
               }
           }
           if(factorCount==2)
           {
               System.out.println("Index:"+i+" has a prime-->"+n);
               sum+=n;
               p_count++;
               avg=(double) sum/p_count;
           }
       }
        System.out.println("Total no,of Primes:"+p_count);
        System.out.println("Sum of Primes:"+sum);
        System.out.println("Avg of primes:"+avg);
    }
}
