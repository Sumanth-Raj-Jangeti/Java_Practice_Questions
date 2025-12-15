import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        //Find the max and min word in a string
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String:");
        String str=sc.nextLine();
        //Split the string
        String[] words=str.split(" ");
        String maxword=words[0];
        String minword=words[0];
        int max_index=0,min_index=0;
        for(int i=1;i< words.length;i++)
        {
            if (words[i].length()>maxword.length())
            {
                maxword=words[i];
                max_index=i;
            }
            if(words[i].length()<minword.length())
            {
                minword=words[i];
                min_index=i;
            }
        }
        System.out.println("Max word  : " + maxword + " at index " + max_index);
        System.out.println("Min word  : " + minword + " at index " + min_index);
    }
}
