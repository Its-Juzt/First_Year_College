import java.util.Scanner;
public class leapyear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scan.nextInt();

        if (year%4 == 0 && year%100 != 0  && year%400 == 0) {
            System.out.println(year+" is a leap year.");
        } else if (year <= 0) {
			System.out.println(year+" is not a valid year.");
        } else {
            System.out.println(year+" is a leap year.");
        }
    }
}
