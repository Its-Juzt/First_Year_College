import java.util.Scanner;

public class checker3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number one: ");
        int num1 = scan.nextInt();
		System.out.print("Enter number two: ");
		int num2 = scan.nextInt();
		System.out.print("Enter number three: ");
        int num3 = scan.nextInt();

		if (num1 == num2 && num2 == num3 ) {
			System.out.print("Numbers is equal");

		} else if (num1 == num2 && num2 != num3) {
			System.out.print("Numbers is neither");

	    } else if (num1 != num2 && num2 == num3) {
			System.out.print("Numbers is neither");

		}  else if (num1 != num2 && num1 == num3) {
            System.out.print("Numbers is neither");
        } else {
			System.out.print("Numbers are not equal");
		}
    }
}
