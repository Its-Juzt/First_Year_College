import java.util.Scanner;

public class jaba {
  public static int subject;
	public static void main(String[] args) {
    System.out.println("1. Mango\n2.Ube\n3.Juice\n0.exit.\n");
		Scanner scan = new Scanner(System.in);
    do {
      System.out.print("Enter option: ");
      subject = scan.nextInt();
      if (subject > 3) {
        System.out.println("Error: Invalid input.");
      } else {
        if (subject == 1) {
          System.out.println("Your order: Mango");
          break;
        } else if(subject == 2){
          System.out.println("Your order: Ube");
          break;
        } else if( subject == 3){
          System.out.println("Your order: Juice");
          break;
        } else if(subject == 0){
          System.exit(0);
        } else {
          System.out.println("Error: Invalid input.");
        }
        System.out.println("Success");
        break;
      }
    } while (true);
    scan.close();
    System.out.println("Yes"+subject);
}
}
