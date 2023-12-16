import java.util.*;

public class calculator {

  public static void main(String[] args) {
      menu();
  }
  public static void menu() {
    print("\033\143");
    print("1. Addition\n2. Multiplication\n0. Exit\n\n");
    Scanner inpt = new Scanner(System.in);
    print("[?] Select > ");
    String input = inpt.next();
    try {
      int out = Integer.parseInt(input);
      if (out == 1) {
        addi();
      }
      else {
        print("[!] Please enter a valid input!\n");
      }
    } catch(NumberFormatException nfe) {
      print("[!] Please enter a valid input!\n");
      sleep(3);
      print("\033\143");
      menu();
    }
  }


  public static void addi() {
    print("\033\143");
    Integer addnum2 = null;
    Integer addnum1 = null;
    Scanner num1 = new Scanner(System.in);
    print("[?] Enter first number: ");
    String numm1 = num1.next();
    try {
      addnum1 = Integer.parseInt(numm1);

    } catch(NumberFormatException nfe) {
      print("[!] Error: "+numm1+" is not anumber.\n");
      sleep(3);
      print("\033\143");
      addi();
    }
    Scanner num2 = new Scanner(System.in);
    print("[?] Enter second number: ");
    String numm2 = num2.next();
    try {
      addnum2 = Integer.parseInt(numm2);
    } catch(NumberFormatException nfee) {
      print("[!] Error: "+numm2+" is not number.\n");
      sleep(3);
      print("\033\143");
      addi();
    }
    int added = addnum1+addnum2;
    print("The sum of "+numm1+" and "+numm2+" is "+added);
  }
  static void sleep(int sec) {
    try {
      Thread.sleep(1000*sec);
    } catch(InterruptedException ie) {
      Thread.currentThread().interrupt();
    }
  }


  static void print(Object line) {
    System.out.print(line);
  }
}
