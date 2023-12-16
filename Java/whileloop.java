import java.util.Scanner;

public class whileloop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("? Enter something to print: ");

        String prnt = scan.nextLine();

        System.out.print("? How many times: ");
        int times = scan.nextInt();
        
        int count = 0;
        while (count<times) {
            count++;
            System.out.println(count+" "+prnt);
        }
    }
}
