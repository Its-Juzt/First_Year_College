import java.util.Scanner;
public class intigir {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter number one: ");
	int num1 = scan.nextInt();
	System.out.print("Enter number two: ");
	int num2 = scan.nextInt();
	int total = num1 + num2;
	System.out.println("The sum of "+num1+" and "+num2+" is "+total);
	}
}
