/*
LEARNING JAVA DAY 1
My first java program
<- Just memorizing useful code.
(Menu program) using Project Based Learning technic (PBL).
 
*/

import java.util.*;

public class Main {
        public static void main(String[] args) {
                String Ary[] = new String[] {"1","2","3","0"};
                List<String> lList = Arrays.asList(Ary);
                String menu = "\033[0m [\033[0;91m*\033[0m] \033[0;96m1.\033[0m Mango\n [\033[0;91m*\033[0m] \033[0;96m2.\033[0m Ube\n [\033[0;91m*\033[0m] \033[0;96m3.\033[0m Buko\n [\033[0;91m*\033[0m] \033[0;96m0.\033[0;91m Exit.\033[0m\n\n";
                loading();
                print(menu);
                int found = 0;
                do {
                        if (found == 1) {
                                break;
                        }
                        Scanner usrinput = new Scanner(System.in);
                        //String input = usrinput.next();
                        System.out.print(" [\033[0;92m?\033[0m] Order: \033[0;92m");
                        String input = usrinput.next();
                        for (inti=0;i<lList.size();i++) {
                                if (lList.get(i).equals(input)) {
                                        if (input.equals("1")) {
                                                print(" [ Mango ]\n");
                                        } else if (input.equals("2")) {
                                                print(" [ Ube ]\n");
                                        } else if (input.equals("3")) {
                                                print(" [ Buko ]\n");
                                        } else if (input.equals("0")) {
                                                found = 1;
                                                break;
                                        }
                                }
                        }
                } while (true);}

        public static void sleep(int sec, int ms) {
                try {
                        Thread.sleep(sec * ms);
                } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
        }
        }

        public static void loading() {
                for (int i=0;i<=100;i++) {
                        print("\r \033[0m[\033[0;94m*\033[0m] Initializing: \033[0;91m"+i+"%");
                        sleep(1,50);
                }
                print("\n\n");

        }

        public static void print(Object line) {
                System.out.print(line);
        }
}
