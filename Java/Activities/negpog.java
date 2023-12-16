import java.util.Scanner;

public class negpog {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = scan.nextInt();

        if (num <= -1) {
            System.out.println(num+" is negative");
        } else {
            System.out.println(num+" is positive");
        }
    }
}
