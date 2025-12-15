public class Ex2 {
    public static void main(String[] args) {
        String str="Tiger runs @ The Speed of 100Km/Hr";
        FindCount(str);
    }
    public static void FindCount(String s)
    {
        int u_count=0,l_count=0,d_count=0,s_count=0,index=0;
        //Converting str to char array
        char[] ch =s.toCharArray();
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
