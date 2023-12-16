import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class second {
    public static void main(String[] args) {
        String file;

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("[!] Enter file location: ");

            file = scan.nextLine();

            File check = new File(file);

            if(check.exists()) {
                break;
            }
            else {
                System.out.println("[!] File not found.");
            }
        }

        scan.close();

        try {
            FileReader read = new FileReader(file);
            BufferedReader buffer = new BufferedReader(read);
            String content,username,password;

            while ((content = buffer.readLine()) != null) {
                String[] split = content.split("\\|");
                password = split[split.length - 1];
                username = split[0];
                System.out.printf("Username: %s\nPassword: %s\n",username,password);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
