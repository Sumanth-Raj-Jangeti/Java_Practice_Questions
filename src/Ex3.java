import java.util.HashMap;

public class Ex3 {
    public static void main(String[] args) {
        //Convert a string to integer without using Integer.parseInt()
       /* String str="2546";
        int num=0;
        for(int i=0;i<str.length();i++)
        {
            num = num*10+(str.charAt(i)-'0');
        }
        System.out.println(num);
        System.out.println(num*100);*/

        //Find the freq of words in a given string
        String str="Java is fun and Java is powerful";
        //Creating a Hashmap
        HashMap<String,Integer> map=new HashMap<>();
        //Splitting the string into array of substrings
        String[] words=str.split(" ");
        for(String w:words)
        {
            map.put(w,map.getOrDefault(w,0)+1);
        }
        System.out.println(map);
    }
}
