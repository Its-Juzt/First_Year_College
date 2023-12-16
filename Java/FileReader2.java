import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class prac1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file: ");
        String input_file = scan.nextLine();

        File check_file = new File(input_file);

        if(check_file.exists()) {
            ReadF read = new ReadF();
            System.out.println("Reading file...");
            sleep(3);
            ArrayList<String> data = read.read(input_file);
            for (int x = 0; x < data.size();++x) {
                System.out.println(x+"  "+data.get(x));
            }

        }
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ReadF {
    public ArrayList<String> read(String file) {
        ArrayList<String> alist = new ArrayList<String>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader read = new BufferedReader(reader);
            String line;
            while((line = read.readLine()) != null) {
                alist.add(line);
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }
        return alist;
    }
}
