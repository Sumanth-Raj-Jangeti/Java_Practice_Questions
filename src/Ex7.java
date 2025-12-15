import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        //Converting Binary to integer
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Binary Number:");
        int binary1=sc.nextInt();
        int num1=0,power=0;
        while (binary1>0)
        {
            int rem1=binary1%10;
            num1+=rem1*Math.pow(2,power);
            binary1=binary1/10;
            power++;
        }
        System.out.println(num1);
    }
}
