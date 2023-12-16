import java.util.Scanner;
public class whileloop {
    public static void main(String[] args) {
        int loop = 0;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = scan.next();


           if (name.equals("stop")) {
              System.out.println("Loop has breaked.");
              break;
          } else {
              System.out.println("Hello "+name);
              loop++;
              System.out.println("Loop for runs "+loop+" nth time.\n");
            }
        } while(true);
    }
}
