import java.util.Scanner;

public class tut1 {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	System.out.println("Enter grade");

	int grade = scan.nextInt();

	if (grade >= 75 && grade <= 80) {
		System.out.println("Grade is more than 75 but less than 80");
	}

	if (grade > 80) {
	System.out.println("Grade is more than 80");
	}

	if (grade < 75 ) {
	System.out.println("Grade is less than 75");

	}

}

}
