
/*
@author: Juster M. Ube
@date: 11/12/2023.

package MiniStore;
*/

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MiniStore {
	/* gobal vars */
    // separate the values fodr printing and calculating..

	/* cart layout and values*/

    static int count_cart_item = 0;
    static int t_fr = 0; // total fruit in cart
    static int t_ba = 0; // ..
    static int t_ve = 0;
    static int t_da = 0;
    static int t_me = 0;
    static int t_ot = 0;

    static String f_total = "0    ";
    static String b_total = "0    ";
    static String v_total = "0    ";
    static String d_total = "0    ";
    static String m_total = "0    ";
   	static String o_total = "0    ";
    static String cart = "0     ";
    static String cart_items = "";

    /* Ascii colors */

   	static String red = "";
   	static String green = "";
   	static String blue = "";
   	static String yellow = "";
   	static String cyan = "";
   	static String purple = "";
   	static String white = "";
   	static String orange = "";
   	static String reset = "";

   	static boolean color_off = true;
	static String status = "OFF    ";

   	public static void color_switch() {

   		if (!color_off) {
			red = "\033[0;91m";
		   	green = "\033[0;92m";
		   	blue = "\033[0;94m";
		   	yellow = "\033[0;93m";
		   	cyan = "\033[0;96m";
		   	purple = "\033[0;95m";
		   	white = "\033[0;97m";
		   	orange = "\033[38;5;208m";
		   	reset = "\033[0m";
		} else {
	   	 	red = "";
			green = "";
			blue = "";
			yellow = "";
			cyan = "";
			purple = "";
			white = "";
			orange = "";
			reset = "";
		}
		if (!color_off) {
    		status = green+"ON     "+reset;
    	} else {
    		status = "OFF    ";
    	}
   	}


    public static void clear() {
        String system = System.getProperty("os.name"); // os name
        if (system.contains("Windows")) {
            // clear console if using windows cmd or windows terminal
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                // try works if supports ansi escaping..
                System.out.print("\033\143");
                System.out.print("\033[H\033[2J");
            }
        } else {
            System.out.print("\033\143");
            System.out.print("\033[H\033[2J");
        }

        // https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
    }

    // sleep..
    public static void sleep(int time) {
        try {
            if (time == 4101) {
                Thread.sleep(500);
            } else {
                Thread.sleep(time * 1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    // type writter effect
    public static void Info(String msg) {
        try {
            for (int i = 0; i < msg.length(); i++) {
                System.out.print(msg.charAt(i));
                Thread.sleep(50);
            }
        } catch (InterruptedException exp) {
            return;
        }
        System.out.print(reset);
    }


    public static String get_price(int category, String str_item) {
		String[] grocery_list = {"",",30|pineapple,30|melon,60|banana,10|orange,30|grapes,300|apple,15|mango",
			",20|cupcakes,20|cookies,30|donuts,30|bread,90|cake,80|pie",
			",10|cucumber,30|lettuce,50|tomato,25|potato,20|onion,30|cabbage",
			",45|cheese,30|butter,20|yogurt,40|cream,60|milk,20|egg",
			",200|chicken,140|bacon,250|pork,250|beef,250|duck,230|ham",
			",30|coffee,30|tea,20|soda,20|ketchup,15|peper,25|salt,15|oregano,80|ice cream,23|noodles,30|lolipop,70|vinegar,15|water,45|pasta,23|sardines,74|popcorn"
		};

		// check if there is Integer in item

		try {
			Integer.parseInt(str_item);
		} catch(NumberFormatException numf) {
			return "null|404";
		}


		int item = Integer.parseInt(str_item);
		if (category >= 1 && category <= 6) {
			String item_list[] = grocery_list[category].split(",");
			if (category == 1) {
				if (item >= 1 && item <= 7) {
					return item_list[item];
				} else {
					return "null|404";
				}

			} else if (category == 6) {
				if (item >= 1 && item <= 16) {
					return item_list[item];
				} else {
					return "null|404";
				}

			} else {
				if (item >= 1 && item <= 6) {
					return item_list[item];
				} else {
					return "null|404";
				}
			}
		}
		else {
			return "null|404";
		}

    }



    public static void show_cart_items() {
    	clear();
		String item_list_layout = "\n"
+ "   ┌─────────────────────────────────────┐\n"
+ "   │ Title      :  Mini Grocery Store    │\n"
+ "   │ Developer  :  Juster M. Ube         │\n"
+ "   │ Section    :  BSIT-NA               │\n"
+ "   ├─────────────────────────────────────┤\n"
+ "  ╔╩══════════════════╤══════════════════╩╗\n"
+ "  ║ Item              │ Quantity          ║\n"
+ "  ╠═══════════════════╪═══════════════════╣";

        System.out.println(item_list_layout);
        int totalitems = 0;
        ArrayList<String> done_list = new ArrayList<>();
        ArrayList<String> removed_duplicates = new ArrayList<>();

        String[] cart_item = cart_items.split(",");
        
        for (String x: cart_item) {
            if (!removed_duplicates.contains(x)) {
                removed_duplicates.add(x);
            }
        }
        for (String x: removed_duplicates) {
            int count = 0;
            for (String i: cart_item) {
                if (i.equals(x)) {
                    totalitems++;
                    count++;
                }
            }
            String item = x.split("\\|")[1];

            while (item.length() < 17) {
                 item += " ";
            }
            System.out.print("  ║ "+item+" │");

            String quantity = String.valueOf(count);
            while (quantity.length() < 17) {
                quantity += " ";
            }
            System.out.print(" "+quantity+" ║\n");
        }
        System.out.println("  ╠═══════════════════╧═══════════════════╣");
        String total_layout = String.valueOf(totalitems);
        while (total_layout.length() < 24) {
            total_layout += " ";
        }
        System.out.println("  ║ Total Items: "+total_layout+" ║");

        System.out.println("  ╚═══════════════════════════════════════╝");
        Scanner press = new Scanner(System.in);
        System.out.print("  [ Back ]");
        String back = press.nextLine();
    }



    public static void printout_receipt(String receipt, int input_money,int total) {
        receipt = receipt.replace("║","│").replace("╤","┬").replace("╣","┤").replace("╠","├").replace("═","─").replace("╪","┼").replace("╗","┐").replace("╔","┌").replace("╧","┴");
        String total_layout  = "Total cost  : ₱"+total;
        String ammont_layout = "Amount paid : ₱"+input_money;
        int change = input_money-total;
        String change_layout = "Change      : ₱"+change;

        int length_money = String.valueOf(input_money).length();
        int length_total = String.valueOf(total).length();


        if (length_total == 3) {
            total_layout += "                  │";
        } else if (length_total == 4) {
            total_layout += "                 │";
        } else if (length_total == 2) {
            total_layout += "                   │";
        } else if (length_total == 5) {
            total_layout += "                │";
        } else if (length_total == 6) {
            total_layout += "               │";
        }


        receipt += "  │ "+total_layout+"\n";

        int breaker = String.valueOf(ammont_layout).length();
        breaker = 35 - breaker;
        for (int i = 0; i<breaker;i++) {
            ammont_layout += " ";
        }
        receipt += "  │ "+ammont_layout+" │\n";


        breaker = String.valueOf(change_layout).length();
        breaker = 35 - breaker;
        for (int i = 0; i<breaker;i++) {
            change_layout += " ";
        }
        receipt += "  │ "+change_layout+" │\n";
        receipt += "  │─────────────────────────────────────│\n"
+ "  │              Thank you !            │\n"
+ "  │         Visit Us Again Soon!        │\n"
+ "  └─────────────────────────────────────┘";
		String[] dots = {".    ","..  ","... ","...."};
		for (int run = 0; run <3;run++) {
			for (int i = 0; i<dots.length;i++) {
				System.out.print("  "+white+"["+blue+"*"+white+"]"+reset+" Printing receipt, Please wait a moment"+dots[i]+"\r");
				sleep(4101);
			}
		}
		String[] animate_recept = receipt.split("\n");
		for (int x = 0; x<animate_recept.length;x++){
			try {
	            for (int i = 0; i < animate_recept[x].length(); i++) {
	                System.out.print(animate_recept[x].charAt(i));
	                Thread.sleep(3);
	            }
	            System.out.println();
	        } catch (InterruptedException exp) {
	            return;
	        }
		}
		Info("  "+white+"["+blue+"*"+white+"]"+reset+" Here is your receipt ma'am/sir...\n");
		Info("  "+white+"["+blue+"*"+white+"]"+reset+" Have a good day visit again!\n");
		System.exit(0);

    }

    public static void update_cart(String category) {

        count_cart_item += 1;
        if (count_cart_item >= 10) {
            // adjust the spaces same in others.
            cart = count_cart_item + "    ";
        } else if (count_cart_item >= 100) {
            cart = count_cart_item + "    ";
        } else {
            cart = count_cart_item + "     ";
        }


        switch(category) {
	        case "fruit":
	            if (t_fr >= 10) {
	                f_total = t_fr + "   ";
	            } else if (t_fr >= 100) {
	                f_total = t_fr + "   ";
	            } else {
	                f_total = t_fr + "    ";
	            }
	            break;
	        case "vegies":
	            if (t_ve >= 10) {
	                v_total = t_ve + "   ";
	            } else if (t_ve >= 100) {
	                v_total = t_ve + "   ";
	            } else {
	                v_total = t_ve + "    ";
	            }
	        case "meat":
	            if (t_me >= 10) {
	                m_total = t_me + "   ";
	            } else if (t_me >= 100) {
	                m_total = t_me + "   ";
	            } else {
	                m_total = t_me + "    ";
	            }
	            break;
	        case "dairy":
	            if (t_da >= 10) {
	                d_total = t_da + "   ";
	            } else if (t_da >= 100) {
	                d_total = t_da + "   ";
	            } else {
	                d_total = t_da + "    ";
	            }
	            break;
	        case "bakery":
	            if (t_ba >= 10) {
	                b_total = t_ba + "   ";
	            } else if (t_ba >= 100) {
	                b_total = t_ba + "   ";
	            } else {
	                b_total = t_ba + "    ";
	            }
	            break;
	        case "others":
	            if (t_ot >= 10) {
	                o_total = t_ot + "   ";
	            } else if (t_ba >= 100) {
	                o_total = t_ot + "   ";
	            } else {
	                o_total = t_ot + "    ";
	            }
	            break;
	        }




    }



    public static void payment_card() {
    	Scanner scan = new Scanner(System.in);
    	int valid_card_number = 0;
    	String expire_date = "";
    	while (true) {
    		System.out.print("  "+white+"["+blue+"*"+white+"]"+reset+" Enter 8 digit card number: ");
    		String card_number = scan.next();
    		if (card_number.length() == 8) {
    			try {
    				valid_card_number = Integer.parseInt(card_number);
    				if (valid_card_number != 0) {
    					break;
    				}
    			} catch (NumberFormatException nfe) {
    				Info("  " + white +"[" +red+ "!"+ white+"]" +yellow + " Error: Please enter a valid card number.\n");
    			}
    		} else {
    			Info("  " + white +"[" +red+ "!"+ white+"]" +yellow + " Error: Please enter a valid card number.\n");
    		}

    	}
    	while (true) {
    		String[] month_list = {"01","02","03","04","05","06","07","08","09","10","11","12"};
    		int expired_year = 2022;

    		System.out.print("  "+white+"["+blue+"*"+white+"]"+reset+" Enter expiration date (ex: 01/2024): ");
    		String expdate = scan.next();
    		if (expdate.contains("/")) {
    			boolean valid = false;
    			String[] date = expdate.split("/");
    			if (date.length == 2) {
    				for (int x = 0;x < month_list.length;x++) {
    					if (month_list[x] == date[0]) {
    						valid = true;
    					}
    				}

    				if (valid) {
    					try {
	    					int year = Integer.parseInt(date[1]);
	    					if (year < expired_year) {
	    						Info("  [!] \n");
	    					}
	    				} catch (NumberFormatException nfe) {
	    					Info("  " + white +"[" +red+ "!"+ white+"]" +yellow + " Error: Please enter a valid expiration year.\n");
	    				}
    				} else {
    					Info("  " + white +"[" +red+ "!"+ white+"]" +yellow + " Error: Please enter a valid expiration month.\n");
    				}

    			} else {
    				Info("  " + white +"[" +red+ "!"+ white+"]" +yellow + " Error: Please enter a valid expiration date.\n");
    			}
    		} else {
    			Info("  " + white +"[" +red+ "!"+ white+"]" +yellow + " Error: Please enter a valid expiration date.\n");
    		}
    	}




    }


    public static void counter() {
        clear();
        if (cart_items.equals("")) {
            System.out.println("\n  [!] Good day Ma'am/Sir !");
            Info("  "+white+"["+blue+"*"+white+"]"+reset+" Ow, It looks like your cart is empty...\n");
            sleep(3);
            return;
        }

		Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(currentDate);

        String receipt_layout = "\n"
+ "  ┌─────────────────────────────────────┐\n"
+ "  │          Mini Grocery Store         │\n"
+ "  │    Code by Juster M. Ube BSIT-NA    │\n"
+ "  │       Contact no. 0987654321        │\n"
+ "  ├─────────────────────────────────────┤\n"
+ "  │      Reciept Date - "+formattedDate+"      │\n"
+ "  ╠═══════════╤═══════╤════════╤════════╣\n"
+ "  ║ Item      │ Qty   │ Price  │ Cost   ║\n"
+ "  ╠═══════════╪═══════╪════════╪════════╣\n";


        String total_item_layout = "";

        String counter_layout = "\n"
+ "   ┌───────────────────────────────────┐\n"
+ "   │ Title      :  Mini Grocery Store  │\n"
+ "   │ Developer  :  Juster M. Ube       │\n"
+ "   │ Section    :  BSIT-NA             │\n"
+ "   ├───────────────────────────────────┤\n"
+ "  ╔╩═══════════════════════════════════╩╗\n"
+ "  ║                                     ║\n"
+ "  ║          *Checkout Counter*         ║\n"
+ "  ║                                     ║";



        Random random = new Random();

        // generate random question for asking payment..
        String[] names = {"Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Sophia", "James", "Isabella"};
        int random_name_index = random.nextInt(names.length);
        String random_name = names[random_name_index];
        int cash_id = 0;
        for(int x = 0;x <= names.length;x++) {
            if (names[x].equals(random_name)) {
                cash_id = x;
                break;
            }
        }

        for (int x = 0; x <= 11; x++) {
            if (random_name.length() != 11) {
                random_name += " ";
            } else {
                random_name += " ║";
            }
        }

        String cashier_layout = ""
+ "  ╠════════════════╦════════════════════╣\n"
+ "  ║  Cashier No. "+cash_id+" ║  Name: "+random_name+"\n"
+ "  ╠════════════════╩════════════════════╣";

        String cst_layout = ""
+ "  ╠═══════════╤═══════╤════════╤════════╣\n"
+ "  ║ Item      │ Qty   │ Price  │ Cost   ║\n"
+ "  ╠═══════════╪═══════╪════════╪════════╣\n";


        System.out.println(counter_layout);
        System.out.println(cashier_layout);
        System.out.println("  ║ *Checking items, Please wait...     ║");

        sleep(3);

        System.out.print(cst_layout);

        ArrayList<String> done_list = new ArrayList<>();
        ArrayList<String> removed_duplicates = new ArrayList<>();
        String[] cart_item = cart_items.split(",");
        
        for (String x: cart_item) {
            if (!removed_duplicates.contains(x)) {
                removed_duplicates.add(x);
            }
        }

        int total_column = removed_duplicates.size();
        int total_cost = 0;
        int count_column = 0;

        for (String item: cart_item) {

            if (done_list.contains(item)) {
                continue;
            }

            count_column++;

            // split the item ['price', 'item']
            String[] item_data = item.split("\\|");

            String price = item_data[0];
            String name = item_data[1];

            // initialize the item layout.
            String layout_item = "";

            // calculate the name to fit in item box.

            if (name.length() <= 9) { // 9 | the length of the longest word in my item list.
                layout_item += name;
                while (layout_item.length() <= 9) {
                    layout_item += " "; // add spaces
                }
                layout_item += "│"; // hits the end add the box end.
            } else {
                name = name + " ║"; // if 9 then just add directly a box end.
            }

            layout_item = "  ║ " + layout_item;

            int item_qty = 0;
            // count quantity | the current item duplicates on the cart_item
            for (String qty : cart_item) {
                if (item.equals(qty)) {
                    item_qty += 1;
                }
            }
            done_list.add(item); // add to done list.

            // calulate the length of quantity to fit the box

            int qty_length = String.valueOf(item_qty).length();
            String quantity_layout = "";
            if (qty_length == 1) {
                quantity_layout = " " + item_qty + "     │";
            } else if (qty_length == 2) {
                quantity_layout = " " + item_qty + "    │";
            } else if (qty_length == 3) {
                quantity_layout = " " + item_qty + " │";
            }

            // calculate the length of price to fit the box


            int price_length = String.valueOf(price).length();
            String price_layout = "";

            if (price_length == 2) {
                price_layout = " ₱" + price + "    │";
            } else if (price_length == 3) {
                price_layout = " ₱" + price + "   │";
            }


            // calculate the length of price to fit the box
            int item_price = Integer.parseInt(price);
            int item_cost =  item_qty * item_price;

            String str_cost = String.valueOf(item_cost);
            int item_cost_length = String.valueOf(item_cost).length();
            String cost_layout = "";

            if (item_cost_length == 2) {
                cost_layout = " ₱"+ str_cost + "    ║";
            } else if (item_cost_length == 3) {
                cost_layout = " ₱"+ str_cost + "   ║";
            } else if (item_cost_length == 4) {
                cost_layout = " ₱"+ str_cost + "  ║";
            } else if (item_cost_length == 5) {
                cost_layout = " ₱"+ str_cost + " ║";
            }

            total_cost += item_cost;
            // append all to total_item_layout
            total_item_layout += layout_item + quantity_layout + price_layout + cost_layout+"\n";
            if (count_column != total_column) {
                total_item_layout += "  ╠───────────┼───────┼────────┼────────╣\n";
            } else {
                total_item_layout += "  ╠═══════════╧═══════╧════════╧════════╣\n";
            }
        }

        receipt_layout += total_item_layout;
        
        // calculate total cost.
        String total_cost_layout = " Total cost: ₱"; // to end = 24 
        String append_cost = String.valueOf(total_cost);

        while (append_cost.length() < 23) {
            append_cost += " ";
        }
        append_cost += "║";
        total_item_layout += "  ║" + total_cost_layout + append_cost+"\n";

        total_item_layout += "  ╚═════════════════════════════════════╝\n";

        int progress_counter = 0;
        int item_identifyer = 0;
        String[] animate = total_item_layout.split("\n");
        for (int x = 0; x < animate.length;x++) {
        	if (item_identifyer == 0) {
    			System.out.printf("  "+white+"["+blue+"*"+white+"]"+reset+" Reading Items: %d/%d\r",progress_counter,count_cart_item);
    			item_identifyer++;
    		} else {
    			item_identifyer--;
    			progress_counter++;
    			System.out.printf("  "+white+"["+blue+"*"+white+"]"+reset+" Reading Items: %d/%d\r",progress_counter,count_cart_item);
    		}
        	sleep(4101);
        	System.out.println(animate[x]);
        }
        progress_counter--;


        Scanner scan2 = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.printf("  "+white+"["+blue+"*"+white+"]"+reset+" Reading Items: %d/%d\n",progress_counter,count_cart_item);
        System.out.println("  "+white+"["+blue+"*"+white+"]"+reset+" Read Complete...\n");
        System.out.print("  "+white+"["+blue+"*"+white+"]"+reset+" Press Enter to procced...");
        if (scan2.hasNextLine())

        /* payment code | cashier layout */


        while(true) {
        	clear();
        	String print_cost = String.valueOf(total_cost);
	        String[] question_list = {"Your total: ₱"+print_cost+" How will you be paying today?",
	        "Total amount: ₱"+print_cost+". Will it be card or cash?",
	        "Your payment for the total of ₱"+print_cost+", how'd you like to handle that?",
	        "The total comes to ₱"+print_cost+". What way you'd like to pay?"};
	        
	        int choice = random.nextInt(question_list.length);
	        String question = question_list[choice];
	        String[] split_question = question.split(" ");
	        String question_layout = "";
	        int used_column = 0;
        	/* fit the question to box code*/
	        System.out.print(counter_layout);
	        System.out.println("\n"+cashier_layout);
	        System.out.println("  ║                                     ║");
	        for (int x = 0; x < split_question.length;x++) {
	            if (question_layout.length() > 27 && question_layout.length() < 34) {
	                for (int i = 0;i < 34;i++) {
	                    if (question_layout.length() != 34) {
	                        question_layout += " ";
	                    } else {
	                        question_layout +=" ║";
	                        used_column += 1;
	                    }
	                }
	                System.out.println("  ║  "+question_layout);
	                question_layout = "";
	            }
	            question_layout += split_question[x]+" ";
	        }
	        if (question_layout.length() != 0) {
	            for (int x = 0;x < 34;x++) {
	                if (question_layout.length() != 34) {
	                    question_layout += " ";
	                }
	                else {
	                    question_layout +=" ║";
	                    used_column += 1;
	                }
	            }
	        }

	        System.out.println("  ║  "+question_layout);

	        if (used_column < 4) {
	            for (int x = 0;x < (4-used_column);x++) {
	                System.out.println("  ║                                     ║");
	            }
	        }

	        String question_layout_box_end = ""
	+   "  ║─────────────────────────────────────║"
	+ "\n  ║--> 1. Pay via cash.                 ║"
	+ "\n  ║--> 2. Pay via card.                 ║"
	+ "\n  ╠═════════════════════════════════════╝"
	+ "\n  ║";
	        System.out.println(question_layout_box_end);
	        System.out.print("  ╚═[Select]─ ");

	        String select_method = scan.nextLine();

	         /* payment methods.*/
	        if (select_method.equals("1")) {
	        	while(true) {
	        		System.out.print("  "+white+"["+blue+"*"+white+"]"+reset+" Enter amount of money: ");
		            String input_money = scan.nextLine();
		            if (!input_money.equals("")) {
		            	try {
		            		int money = Integer.parseInt(input_money);
		            		if(money > total_cost) {
		            			sleep(1);
		            			clear();
		            			printout_receipt(receipt_layout,money,total_cost);

		            		} else {
		            			Info("  "+white+"["+blue+"*"+white+"]"+reset+" I think your money is not enough...\n");
		            			while(true) {
			            			System.out.print("  [?] Do you want to add your money (Y/n): ");
			            			String ask_to_swtich = scan.nextLine();
			            			if (ask_to_swtich.toLowerCase().equals("y")) {
			            				while (money < total_cost) {
			            					try {
			            						System.out.print("  ["+money+"/"+total_cost+"] Enter amount of money to add: ");
			            						int add_m = scan.nextInt();
			            						money += add_m;
			            					} catch (Exception exp) {
			            						Info("  [!] Error while processing the money...");
			            					}
			            				}
			            				System.out.println("  ["+money+"/"+total_cost+"] I think that was enough amount...");
			            				sleep(1);
		            					clear();
		            					printout_receipt(receipt_layout,money,total_cost);

			            			} else if (ask_to_swtich.toLowerCase().equals("n")) {
			            				while(true) {
			            					System.out.print("  "+white+"["+blue+"*"+white+"]"+reset+" Use card or cancel (cr/cc)? ");
			            					String crcc = scan.nextLine();
			            					if(crcc.toLowerCase().equals("cr")) {
			            						
			            						// code for card... / call card

			            					} else if (crcc.toLowerCase().equals("cc")) {
			            						break;
			            					} else {
			            						Info("  "+white+"["+blue+"*"+white+"]"+reset+" Please select 'cr' (card) or 'cc' (cancel)...\n");
			            					}
			            				}
			            				Info("   "+white+"["+blue+"*"+white+"]"+reset+" Thank you for vising!\n");
			            				System.exit(0);
			            			} else {
			            				Info("  "+white+"["+blue+"*"+white+"]"+reset+" Could you please select y or n...\n");
			            			}
			            		}


		            		}
		            	} catch(NumberFormatException mf) {
		            		Info("  [!] It looks like our system experienced an unexpected error while processing '"+input_money+"'...");
		            		sleep(2);
		            		break;
		            	}
		            } else {
		            	Info("  "+white+"["+blue+"*"+white+"]"+reset+" Please enter a amount of money for payment...\n");
		            }
		    	}

	        } else {
	        	Info("  "+white+"["+blue+"*"+white+"]"+reset+" Please select a payment method...\n");
	        	sleep(1);
	        }
	 	}
	 	System.exit(0);
    }

    public static void main(String[] args) {
    	color_switch();
        Scanner scanner = new Scanner(System.in);
        clear();
        String border_color = white;

        String main_layout = "\n" +
		cyan + "   ┌─────────────────────────────────────┐" + reset + "\n" +
		cyan + "   │ " + yellow + "Title      " + red + ":" + green + "  Mini Grocery Store    " + cyan + "│" + reset + "\n" +
		cyan + "   │ " + yellow + "Developer  " + red + ":" + green + "  Juster M. Ube         " + cyan + "│" + reset + "\n" +
		cyan + "   │ " + yellow + "Section    " + red + ":" + green + "  BSIT-NA               " + cyan + "│" + reset + "\n" +
		cyan + "   ├─────────────────────────────────────┤" + reset + "\n" +
		border_color + "  ╔╩═════════════════════╦═══════════════╩╗" + reset + "\n" +
		border_color + "  ║" + reset + "  Grocery Categories" + border_color + "  ║" + reset + " Items on Cart" + border_color + "  ║" + reset + "\n" +
		border_color + "  ╠══════════════════════╬════════════════╣" + reset + "\n" +
		border_color + "  ║--" + red + ">" + green + " 1." + white + " Fruits   " + red + "> " + reset + "(" + green + "7" + reset + ")" + border_color + " ║ " + white + "Fruits " + purple + "-> " + green + f_total + border_color + "║" + reset + "\n" +
		border_color + "  ║       " + white + "Seedless " + red + "> " + reset + "(" + green + "3" + reset + ")" + border_color + " ║                ║" + reset + "\n" +
		border_color + "  ║--" + red + ">" + green + " 2. " + white + "Bakery   " + red + "> " + reset + "(" + green + "5" + reset + ")" + border_color + " ║ " + white + "Bakery " + purple + "-> " + green + b_total + border_color + "║" + reset + "\n" +
		border_color + "  ║--" + red + ">" + green + " 3. " + white + "Vegies   " + red + "> " + reset + "(" + green + "6" + reset + ")" + border_color + " ║ " + white + "Vegies " + purple + "-> " + green + v_total + border_color + "║" + reset + "\n" +
		border_color + "  ║--" + red + ">" + green + " 4. " + white + "Dairy    " + red + "> " + reset + "(" + green + "5" + reset + ")" + border_color + " ║ " + white + "Dairy  " + purple + "-> " + green + d_total + border_color + "║" + reset + "\n" +
		border_color + "  ║--" + red + ">" + green + " 5. " + white + "Meat     " + red + "> " + reset + "(" + green + "5" + reset + ")" + border_color + border_color + " ║ " + white + "Meat   " + purple + "-> " + green + m_total + border_color + "║" + reset + "\n" +
		border_color + "  ║--" + red + ">" + green + " 6. " + white + "Others   " + red + "> " + reset + "(" + green + "6" + reset + ")" + border_color + " ║ " + white + "Others " + purple + "-> " + green + o_total + border_color + "║" + reset + "\n" +
		border_color + "  ║                      ║                " + border_color + "║" + reset + "\n" +
		border_color + "  ║──────────────────────║────────────────" + border_color + "║" + reset + "\n" +
		border_color + "  ║--" + red + ">" + red + " 0. " + white + "Exit.          " + border_color + "║ " + white + "Total items in " + border_color + "║" + reset + "\n" +
		border_color + "  ║--" + red + ">" + green + " s. " + white + "Show items     " + border_color + "║ " + white + "cart" + red + ": " + green + cart + border_color + "   ║" + reset + "\n" +
		border_color + "  ║--" + red + ">" + green + " g. " + white + "Go to counter  " + border_color + "║" + border_color + "                ║" + reset + "\n" +
		border_color + "  ║──────────────────────║────────────────║" + reset + "\n" +
		border_color + "  ║--" + red + ">" + green + " c. " + white + "on/off colors" + border_color + "  ║ " + white + "Status" + red + ": "+status+border_color + "║" + reset + "\n" +
		border_color + "  ╠══════════════════════╩════════════════╝" + reset + "\n" +
		border_color + "  ║" + reset;
        System.out.println(main_layout);
        System.out.print("  ╚═[Select]─ ");
        String select = scanner.nextLine();

        if (select.equals("1")) {
            while (true) {
                clear();
                String fruits_layout = "\n" +
cyan + "   ┌─────────────────────────────────────┐" + reset + "\n" +
cyan + "   │ " + yellow + "Title      " + red + ":" + green + "  Mini Grocery Store    " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Developer  " + red + ":" + green + "  Juster M. Ube         " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Section    " + red + ":" + green + "  BSIT-NA               " + cyan + "│" + reset + "\n" +
cyan + "   ├─────────────────────────────────────┤" + reset + "\n" +
border_color + "  ╔╩═════════════════════╦═══════════════╩╗" + reset + "\n" +
border_color + "  ║ " +reset+ "   Category: Fruits " + border_color + " ║" +reset+ "   Item Price  " + border_color + " ║\n" + reset +
border_color + "  ╠══════════════════════╬════════════════╣\n" + reset +
border_color + "  ║--" + red + ">" + green + " 1. " + white + "Pineapple      " + border_color + "║ " + green + "₱30" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 2. " + white + "Melon (SL.)    " + border_color + "║ " + green + "₱60" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 3. " + white + "Banana         " + border_color + "║ " + green + "₱25" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 4. " + white + "Orange (SL.)   " + border_color + "║ " + green + "₱30" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 5. " + white + "Grapes (SL.)   " + border_color + "║ " + green + "₱300" + yellow + " pr. wrap." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 6. " + white + "Apple          " + border_color + "║ " + green + "₱20" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 7. " + white + "Mango          " + border_color + "║ " + green + "₱15" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║──────────────────────║────────────────║\n" + reset +
border_color + "  ║--" + red + ">" + red + " 0. " + white + "Back to CATG.  " + border_color + "║ " + white + "Total items in " + border_color + "║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " s. " + white + "Show items     " + border_color + "║ " + white + "cart" + red + ": " + green + cart + border_color + "   ║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " g. " + white + "Go to counter  " + border_color + "║" + border_color + "                ║" + reset + "\n" +
border_color + "  ║──────────────────────║────────────────║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " c. " + white + "on/off colors" + border_color + "  ║ " + white + "Status" + red + ": "+status+border_color + "║" + reset + "\n" +
border_color + "  ╠══════════════════════╩════════════════╝" + reset + "\n" +
border_color + "  ║" + reset;
                System.out.println(fruits_layout);
                System.out.print("  ╚═[Select]─ ");
                String select_item = scanner.next();
                if (select_item.equals("0")) {
                    break;
                } else if (select_item.equals("s")){
                	show_cart_items();
                	sleep(1);
                } else if (select_item.equals("g")) {
                    counter();
                } else if (select_item.equals("c")) {
		        	if (!color_off) {
		        		color_off = true;
		        		color_switch();
		        	} else {
		        		color_off = false;
		        		color_switch();
		        	}
        		} else {
                    String item_data = get_price(1, select_item);
                    String[] item_data_arr = item_data.split("\\|");
                    String price = item_data_arr[0];
                    String name = item_data_arr[1];
                    if (!price.equals("null")) {
                        cart_items += item_data + ",";
                        t_fr += 1;
                        update_cart("fruit");
                        System.out.println("  "+white+"["+green+"+"+white+"]"+reset+" The '" +green+ name +reset+"' is added to cart.");
                        sleep(1);
                    } else {
                        Info("  "+white+"["+red+"!"+white+"]"+reset+" Sorry but that item is not available.\n");
                        sleep(2);
                    }
                }
            }
            main(null);
        } else if (select.equals("2")) {
            while (true) {
                clear();
                String bakery_layout = "\n"+
cyan + "   ┌─────────────────────────────────────┐" + reset + "\n" +
cyan + "   │ " + yellow + "Title      " + red + ":" + green + "  Mini Grocery Store    " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Developer  " + red + ":" + green + "  Juster M. Ube         " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Section    " + red + ":" + green + "  BSIT-NA               " + cyan + "│" + reset + "\n" +
cyan + "   ├─────────────────────────────────────┤" + reset + "\n" +
border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + reset +
border_color + "  ║" + reset + "   Category: Bakery   " + border_color + "║" + reset + "   Item Price   " + border_color + "║\n" + reset +
border_color + "  ╠══════════════════════╬════════════════╣\n" + reset +
border_color + "  ║--" + red + ">" + green + " 1. " + white + "Cupcake.       " + border_color + "║" + green + " ₱20" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 2. " + white + "Cookies.       " + border_color + "║" + green + " ₱20" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 3. " + white + "Donuts.        " + border_color + "║" + green + " ₱30" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 4. " + white + "Bread.         " + border_color + "║" + green + " ₱30" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 5. " + white + "Cake.          " + border_color + "║" + green + " ₱90" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 6. " + white + "Pie.           " + border_color + "║" + green + " ₱80" + yellow + " pr. piece." + border_color + " ║\n" + reset +
border_color + "  ║                      ║                ║\n" + reset +
border_color + "  ║──────────────────────║────────────────║\n" + reset +
border_color + "  ║--" + red + ">" + red + " 0. " + white + "Back to CATG.  " + border_color + "║ " + white + "Total items in " + border_color + "║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " s. " + white + "Show items     " + border_color + "║ " + white + "cart" + red + ": " + green + cart + border_color + "   ║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " g. " + white + "Go to counter  " + border_color + "║" + border_color + "                ║" + reset + "\n" +
border_color + "  ║──────────────────────║────────────────║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " c. " + white + "on/off colors" + border_color + "  ║ " + white + "Status" + red + ": "+status+border_color + "║" + reset + "\n" +
border_color + "  ╠══════════════════════╩════════════════╝" + reset + "\n" +
border_color + "  ║" + reset;
                System.out.println(bakery_layout);
                System.out.print("  ╚═[Select]─ ");
                String select_item = scanner.next();
                if (select_item.equals("0")) {
                    break;
                } else if (select_item.equals("s")){
                	show_cart_items();
                	sleep(1);
                } else if (select_item.equals("g")) {
                    counter();
                } else if (select_item.equals("c")) {
		        	if (!color_off) {
		        		color_off = true;
		        		color_switch();
		        	} else {
		        		color_off = false;
		        		color_switch();
		        	}
        		} else {
                    String item_data = get_price(2, select_item);
                    String[] item_data_arr = item_data.split("\\|");
                    String price = item_data_arr[0];
                    String name = item_data_arr[1];
                    if (!price.equals("null")) {
                        cart_items += item_data + ",";
                        t_ba += 1;
                        update_cart("bakery");
                        System.out.println("  "+white+"["+green+"+"+white+"]"+reset+" The '" +green+ name +reset+"' is added to cart.");
                        sleep(1);
                    } else {
                        Info("  "+white+"["+yellow+"!"+white+"]"+reset+" Sorry but that item is not available.\n");
                        sleep(3);
                    }
                }
            }
            main(null);
        } else if (select.equals("3")) {
            while (true) {
                clear();
                String vegies_layout = "\n"+
cyan + "   ┌─────────────────────────────────────┐" + reset + "\n" +
cyan + "   │ " + yellow + "Title      " + red + ":" + green + "  Mini Grocery Store    " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Developer  " + red + ":" + green + "  Juster M. Ube         " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Section    " + red + ":" + green + "  BSIT-NA               " + cyan + "│" + reset + "\n" +
cyan + "   ├─────────────────────────────────────┤" + reset + "\n" +
border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + reset +
border_color + "  ║" + reset + "    Category: Vegies  " + border_color + "║" + reset + "   Item Price   " + border_color + "║\n" + reset +
border_color + "  ╠══════════════════════╬════════════════╣\n" + reset +
border_color + "  ║--" + red + ">" + green + " 1. " + white + "Cucumber.      " + border_color + "║ " + green + "₱10 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 2. " + white + "Lettuce.       " + border_color + "║ " + green + "₱30 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 3. " + white + "Tomato.        " + border_color + "║ " + green + "₱50 " + yellow + "pr. wrap.  " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 4. " + white + "Potato.        " + border_color + "║ " + green + "₱25 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 5. " + white + "Onion.         " + border_color + "║ " + green + "₱20 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 6. " + white + "Cabbage.       " + border_color + "║ " + green + "₱30 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║                      ║                ║\n" + reset +
border_color + "  ║──────────────────────║────────────────║\n" + reset +
border_color + "  ║--" + red + ">" + red + " 0. " + white + "Back to CATG.  " + border_color + "║ " + white + "Total items in " + border_color + "║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " s. " + white + "Show items     " + border_color + "║ " + white + "cart" + red + ": " + green + cart + border_color + "   ║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " g. " + white + "Go to counter  " + border_color + "║" + border_color + "                ║" + reset + "\n" +
border_color + "  ║──────────────────────║────────────────║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " c. " + white + "on/off colors" + border_color + "  ║ " + white + "Status" + red + ": "+status+border_color + "║" + reset + "\n" +
border_color + "  ╠══════════════════════╩════════════════╝" + reset + "\n" +
border_color + "  ║" + reset;
                System.out.println(vegies_layout);
                System.out.print("  ╚═[Select]─ ");
                String select_item = scanner.next();
                if (select_item.equals("0")) {
                    break;
                } else if (select_item.equals("s")){
                	show_cart_items();
                	sleep(1);
                } else if (select_item.equals("g")) {
                    counter();
                } else if (select_item.equals("c")) {
		        	if (!color_off) {
		        		color_off = true;
		        		color_switch();
		        	} else {
		        		color_off = false;
		        		color_switch();
		        	}
        		} else {
                    String item_data = get_price(3, select_item);
                    String[] item_data_arr = item_data.split("\\|");
                    String price = item_data_arr[0];
                    String name = item_data_arr[1];
                    if (!price.equals("null")) {
                        cart_items += item_data + ",";
                        t_ve += 1;
                        update_cart("vegies");
                        System.out.println("  "+white+"["+green+"+"+white+"]"+reset+" The '" +green+ name +reset+"' is added to cart.");
                        sleep(1);
                    } else {
                        Info("  "+white+"["+yellow+"!"+white+"]"+reset+" Sorry but that item is not available.\n");
                        sleep(3);
                    }
                }
            }
            main(null);
        } else if (select.equals("4")) {
            while (true) {
                clear();
                String dairy_layout = "\n"+
cyan + "   ┌─────────────────────────────────────┐" + reset + "\n" +
cyan + "   │ " + yellow + "Title      " + red + ":" + green + "  Mini Grocery Store    " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Developer  " + red + ":" + green + "  Juster M. Ube         " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Section    " + red + ":" + green + "  BSIT-NA               " + cyan + "│" + reset + "\n" +
cyan + "   ├─────────────────────────────────────┤" + reset + "\n" +
border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + reset +
border_color + "  ║" + reset + "    Category: Dairy   " + border_color + "║" + reset + "   Item Price   " + border_color + "║\n" + reset +
border_color + "  ╠══════════════════════╬════════════════╣\n" + reset +
border_color + "  ║--" + red + ">" + green + " 1. " + white + "Cheese.        " + border_color + "║ " + green + "₱45 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 2. " + white + "Butter.        " + border_color + "║ " + green + "₱30 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 3. " + white + "Yogurt.        " + border_color + "║ " + green + "₱20 " + yellow + "pr. wrap.  " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 4. " + white + "Cream.         " + border_color + "║ " + green + "₱40 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 5. " + white + "Milk.          " + border_color + "║ " + green + "₱60 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 6. " + white + "Egg.           " + border_color + "║ " + green + "₱20 " + yellow + "pr. piece. " + border_color + "║\n" + reset +
border_color + "  ║                      ║                ║\n" + reset +
border_color + "  ║──────────────────────║────────────────║\n" + reset +
border_color + "  ║--" + red + ">" + red + " 0. " + white + "Back to CATG.  " + border_color + "║ " + white + "Total items in " + border_color + "║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " s. " + white + "Show items     " + border_color + "║ " + white + "cart" + red + ": " + green + cart + border_color + "   ║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " g. " + white + "Go to counter  " + border_color + "║" + border_color + "                ║" + reset + "\n" +
border_color + "  ║──────────────────────║────────────────║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " c. " + white + "on/off colors" + border_color + "  ║ " + white + "Status" + red + ": "+status+border_color + "║" + reset + "\n" +
border_color + "  ╠══════════════════════╩════════════════╝" + reset + "\n" +
border_color + "  ║" + reset;
                System.out.println(dairy_layout);
                System.out.print("  ╚═[Select]─ ");
                String select_item = scanner.next();
                if (select_item.equals("0")) {
                    break;
                } else if (select_item.equals("s")){
                	show_cart_items();
                	sleep(1);
                } else if (select_item.equals("g")) {
                    counter();
                } else if (select_item.equals("c")) {
		        	if (!color_off) {
		        		color_off = true;
		        		color_switch();
		        	} else {
		        		color_off = false;
		        		color_switch();
			        }
        		} else {
                    String item_data = get_price(4, select_item);
                    String[] item_data_arr = item_data.split("\\|");
                    String price = item_data_arr[0];
                    String name = item_data_arr[1];
                    if (!price.equals("null")) {
                        cart_items += item_data + ",";
                        t_da += 1;
                        update_cart("dairy");
                        System.out.println("  "+white+"["+green+"+"+white+"]"+reset+" The '" +green+ name +reset+"' is added to cart. ");
                        sleep(1);
                    } else {
                        Info("  "+white+"["+yellow+"!"+white+"]"+reset+" Sorry but that item is not available.\n");
                        sleep(3);
                    }
                }
            }
            main(null);
        } else if (select.equals("5")) {
            while (true) {
                clear();
                String meat_layout = "\n"+
cyan + "   ┌─────────────────────────────────────┐" + reset + "\n" +
cyan + "   │ " + yellow + "Title      " + red + ":" + green + "  Mini Grocery Store    " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Developer  " + red + ":" + green + "  Juster M. Ube         " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Section    " + red + ":" + green + "  BSIT-NA               " + cyan + "│" + reset + "\n" +
cyan + "   ├─────────────────────────────────────┤" + reset + "\n" +
border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + reset +
border_color + "  ║" + reset + "    Category: Meat    " + border_color + "║" + reset + "   Item Price   " + border_color + "║\n" + reset +
border_color + "  ╠══════════════════════╬════════════════╣\n" + reset +
border_color + "  ║--" + red + ">" + green + " 1. " + white + "Chicken.       " + border_color + "" + border_color + "║" + green + " ₱200" + yellow + " 1kg.      " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 2. " + white + "Bacon.         " + border_color + "║" + green + " ₱140" + yellow + " pack      " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 3. " + white + "Pork.          " + border_color + "║" + green + " ₱250" + yellow + " 1kg       " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 4. " + white + "Beef.          " + border_color + "║" + green + " ₱250" + yellow + " 1kg       " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 5. " + white + "Duck.          " + border_color + "║" + green + " ₱230" + yellow + "" + yellow + " 1kg       " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 6. " + white + "Ham.           " + border_color + "║" + green + " ₱120" + yellow + " pack      " + border_color + "║\n" + reset +
border_color + "  ║                      ║                ║\n" + reset +
border_color + "  ║──────────────────────║────────────────║\n" + reset +
border_color + "  ║--" + red + ">" + red + " 0. " + white + "Back to CATG.  " + border_color + "║ " + white + "Total items in " + border_color + "║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " s. " + white + "Show items     " + border_color + "║ " + white + "cart" + red + ": " + green + cart + border_color + "   ║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " g. " + white + "Go to counter  " + border_color + "║" + border_color + "                ║" + reset + "\n" +
border_color + "  ║──────────────────────║────────────────║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " c. " + white + "on/off colors" + border_color + "  ║ " + white + "Status" + red + ": "+status+border_color + "║" + reset + "\n" +
border_color + "  ╠══════════════════════╩════════════════╝" + reset + "\n" +
border_color + "  ║" + reset;
                System.out.println(meat_layout);
                System.out.print("  ╚═[Select]─ ");
                String select_item = scanner.next();
                if (select_item.equals("0")) {
                    break;
                } else if (select_item.equals("s")){
                	show_cart_items();
                	sleep(1);
                } else if (select_item.equals("g")) {
                    counter();
                } else if (select_item.equals("c")) {
		        	if (!color_off) {
		        		color_off = true;
		        		color_switch();
		        	} else {
		        		color_off = false;
		        		color_switch();
		        	}
        		} else {
                    String item_data = get_price(5, select_item);
                    String[] item_data_arr = item_data.split("\\|");
                    String price = item_data_arr[0];
                    String name = item_data_arr[1];
                    if (!price.equals("null")) {
                        cart_items += item_data + ",";
                        t_me += 1;
                        update_cart("meat");
                        System.out.println("  "+white+"["+green+"+"+white+"]"+reset+" The '" +green+ name +reset+"' is added to cart.");
                        sleep(1);
                    } else {
                        Info("  "+white+"["+yellow+"!"+white+"]"+reset+" Sorry but that item is not available.\n");
                        sleep(3);
                    }
                }
            }
            main(null);

        } else if (select.equals("6")) {
            while (true) {
                clear();
                String meat_layout = "\n" +
cyan + "   ┌─────────────────────────────────────┐" + reset + "\n" +
cyan + "   │ " + yellow + "Title      " + red + ":" + green + "  Mini Grocery Store    " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Developer  " + red + ":" + green + "  Juster M. Ube         " + cyan + "│" + reset + "\n" +
cyan + "   │ " + yellow + "Section    " + red + ":" + green + "  BSIT-NA               " + cyan + "│" + reset + "\n" +
cyan + "   ├─────────────────────────────────────┤" + reset + "\n" +
border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + reset +
border_color + "  ║ "+reset+"Category: Others  " + border_color + "   ║"+reset+" Item Price     " + border_color + "║\n" + reset +
border_color + "  ╠══════════════════════╬════════════════╣\n" + reset +
border_color + "  ║--" + red + ">" + green + " 1. " + white + "Coffee.        " + border_color + "║ " + green + "₱30 " + yellow + "bottle     " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 2. " + white + "Tea.           " + border_color + "║ " + green + "₱30 " + yellow + "bottle     " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 3. " + white + "Soda.          " + border_color + "║ " + green + "₱20 " + yellow + "bottle     " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 4. " + white + "Ketchup.       " + border_color + "║ " + green + "₱20 " + yellow + "pouch      " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 5. " + white + "Pepper.        " + border_color + "║ " + green + "₱13 " + yellow + "pouch      " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 6. " + white + "Salt.          " + border_color + "║ " + green + "₱25 " + yellow + "1kg        " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 7. " + white + "Oregano.       " + border_color + "║ " + green + "₱15 " + yellow + "pack       " + border_color + "" + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 8. " + white + "Ice cream.     " + border_color + "║ " + green + "₱80 " + yellow + "box        " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 9. " + white + "Noodles.       " + border_color + "║ " + green + "₱23 " + yellow + "pack       " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 10. " + white + "Lolipop.      " + border_color + "║ " + green + "₱70 " + yellow + "pack       " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 11. " + white + "Vinegar.      " + border_color + "║ " + green + "₱15 " + yellow + "pouch      " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 12. " + white + "Water.        " + border_color + "║ " + green + "₱15 " + yellow + "bottle     " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 13. " + white + "Pasta.        " + border_color + "║ " + green + "₱45 " + yellow + "pack       " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 14. " + white + "Sardines.     " + border_color + "║ " + green + "₱23 " + yellow + "canned     " + border_color + "║\n" + reset +
border_color + "  ║--" + red + ">" + green + " 15. " + white + "Popcorn.      " + border_color + "║ " + green + "₱74 " + yellow + "pack       " + border_color + "║\n" + reset +
border_color + "  ║                      ║                ║\n" + reset +
border_color + "  ║──────────────────────║────────────────║\n" + reset +
border_color + "  ║--" + red + ">" + red + " 0. " + white + "Back to CATG.  " + border_color + "║ " + white + "Total items in " + border_color + "║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " s. " + white + "Show items     " + border_color + "║ " + white + "cart" + red + ": " + green + cart + border_color + "   ║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " g. " + white + "Go to counter  " + border_color + "║" + border_color + "                ║" + reset + "\n" +
border_color + "  ║──────────────────────║────────────────║" + reset + "\n" +
border_color + "  ║--" + red + ">" + green + " c. " + white + "on/off colors" + border_color + "  ║ " + white + "Status" + red + ": "+status+border_color + "║" + reset + "\n" +
border_color + "  ╠══════════════════════╩════════════════╝" + reset + "\n" +
border_color + "  ║" + reset;
                System.out.println(meat_layout);
                System.out.print("  ╚═[Select]─ ");
                String select_item = scanner.next();
                if (select_item.equals("0")) {
                    break;
                } else if (select_item.equals("s")){
                	show_cart_items();
                	sleep(1);
                } else if (select_item.equals("g")) {
                    counter();
                } else if (select_item.equals("c")) {
		        	if (!color_off) {
		        		color_off = true;
		        		color_switch();
		        	} else {
		        		color_off = false;
		        		color_switch();
		        	}
        		} else {
                    String item_data = get_price(6, select_item);
                    String[] item_data_arr = item_data.split("\\|");
                    String price = item_data_arr[0];
                    String name = item_data_arr[1];
                    if (!price.equals("null")) {
                        cart_items += item_data + ",";
                        t_ot += 1;
                        update_cart("others");
                        System.out.println("  "+white+"["+green+"+"+white+"]"+reset+" The '" +green+ name +reset+"' is added to cart.");
                        sleep(1);
                    } else {
                        Info("  "+white+"["+yellow+"!"+white+"]"+reset+" Sorry but that item is not available.\n");
                        sleep(3);
                    }
                }
            }
            main(null);


        } else if (select.equals("0")) {
            if (count_cart_item > 0) {
                while (true) {
                    System.out.println("  [!] Your cart is not empty.");
                    Info("  [?] Still go exit? (y/N): ");
                    String ext = scanner.next();

                    if (ext.toLowerCase().equals("y")) {
                        break;
                    } else {
                        main(null);
                    }
            }

            }
            Info("  "+white+"["+green+"+"+white+"]"+reset+" Thank you for visiting, come again!\n");
            scanner.close();
            System.exit(0);
        } else if (select.equals("g")){
            counter();
            main(null);

        } else if (select.equals("s")) {
        	if (cart_items.equals("")) {
        		Info("  "+white+"["+blue+"*"+white+"]"+reset+" Ow, It looks like your cart is empty...\n");
        	} else { 
        		show_cart_items();
        	}
        	sleep(2);
        	main(null);
        } else if (select.equals("c")) {
        	if (!color_off) {
        		color_off = true;
        		main(null);
        	} else {
        		color_off = false;
        		main(null);
        	}
        } else {
            Info("  "+white+"["+yellow+"!"+white+"]"+reset+" Sorry but that category is not available.\n");
            sleep(3);
            main(null);
        }
    }
}


