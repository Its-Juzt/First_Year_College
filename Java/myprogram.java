import java.util.Scanner;
public class myprogram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your full name: ");
		String name = scan.nextLine();
		System.out.print("Hello "+name);
	}

}
