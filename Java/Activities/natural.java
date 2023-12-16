import java.util.Scanner;

public class natural {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int x = 1;

        for (int i=1;i <= num;i++) {
            x += i;
            System.out.println(i);
        }
        System.out.println(x-1);
    }
}
