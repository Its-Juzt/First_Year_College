import java.util.Scanner;

public class numTwo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 1;
		int total = 0;
		int result;
		while (count <= 5) {
			System.out.printf(" [%d] Enter number: ", count);
			int input = scan.nextInt();
			count += 1;
			total += input;
		}

		result = total / 5;
		System.out.printf(" Sum of numbers: %d | Average: %d", total, result);
	}
}
