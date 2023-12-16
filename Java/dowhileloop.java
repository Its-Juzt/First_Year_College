import java.util.Scanner;

public class dowhileloop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter something to print: ");
        String inpt = scan.nextLine();
        System.out.print("How many times: ");

        int times = scan.nextInt();
        int count = 0;
        do {
        count++;
        System.out.println(count+" "+inpt);
        } while(count < times);
    }
}
