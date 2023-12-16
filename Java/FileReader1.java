import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class aaa1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printf("[?] Enter file location: ");

        String path = scan.nextLine();
        File fileloc = new File(path);

        if (fileloc.exists()) {
            readfile(path);

        } else {
            printf("[!] File not found!");
            System.exit(0);
        }
        /* String msg = scan.nextLine();
        msg = msg.strip();
        animate(msg);
        */

    }

    public static void readfile(String location) {
        try {
        FileReader read = new FileReader(location);
        BufferedReader buffread = new BufferedReader(read);
        String line;

        while((line = buffread.readLine()) != null) {
            animate(line);
        }

        buffread.close();
        read.close();
        } catch(IOException exp) {
            exp.printStackTrace();
        }
    }

    public static void animate(String message) {
        int len = message.length();
        char str;
        printf("\033[38;5;241m"+message+"\r");
        for(int i = 0;i<len;i++) {
            str = message.charAt(i);
            printf("\033[38;5;255m"+String.valueOf(str)+"\033[0m");
            sleep(1,50);
           
        }
        printf("\n");
    }   

    public static void printf(Object msg) {
        System.out.print(msg);
    }

    public static void sleep(int sec, int ms) {
        try {
            Thread.sleep(sec * ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
