import java.util.Scanner;

public class checker1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = scan.nextInt();

        if (num == 0 ) {
            System.out.println("Number is zero.");
        } else if (num >0 ) {
            System.out.println("Number is positive\nlarge");
        } else {
            System.out.println("Number is negative\nSmall");

        }
    }
}
