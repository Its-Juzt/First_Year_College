import java.util.Scanner;
public class userinput {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = scan.next();
		System.out.print("Hello "+name);
	}
}
