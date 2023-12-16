import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class funloop {
    public static void main(String[] args) {
        

        Scanner scan = new Scanner(System.in);
        int count = 0;
        ArrayList<String> list = new ArrayList<String>();


        while (true) {
            System.out.printf("[%d] Insert to list-: ",count);
            String input = scan.nextLine();
            if (input.equals("done") || input.equals("done ")) {
                break;
            } else {
                list.add(input);
                count++;
            }

        }

        System.out.println("Length: "+list.size());
        System.out.println("Content: ");
        for (int x=0;x<list.size();x++) {
            System.out.printf(" %s\n",list.get(x));
        }
    }
}
