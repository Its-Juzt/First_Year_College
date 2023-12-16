import java.util.Scanner;
public class swit {
	public static int option;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do {
			try {
	            System.out.println("+[ All Hack Tool ]\n+-> Code: 7wp\n");
    	        System.out.println("1.) Facebook hack\n2.) Youtube hack\n3.) Instagram hack\n4.) NASA hack\n0. Exit\n");
        	    System.out.print("?) Enter option: ");
	        	option = scan.nextInt();
	            switch (option) {
    	            case 1:
        	            hack("Facebook");
						System.exit(1);
                	    break;
	                case 2:
    	                hack("Youtube");
						System.exit(1);
            	        break;

                	case 3:
	                    hack("Instagram");
						System.exit(1);
        	            break;
            	    case 4:
                	    System.exit(1);
                    	break;
	                default:
    	                System.out.println("(!) Enter a valid option.");
        	            sleep(3,1000);
            	        clear();
				}
			} catch (Exception e) {
				System.out.println("(!) Enter a valid option.");
                sleep(3,1000);
                clear();
				}
        } while(true);


    }

    public static void hack(String hck) {
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("?) Enter target Username: ");
            String target = scan.nextLine();
            if (target != "" || target != " ") {
                if (target.length() >=4 && target.length() <= 18) {
                    System.out.print("[+] Target is set: ");
                    typewriter(target+"\n");
                    sleep(2, 1000);
                    System.out.print("[*] Starting "+hck+" Hack");
                    typewriter("..."+"\n");
                    sleep(2, 1000);
                    System.out.print("[*] Cracking password: ");
                    typewriter("#########################"+"\n");
                    sleep(5, 1000);
                    System.out.println("[+] Password cracked.");
                    sleep(2, 1000);
                    typewriter("[+] Password: bayotka123");
                    break;
                } else {

                    System.out.println("(!) Target is invalid.");
                    sleep(2,1000);
                    clear();
                }

            } else {
                System.out.println("(!) Target is invalid.");
                sleep(2,1000);
                clear();

            }
        } while (true);

    }

    public static void typewriter(String outp) {
        char[] list = outp.toCharArray();
        for (char x: list) {
            System.out.print(x);
            sleep(1,50);
        }
    }

    public static void sleep(int sec, int ms) {
        try {
            Thread.sleep(sec*ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public static void clear() {
        System.out.println("\033\143");
    }
}
