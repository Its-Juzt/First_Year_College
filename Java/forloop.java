import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("? Print what?: ");
        String inpt1 = scan.nextLine();

        System.out.print("? How many times: ");
        int times = scan.nextInt();

        for(int x = 1;x<=times;x++) {
            System.out.println(x+" "+inpt1);
        }
    }
}
