import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        //wap to print,count,return indexes for uppercase,lowercase,digits,special chars in a given str.
        String str="Tiger runs @ The Speed of 100Km/Hr";
        int u_count=0,l_count=0,d_count=0,s_count=0,index=0;
        //Converting str to a character array
        char[] ch=str.toCharArray();
        System.out.println(Arrays.toString(ch));
        for(char c:ch)
        {
            if(Character.isUpperCase(c))
            {
                u_count++;
                System.out.println("Upper:"+c+" index is:"+index);
            } else if (Character.isLowerCase(c))
            {
                l_count++;
                System.out.println("Lower:"+c+" index is:"+index);
            } else if (Character.isDigit(c))
            {
                d_count++;
                System.out.println("Digit:"+c+" index is:"+index);
            }
            else
            {
                s_count++;
                System.out.println("Special char:"+c+" index is:"+index);
            }
            index++;
        }
        System.out.println("Upper count:"+u_count);
        System.out.println("lower count:"+l_count);
        System.out.println("Digit count:"+d_count);
        System.out.println("Special char count:"+s_count);
    }
}
