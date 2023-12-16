import java.util.Scanner;

public class Juster {
  public static void main(String[] args) {
    String input = "Enter a subject: ";
    String value = "Enter subject ";

    Scanner scan = new Scanner(System.in);

    System.out.print(input);
    String subject1 = scan.next();
    System.out.print(value + subject1 + " value: ");
    int subval1 = scan.nextInt();

    System.out.print(input);
    String subject2 = scan.next();
    System.out.print(value + subject2 + " value: ");
    int subval2 = scan.nextInt();

    System.out.print(input);
    String subject3 = scan.next();
    System.out.print(value + subject3 + " value: ");
    int subval3 = scan.nextInt();

    int result =(subval1 + subval2 + subval3)/ 3;

    System.out.println("Average mean: " + result);

  }
}
