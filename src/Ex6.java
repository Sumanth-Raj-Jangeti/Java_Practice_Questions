import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number:");
        int num = sc.nextInt();
        int originalNum = num;   // store original number
        String binary = "";
        while (num > 0) {
            int rem = num % 2;
            binary = rem + binary;   // prepend remainder
            num = num / 2;
        }
        System.out.println("Binary form of " + originalNum + " is: " + binary);
    }
}
