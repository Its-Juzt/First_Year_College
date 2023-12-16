import java.util.Scanner;

public class checker2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = scan.nextInt();
        if (num >= 1 && num < 1000000000) {
            System.out.println("Number is large");
        } else if (num < 1) {
            System.out.println("Number is negative");

        } else {
            System.out.println("Number is morr than 10 billion.");
        }
    }
}
