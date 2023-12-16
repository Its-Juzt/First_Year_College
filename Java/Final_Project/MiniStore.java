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

    static class Color {
        String red = "";
        String green = "";
        String blue = "";
        String yellow = "";
        String cyan = "";
        String purple = "";
        String white = "";
        String border_color = "";
        String reset = "";
        String status = "";
    }

    public static Color colorSwitch(Boolean colorOff) {
        Color color = new Color();

        if (!colorOff) {
            color.red = "\033[0;91m";
            color.green = "\033[0;92m";
            color.blue = "\033[0;94m";
            color.yellow = "\033[0;93m";
            color.cyan = "\033[0;96m";
            color.purple = "\033[0;95m";
            color.white = "\033[0;97m";
            color.border_color = "\033[38;5;60m";
            color.reset = "\033[0m";
        }

        if (!colorOff) {
            color.status = color.green + "ON     " + color.reset;
        } else {
            color.status = "OFF    ";
        }
        return color;
    }


    public static void clear() {
        System.out.print("\033[0;97m");
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



    public static void Info(String msg) {
        try {
            for (int i = 0; i < msg.length(); i++) {
                System.out.print(msg.charAt(i));
                Thread.sleep(50);
            }
        } catch (InterruptedException exp) {
            return;
        }
        System.out.print("");
    }



    public static void Instruction_usage(Boolean color_off) {
        Color color = colorSwitch(color_off);
        String intruct = "\n"
            +color.cyan+"   Instructions:\n\n"

            +color.red+" (1."+color.green+" Navigate through grocery categories by\n"
            +"     selecting number from: 1, 2, 3, 4, 5, 6.\n"
            +"     Example: Press '1' to select the Fruits\n"
            +"     category.\n\n"+color.reset

            +color.red+" (2."+color.green+" Explore subcategories by pressing Enter\n"
            +"     after selecting a main category.\n"
            +"     Example: After selecting '1' for Fruits,\n"
            +"     press Enter to view available fruit items.\n\n"

            +color.red+" (3."+color.green+" Add items to cart by selecting the number\n"
            +"     on the left side of the item.\n"
            +"     Example: on Fruit category Press '1' then\n"
            +"     Enter to add 'Pineapple' to cart.\n\n"+color.reset

            +color.red+" (4."+color.green+" View your cart by pressing 's'.\n"
            +"     Example: Press 's' to show the items\n"
            +"     currently in your cart.\n\n"+color.reset

            +color.red+" (5."+color.green+" Proceed to the counter by pressing 'g' then Enter.\n"
            +"     Example: Press 'g' and then hit Enter to go to\n"
            +"     the counter and complete your purchase.\n\n"+color.reset

            +color.red+" (6."+color.green+" On or off color display by pressing 'c' then Enter.\n"
            +"     turn on Black and white or Colored mode.\n\n"+color.reset

            +color.red+" (7."+color.green+" Exit the program by pressing '0' then Enter.\n"
            +"     Example: Press '0' to exit the Grocery Store.\n\n"+color.reset

            +color.yellow+"  NOTE: Select the characters indicated by\n"
            +"  the arrow "+color.cyan+"'-->'"+color.yellow+" to perform actions.\n"+color.reset;
        System.out.println(intruct);
        System.out.print("  " + color.white+ "[" + color.green + "?" + color.white+ "]" + color.reset + " Press 'Enter' key to proceed..." + color.reset);
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    } 



    public static String byebye_msg() {
        String[] msg_list = {
            "Thank you for shopping with us! Have a great day!",
            "We appreciate your visit. Come back soon!",
            "It was a pleasure having you in our store. Goodbye!",
            "Until next time! Take care and happy shopping.",
            "Wishing you a wonderful day ahead. Come again!",
            "We hope you enjoyed your shopping experience. Come back soon!",
            "Thank you for shopping with us.",
            "Have a good day and take care. Your satisfaction is our success!"
        };

        Random random = new Random();
        int index = random.nextInt(msg_list.length);

        return msg_list[index];
    }



    public static String get_price(int category, String str_item) {
        String[] grocery_list = {
            "",
            ",30|pineapple,30|melon,60|banana,10|orange,30|grapes,300|apple,15|mango",
            ",20|cupcakes,20|cookies,30|donuts,30|bread,90|cake,80|pie",
            ",10|cucumber,30|lettuce,50|tomato,25|potato,20|onion,30|cabbage",
            ",45|cheese,30|butter,20|yogurt,40|cream,60|milk,20|egg",
            ",200|chicken,140|bacon,250|pork,250|beef,250|duck,230|ham",
            ",30|coffee,30|tea,20|soda,20|ketchup,15|peper,25|salt,15|oregano,80|ice cream,23|noodles,30|lolipop,70|vinegar,15|water,45|pasta,23|sardines,74|popcorn"
        };

        // check if there is Integer in item

        try {
            Integer.parseInt(str_item);
        } catch (NumberFormatException numf) {
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
                if (item >= 1 && item < 16) {
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
        } else {
            return "null|404";
        }

    }



    public static void Display_CartItems(String cart_items,Color color) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(currentDate);

        clear();
        String item_list_layout = "\n" +
            color.cyan + "   ┌─────────────────────────────────────┐\n" + color.reset +
            color.cyan + "   │ " + color.yellow + "Title      " + color.red + ":" + color.green + "  Mini Grocery Store" + color.cyan + "    │\n" + color.reset +
            color.cyan + "   │ " + color.yellow + "Date       " + color.red + ":" + color.green + "  " + formattedDate +"            " + color.cyan + "│" + color.reset + "\n" +
            color.cyan + "   │ " + color.yellow + "Developer  " + color.red + ":" + color.green + "  Juster M. Ube     " + color.cyan + "    │\n" + color.reset +
            color.cyan + "   │ " + color.yellow + "Section    " + color.red + ":" + color.green + "  BSIT-NA           " + color.cyan + "    │\n" + color.reset +
            color.cyan + "   ├─────────────────────────────────────┤\n" + color.reset +
            color.border_color + "  ╔╩══════════════════╤══════════════════╩╗\n" + color.reset +
            color.border_color + "  ║ " + color.green + "Item              " + color.border_color + "│ " + color.green + "Quantity" + color.border_color + "          ║\n" + color.reset +
            color.border_color + "  ╠═══════════════════╪═══════════════════╣" + color.reset;

        System.out.println(item_list_layout);
        int totalitems = 0;
        ArrayList < String > done_list = new ArrayList < > ();
        ArrayList < String > removed_duplicates = new ArrayList < > ();

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
            System.out.print(color.border_color + "  ║ " + color.green + item + color.border_color + " │" + color.reset);

            String quantity = String.valueOf(count);
            while (quantity.length() < 17) {
                quantity += " ";
            }
            System.out.print(" " + quantity + color.border_color + " ║\n" + color.reset);
        }
        System.out.println(color.border_color + "  ╠═══════════════════╧═══════════════════╣" + color.reset);
        String total_layout = String.valueOf(totalitems);
        while (total_layout.length() < 24) {
            total_layout += " ";
        }
        System.out.println(color.border_color + "  ║ " + color.yellow + "Total Items" + color.red + ": " + color.green + total_layout + color.border_color + " ║" + color.reset);

        System.out.println(color.border_color + "  ╚═══════════════════════════════════════╝" + color.reset);
        Scanner press = new Scanner(System.in);
        System.out.print(color.white + "  [" + color.green + " Enter to Back " + color.white+ "]" + color.reset);
        String back = press.nextLine();
    }



    public static void printout_receipt(String receipt, int input_money, int total, boolean is_card, String cashier_lay,Color color) {
        System.out.println(cashier_lay);
        receipt = receipt.replace("║", color.border_color + "│" + color.reset).replace("╤", color.border_color + "┬").replace("╣", color.border_color + "┤" + color.reset).replace("╠", color.border_color + "├").replace("═", color.border_color + "─").replace("╪", color.border_color + "┼").replace("╗", color.border_color + "┐").replace("╔", "┌").replace("╧", color.border_color + "┴");
        String total_layout = color.blue + "Total cost  : " + color.green + "₱" + total;
        String ammont_layout = color.blue + "Amount paid : " + color.green + "₱" + input_money;
        int change = input_money - total;
        String change_layout = color.blue + "Change      : " + color.green + "₱" + change;

        if (is_card) {
            ammont_layout = color.blue + "Amount Paid :" + color.green + " Used a credit card.";
            change_layout = color.blue + "Change      :" + color.green + " N/A";
        }

        int length_money = String.valueOf(input_money).length();
        int length_total = String.valueOf(total).length();

        if (length_total == 3) {
            total_layout += color.border_color + "                  │" + color.reset;
        } else if (length_total == 4) {
            total_layout += color.border_color + "                 │" + color.reset;
        } else if (length_total == 2) {
            total_layout += color.border_color + "                   │" + color.reset;
        } else if (length_total == 5) {
            total_layout += color.border_color + "                │" + color.reset;
        } else if (length_total == 6) {
            total_layout += color.border_color + "               │" + color.reset;
        }

        receipt += color.border_color + "  │ " + total_layout + "\n";

        int breaker = String.valueOf(ammont_layout).length();
        int brkf = color.green.length();
        if (brkf != 0) {
            int brk = 35 + 14;
            breaker = brk - breaker;
        } else {
            breaker = 35 - breaker;
        }

        for (int i = 0; i < breaker; i++) {
            ammont_layout += " ";
        }
        receipt += color.border_color + "  │ " + ammont_layout + color.border_color + " │\n" + color.reset;

        breaker = String.valueOf(change_layout).length();
        if (brkf != 0) {
            int brk = 35 + 14;
            breaker = brk - breaker;
        } else {
            breaker = 35 - breaker;
        }
        for (int i = 0; i < breaker; i++) {
            change_layout += " ";
        }
        receipt += color.border_color + "  │ " + change_layout + color.border_color + " │\n" + color.reset;
        receipt += color.border_color + "  │─────────────────────────────────────│\n" + color.reset +
            color.border_color + "  │" + color.yellow + "              Thank you !            " + color.border_color + "│\n" + color.reset +
            color.border_color + "  │" + color.yellow + "         Visit Us Again Soon!        " + color.border_color + "│\n" + color.reset +
            color.border_color + "  └─────────────────────────────────────┘" + color.reset;
        String[] dots = {
            ".    ",
            "..  ",
            "... ",
            "...."
        };
        for (int run = 0; run < 3; run++) {
            for (int i = 0; i < dots.length; i++) {
                System.out.print("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Please wait a moment" + dots[i] + "\r");
                sleep(4101);
            }
        }
        System.out.print("                                         \r");
        String[] animate_recept = receipt.split("\n");
        for (int x = 0; x < animate_recept.length; x++) {
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
        Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Here is your receipt ma'am/sir...\n" + color.reset);
        Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "] " + color.green + byebye_msg() +" \n" + color.reset);
        System.exit(0);

    }


    public static void payment_card(String receipt_layout, int money, int total_cost, String cashier_lay,Color color) {

        Scanner scan = new Scanner(System.in);
        int valid_card_number = 0;
        String expire_date = "";
        while (true) {
            while (true) {
                System.out.print("  " + color.white+ "[" + color.green + "?" + color.white+ "]" + color.reset + " Enter 8 digit card number: " + color.green);
                String card_number = scan.next();
                if (card_number.length() == 8) {
                    try {
                        valid_card_number = Integer.parseInt(card_number);
                        if (valid_card_number != 0) {
                            break;
                        }
                    } catch (NumberFormatException nfe) {
                        Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.yellow + " Error: Please enter a valid card number.\n" + color.reset);
                    }
                } else {
                    Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.yellow + " Error: Please enter a valid card number.\n" + color.reset);
                }

            }
            while (true) {
                String[] month_list = {
                    "01",
                    "02",
                    "03",
                    "04",
                    "05",
                    "06",
                    "07",
                    "08",
                    "09",
                    "10",
                    "11",
                    "12"
                };
                int expired_year = 2022;
                int fake_card = 2028;
                System.out.print("  " + color.white+ "[" + color.green + "?" + color.white+ "]" + color.reset + " Enter expiration date (ex: 01/2024): " + color.green);
                String expdate = scan.next();
                if (expdate.contains("/")) {
                    boolean valid = false;
                    String[] date = expdate.split("/");
                    if (date.length == 2) {
                        for (int x = 0; x < month_list.length; x++) {
                            if (month_list[x].equals(date[0])) {
                                valid = true;
                            }
                        }

                        if (valid) {
                            try {
                                int year = Integer.parseInt(date[1]);
                                if (year < expired_year) {
                                    Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.red + " Error: The credit card was expired.\n" + color.reset);
                                    System.out.println();
                                    break;
                                } else if (year > 2028) {
                                    Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.red + " Error: The credit card might not valid (valid < 2028)\n" + color.reset);
                                    System.out.println();
                                    break;
                                } else {
                                    sleep(1);
                                    clear();
                                    printout_receipt(receipt_layout, money, total_cost, true, cashier_lay,color);
                                }
                            } catch (NumberFormatException nfe) {
                                Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.yellow + " Error: Please enter a valid expiration year.\n" + color.reset);
                            }
                        } else {
                            Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.yellow + " Error: Please enter a valid expiration month.\n" + color.reset);
                        }

                    } else {
                        Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.yellow + " Error: Please enter a valid expiration date.\n" + color.reset);
                    }
                } else {
                    Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.yellow + " Error: Please enter a valid expiration date.\n" + color.reset);
                }
            }
        }

    }



    public static void counter(String cart_items,Color color) {
        if (cart_items.equals("")) {
            System.out.println("\n  " + color.white+ "[" + color.yellow + "!" + color.white+ "]" + color.reset + " Good day Ma'am/Sir !");
            Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Ow, It looks like your cart is empty...\n" + color.reset);
            sleep(3);
            return;
        }
        clear();

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(currentDate);

        String receipt_layout = "\n" + color.reset +
            color.border_color + "  ┌─────────────────────────────────────┐\n" + color.reset +
            color.border_color + "  │" + color.cyan + "          Mini Grocery Store" + color.border_color + "         │\n" + color.reset +
            color.border_color + "  │" + color.green + "    Code by Juster M. Ube BSIT-NA" + color.border_color + "    │\n" + color.reset +
            color.border_color + "  │" + color.green + "       Contact no. " + color.red + "0987654321" + color.border_color + "        │\n" + color.reset +
            color.border_color + "  ├─────────────────────────────────────┤\n" + color.reset +
            color.border_color + "  │" + color.cyan + "      Reciept Date " + color.white+ "-" + color.green + " " + formattedDate + "" + color.border_color + "      │\n" + color.reset +
            color.border_color + "  ╠═══════════╤═══════╤════════╤════════╣\n" + color.reset +
            color.border_color + "  ║ " + color.red + "Item      " + color.border_color + "│" + color.red + " Qty " + color.border_color + "  │" + color.red + " Price  " + color.border_color + "│" + color.red + " Cost   " + color.border_color + "║\n" + color.reset +
            color.border_color + "  ╠═══════════╪═══════╪════════╪════════╣\n" + color.reset;

        String total_item_layout = "";
        String counter_layout = "\n" +
            color.cyan + "   ┌───────────────────────────────────┐" + color.reset + "\n" +
            color.cyan + "   │ " + color.yellow + "Title      " + color.red + ":" + color.green + "  Mini Grocery Store  " + color.cyan + "│" + color.reset + "\n" +
            color.cyan + "   │ " + color.yellow + "Date       " + color.red + ":" + color.green + "  " + formattedDate +"          " + color.cyan + "│" + color.reset + "\n" +
            color.cyan + "   │ " + color.yellow + "Developer  " + color.red + ":" + color.green + "  Juster M. Ube       " + color.cyan + "│" + color.reset + "\n" +
            color.cyan + "   │ " + color.yellow + "Section    " + color.red + ":" + color.green + "  BSIT-NA             " + color.cyan + "│" + color.reset + "\n" +
            color.cyan + "   ├───────────────────────────────────┤\n" + color.reset +
            color.border_color + "  ╔╩═══════════════════════════════════╩╗\n" + color.reset +
            color.border_color + "  ║         " + color.green + "[ " + color.white + "Checkout Counter " + color.green + "]" + color.border_color + "        ║\n" + color.reset +
            color.border_color + "  ║                                     ║" + color.reset;
        Random random = new Random();

        // generate random question for asking payment..
        String[] names = {
            "Emma",
            "Liam",
            "Olivia",
            "Noah",
            "Ava",
            "William",
            "Sophia",
            "James",
            "Isabella"
        };
        int random_name_index = random.nextInt(names.length);
        String random_name = names[random_name_index];
        int cash_id = 0;
        for (int x = 0; x <= names.length; x++) {
            if (names[x].equals(random_name)) {
                cash_id = x;
                break;
            }
        }

        for (int x = 0; x <= 11; x++) {
            if (random_name.length() != 11) {
                random_name += " ";
            } else {
                random_name += color.border_color + " ║" + color.reset;
            }
        }

        String cashier_layout = "" + color.reset +
            color.border_color + "  ╠════════════════╦════════════════════╣\n" + color.reset +
            color.border_color + "  ║  " + color.yellow + "Cashier No. " + color.green + "" + cash_id + color.border_color + " ║  " + color.yellow + "Name: " + color.green + "" + random_name + "\n" + color.reset +
            color.border_color + "  ╠════════════════╩════════════════════╣" + color.reset;

        String cst_layout = "" + color.reset +
            color.border_color + "  ╠═══════════╤═══════╤════════╤════════╣\n" + color.reset +
            color.border_color + "  ║ " + color.red + "Item" + color.border_color + "      │ " + color.red + "Qty" + color.border_color + "   │ " + color.red + "Price" + color.border_color + "  │ " + color.red + "Cost" + color.border_color + "   ║\n" + color.reset +
            color.border_color + "  ╠═══════════╪═══════╪════════╪════════╣\n" + color.reset;

        System.out.println(counter_layout);
        System.out.println(cashier_layout.strip()+"\n  " + color.border_color + "║" + color.blue + " *Checking items, Please wait...     " + color.border_color + "║" + color.reset);

        sleep(3);

        System.out.print(cst_layout);

        ArrayList <String> done_list = new ArrayList <> ();
        ArrayList <String> removed_duplicates = new ArrayList <> ();
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
                layout_item += color.border_color + "│" + color.reset; // hits the end add the box end.
            } else {
                name = name + color.border_color + " ║" + color.reset; // if 9 then just add directly a box end.
            }

            layout_item = color.border_color + "  ║ " + color.reset + color.green + layout_item + color.reset;

            int item_qty = 0;
            // count quantity | the current item duplicates on the cart_item
            for (String qty: cart_item) {
                if (item.equals(qty)) {
                    item_qty += 1;
                }
            }
            done_list.add(item); // add to done list.

            // calulate the length of quantity to fit the box

            int qty_length = String.valueOf(item_qty).length();
            String quantity_layout = "";
            if (qty_length == 1) {
                quantity_layout = " " + color.green + item_qty + color.border_color + "     │" + color.reset;
            } else if (qty_length == 2) {
                quantity_layout = " " + color.green + item_qty + color.border_color + "    │" + color.reset;
            } else if (qty_length == 3) {
                quantity_layout = " " + color.green + item_qty + color.border_color + " │" + color.reset;
            }

            // calculate the length of price to fit the box

            int price_length = String.valueOf(price).length();
            String price_layout = "";

            if (price_length == 2) {
                price_layout = color.green + " ₱" + price + color.border_color + "    │" + color.reset;
            } else if (price_length == 3) {
                price_layout = color.green + " ₱" + price + color.border_color + "   │" + color.reset;
            }

            // calculate the length of price to fit the box
            int item_price = Integer.parseInt(price);
            int item_cost = item_qty * item_price;

            String str_cost = String.valueOf(item_cost);
            int item_cost_length = String.valueOf(item_cost).length();
            String cost_layout = "";

            if (item_cost_length == 2) {
                cost_layout = color.green + " ₱" + str_cost + color.border_color + "    ║" + color.reset;
            } else if (item_cost_length == 3) {
                cost_layout = color.green + " ₱" + str_cost + color.border_color + "   ║" + color.reset;
            } else if (item_cost_length == 4) {
                cost_layout = color.green + " ₱" + str_cost + color.border_color + "  ║" + color.reset;
            } else if (item_cost_length == 5) {
                cost_layout = color.green + " ₱" + str_cost + color.border_color + " ║" + color.reset;
            }

            total_cost += item_cost;
            // append all to total_item_layout
            total_item_layout += layout_item + quantity_layout + price_layout + cost_layout + "\n" + color.reset;
            if (count_column != total_column) {
                total_item_layout += color.border_color + "  ╠───────────┼───────┼────────┼────────╣\n" + color.reset;
            } else {
                total_item_layout += color.border_color + "  ╠═══════════╧═══════╧════════╧════════╣\n" + color.reset;
            }
        }

        receipt_layout += total_item_layout;

        // calculate total cost.
        String total_cost_layout = color.blue + " Total cost:" + color.green + " ₱"; // to end = 24 
        String append_cost = String.valueOf(total_cost);

        while (append_cost.length() < 23) {
            append_cost += " ";
        }
        append_cost += color.border_color + "║";
        total_item_layout += color.border_color + "  ║" + total_cost_layout + append_cost + "\n" + color.reset;

        total_item_layout += color.border_color + "  ╚═════════════════════════════════════╝\n" + color.reset;

        String[] animate = total_item_layout.split("\n");
        for (int x = 0; x < animate.length; x++) {
            System.out.println(animate[x]);
            if (x < animate.length-2) {
                System.out.print("  " + color.border_color + "╚════" + color.white+ "[ " + color.green + "Reading items, Please wait" + color.white+ " ]" + color.border_color + "═══╝\r" + color.reset);
            } else {
                System.out.print("                                          \r");
            }
            sleep(4101);
        }
        Scanner scan2 = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.print("\r  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Read Complete...                      " + color.reset);
        System.out.print("\n  " + color.white+ "[" + color.green + "?" + color.white+ "]" + color.reset + " Press 'Enter' key to proceed..." + color.reset);
        if (scan2.hasNextLine())

            /* payment code | cashier layout */

            while (true) {
                clear();
                String print_cost = String.valueOf(total_cost);
                String[] question_list = {
                    "Your total: ₱" + print_cost + " How will you be paying today?",
                    "Total amount: ₱" + print_cost + ". Will it be card or cash?",
                    "Your payment for the total of ₱" + print_cost + ", how'd you like to handle that?",
                    "The total comes to ₱" + print_cost + ". What way you'd like to pay?"
                };

                int choice = random.nextInt(question_list.length);
                String question = question_list[choice].strip();
                String[] split_question = question.split(" ");
                String question_layout = "";
                int used_column = 0;
                /* fit the question to box code*/
                System.out.print(counter_layout);
                System.out.println("\n" + cashier_layout + color.reset);
                System.out.println(color.border_color + "  ║                                     ║");
                for (int x = 0; x < split_question.length; x++) {
                    if (question_layout.length() > 27 && question_layout.length() < 34) {
                        for (int i = 0; i < 34; i++) {
                            if (question_layout.length() != 34) {
                                question_layout += " ";
                            } else {
                                used_column += 1;
                            }
                        }
                        System.out.println(color.border_color + "  ║  " + color.green + question_layout + color.border_color + " ║");
                        question_layout = "";
                    }
                    question_layout += split_question[x] + " ";
                }
                if (question_layout.length() != 0) {
                    for (int x = 0; x < 34; x++) {
                        if (question_layout.length() != 34) {
                            question_layout += " ";
                        } else {
                            used_column += 1;
                        }
                    }
                }

                System.out.println(color.border_color + "  ║  " + color.green + question_layout + color.border_color + " ║" + color.reset);

                if (used_column < 4) {
                    for (int x = 0; x < (4 - used_column); x++) {
                        System.out.println(color.border_color + "  ║                                     ║" + color.reset);
                    }
                }

                String question_layout_box_end = "" + color.reset +
                    color.border_color + "  ║─────────────────────────────────────║" + color.reset +
                    color.border_color + "\n  ║"+color.cyan+"--" + color.red + ">" + color.green + " 1. " + color.white+ "Pay via cash." + color.border_color + "                 ║" + color.reset +
                    color.border_color + "\n  ║"+color.cyan+"--" + color.red + ">" + color.green + " 2. " + color.white+ "Pay via credit card." + color.border_color + "          ║" + color.reset +
                    color.border_color + "\n  ╠═════════════════════════════════════╝" + color.reset +
                    color.border_color + "\n  ║" + color.reset;
                System.out.println(question_layout_box_end);
                System.out.print(color.border_color + "  ╚═[" + color.green + "Select" + color.border_color + "]─ " + color.green);

                String selectotal_meatthod = scan.nextLine();
                String cashier_lay = counter_layout + "\n" + cashier_layout.replace("╠════════════════╩════════════════════╣", color.border_color + "╚════════════════╩════════════════════╝" + color.reset).strip();
                /* payment methods.*/
                if (selectotal_meatthod.equals("1")) {
                    clear();
                    System.out.println(cashier_lay);
                    while (true) {
                        System.out.print("  " + color.white+ "[" + color.green + "?" + color.white+ "]" + color.white + " Enter amount of money: " + color.green);
                        String input_money = scan.nextLine();
                        if (!input_money.equals("")) {
                            try {
                                int money = Integer.parseInt(input_money);
                                if (money > total_cost) {
                                    sleep(1);
                                    clear();
                                    printout_receipt(receipt_layout, money, total_cost, false, cashier_lay,color);

                                } else {
                                    Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " I think your money is not enough...\n" + color.reset);
                                    while (true) {
                                        System.out.print("  " + color.white+ "[" + color.green + "?" + color.white+ "]" + color.reset + " Do you want to add your money (Y/n): " + color.green);
                                        String ask_to_swtich = scan.nextLine();
                                        if (ask_to_swtich.toLowerCase().equals("y")) {
                                            while (money < total_cost) {
                                                try {
                                                    System.out.print(color.reset + "  [" + color.blue + money + color.reset + "/" + color.green + total_cost + color.reset + "] Enter amount of money to add: " + color.green);
                                                    int add_m = Integer.parseInt(scan.next());
                                                    money += add_m;
                                                } catch (Exception exp) {
                                                    Info(color.reset+"  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.red + " Error while processing the money...\n" + color.reset);
                                                    int add_m = 0;
                                                }
                                            }
                                            System.out.println("  [" + color.green + money + color.reset + "/" + color.green + total_cost + color.reset +"] I think that was enough amount..." + color.reset);
                                            sleep(1);
                                            clear();
                                            printout_receipt(receipt_layout, money, total_cost, false, cashier_lay,color);

                                        } else if (ask_to_swtich.toLowerCase().equals("n")) {
                                            boolean is_cancel = false;
                                            while (true) {
                                                System.out.print("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Use credit card or cancel (cr/cc)?: " + color.green);
                                                String crcc = scan.nextLine();
                                                if (crcc.toLowerCase().equals("cr")) {

                                                    payment_card(receipt_layout, money, total_cost, cashier_lay,color);

                                                } else if (crcc.toLowerCase().equals("cc")) {
                                                    Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " You will be charged ₱50 if you cancel\n" + color.reset);
                                                    System.out.print("  " + color.white+ "[" + color.green + "?" + color.white+ "]" + color.reset + " Still exit (y/N)?: " + color.green);

                                                    String charge = scan.nextLine();
                                                    if (charge.toLowerCase().equals("y")) {
                                                        is_cancel = true;
                                                        break;
                                                    } else if (charge.toLowerCase().equals("n")) {
                                                        break;
                                                    } else {
                                                        continue;
                                                    }
                                                } else {
                                                    Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Please select 'cr' (card) or 'cc' (cancel)...\n" + color.reset);
                                                }
                                            }
                                            if (is_cancel) {
                                               Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "] " + color.reset + byebye_msg() + " \n" + color.reset);
                                                System.exit(0);
                                            }
                                        } else {
                                            Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Could you please select y or n...\n" + color.reset);
                                        }
                                    }

                                }
                            } catch (NumberFormatException mf) {
                                Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.red + " It looks like our system experienced an unexpected error while processing '" + input_money + "'..." + color.reset);
                                sleep(2);
                                break;
                            }
                        } else {
                            Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Please enter a amount of money for payment...\n" + color.reset);
                        }
                    }
                } else if (selectotal_meatthod.equals("2")) {
                    clear();
                    System.out.println(cashier_lay);
                    payment_card(receipt_layout, 10000, total_cost, cashier_lay,color);
                } else {
                    Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Please select a payment method...\n" + color.reset);
                    sleep(1);
                }
            }
        System.exit(0);
    }




    public static void Main_Menu(Boolean color_off) {

        int total_fruits = 0;
        int total_bakery = 0;
        int total_vegies = 0;
        int total_dairy  = 0;
        int total_meat   = 0;
        int total_others = 0;
        String fruit_total_indicator  = "0    ";
        String bakery_total_indicator = "0    ";
        String vegies_total_indicator = "0    ";
        String dairy_total_indicator  = "0    ";
        String meat_total_indicator   = "0    ";
        String others_total_indicator = "0    ";
        String cart_total_indicator   = "0     ";

        // store items in cart_items.
        String cart_items = "";


        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(currentDate);


        int count_cart_item = 0;
        while(true) {
            Color color = colorSwitch(color_off);
            clear();
            Scanner scanner = new Scanner(System.in);

            String main_layout = "\n" + color.reset +
                color.cyan + "   ┌─────────────────────────────────────┐" + color.reset + "\n" +
                color.cyan + "   │ " + color.yellow + "Title      " + color.red + ":" + color.green + "  Mini Grocery Store    " + color.cyan + "│" + color.reset + "\n" +
                color.cyan + "   │ " + color.yellow + "Date       " + color.red + ":" + color.green + "  " + formattedDate +"            " + color.cyan + "│" + color.reset + "\n" +
                color.cyan + "   │ " + color.yellow + "Developer  " + color.red + ":" + color.green + "  Juster M. Ube         " + color.cyan + "│" + color.reset + "\n" +
                color.cyan + "   │ " + color.yellow + "Section    " + color.red + ":" + color.green + "  BSIT-NA               " + color.cyan + "│" + color.reset + "\n" +
                color.cyan + "   ├─────────────────────────────────────┤" + color.reset + "\n" +
                color.border_color + "  ╔╩═════════════════════╦═══════════════╩╗" + color.reset + "\n" +
                color.border_color + "  ║" + color.cyan + "  Grocery Categories" + color.border_color + "  ║" + color.cyan + " Items on Cart" + color.border_color + "  ║" + color.reset + "\n" +
                color.border_color + "  ╠══════════════════════╬════════════════╣" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 1." + color.white+ " Fruits   " + color.red + "> " + color.reset + "(" + color.green + "7" + color.reset + ")" + color.border_color + " ║ " + color.white+ "Fruits " + color.purple + "-> " + color.green + fruit_total_indicator + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ║       " + color.white+ "Seedless " + color.red + "> " + color.reset + "(" + color.green + "3" + color.reset + ")" + color.border_color + " ║                ║" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 2. " + color.white+ "Bakery   " + color.red + "> " + color.reset + "(" + color.green + "5" + color.reset + ")" + color.border_color + " ║ " + color.white+ "Bakery " + color.purple + "-> " + color.green + bakery_total_indicator + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 3. " + color.white+ "Vegies   " + color.red + "> " + color.reset + "(" + color.green + "6" + color.reset + ")" + color.border_color + " ║ " + color.white+ "Vegies " + color.purple + "-> " + color.green + vegies_total_indicator + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 4. " + color.white+ "Dairy    " + color.red + "> " + color.reset + "(" + color.green + "5" + color.reset + ")" + color.border_color + " ║ " + color.white+ "Dairy  " + color.purple + "-> " + color.green + dairy_total_indicator + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 5. " + color.white+ "Meat     " + color.red + "> " + color.reset + "(" + color.green + "5" + color.reset + ")" + color.border_color + color.border_color + " ║ " + color.white+ "Meat   " + color.purple + "-> " + color.green + meat_total_indicator + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 6. " + color.white+ "Others   " + color.red + "> " + color.reset + "(" + color.green + "6" + color.reset + ")" + color.border_color + " ║ " + color.white+ "Others " + color.purple + "-> " + color.green + others_total_indicator + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ║                      ║                " + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ║──────────────────────║────────────────" + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.red + " 0. " + color.white+ "Exit.          " + color.border_color + "║ " + color.white+ "Total items in " + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " s. " + color.white+ "Show items     " + color.border_color + "║ " + color.white+ "cart" + color.red + ": " + color.green + cart_total_indicator + color.border_color + "   ║" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " g. " + color.white+ "Go to counter  " + color.border_color + "║" + color.border_color + "                ║" + color.reset + "\n" +
                color.border_color + "  ║──────────────────────║────────────────║" + color.reset + "\n" +
                color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " c. " + color.white+ "on/off colors" + color.border_color + "  ║ " + color.white+ "Status" + color.red + ": " + color.status + color.border_color + "║" + color.reset + "\n" +
                color.border_color + "  ╠══════════════════════╩════════════════╝" + color.reset + "\n" +
                color.border_color + "  ║" + color.reset;
            System.out.println(main_layout);
            System.out.print(color.border_color + "  ╚═[" + color.green + "Select" + color.border_color + "]─ " + color.green);
            String select = scanner.nextLine();

            if (select.equals("1")) {

                while (true) {
                    clear();
                    String fruits_layout = "\n" + color.reset +
                        color.cyan + "   ┌─────────────────────────────────────┐" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Title      " + color.red + ":" + color.green + "  Mini Grocery Store    " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Date       " + color.red + ":" + color.green + "  " + formattedDate +"            " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Developer  " + color.red + ":" + color.green + "  Juster M. Ube         " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Section    " + color.red + ":" + color.green + "  BSIT-NA               " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   ├─────────────────────────────────────┤" + color.reset + "\n" +
                        color.border_color + "  ╔╩═════════════════════╦═══════════════╩╗" + color.reset + "\n" +
                        color.border_color + "  ║ " + color.cyan + "   Category:" + color.green + " Fruits " + color.border_color + " ║" + color.cyan + "   Item Price  " + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ╠══════════════════════╬════════════════╣\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 1. " + color.white+ "Pineapple      " + color.border_color + "║ " + color.green + "₱30" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 2. " + color.white+ "Melon (SL.)    " + color.border_color + "║ " + color.green + "₱60" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 3. " + color.white+ "Banana         " + color.border_color + "║ " + color.green + "₱25" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 4. " + color.white+ "Orange (SL.)   " + color.border_color + "║ " + color.green + "₱30" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 5. " + color.white+ "Grapes (SL.)   " + color.border_color + "║ " + color.green + "₱300" + color.yellow + " pr. wrap." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 6. " + color.white+ "Apple          " + color.border_color + "║ " + color.green + "₱20" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 7. " + color.white+ "Mango          " + color.border_color + "║ " + color.green + "₱15" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║──────────────────────║────────────────║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.red + " 0. " + color.white+ "Back to CATG.  " + color.border_color + "║ " + color.white+ "Total items in " + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " s. " + color.white+ "Show items     " + color.border_color + "║ " + color.white+ "cart" + color.red + ": " + color.green + cart_total_indicator + color.border_color + "   ║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " g. " + color.white+ "Go to counter  " + color.border_color + "║" + color.border_color + "                ║" + color.reset + "\n" +
                        color.border_color + "  ║──────────────────────║────────────────║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " c. " + color.white+ "on/off colors" + color.border_color + "  ║ " + color.white+ "Status" + color.red + ": " + color.status + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ╠══════════════════════╩════════════════╝" + color.reset + "\n" +
                        color.border_color + "  ║" + color.reset;
                    System.out.println(fruits_layout);
                    System.out.print(color.border_color + "  ╚═[" + color.green + "Select" + color.border_color + "]─ " + color.green);
                    String select_item = scanner.next();

                    if (select_item.equals("0")) {
                        break;
                    } else if (select_item.equals("s")) {
                        Display_CartItems(cart_items,color);
                        sleep(1);
                    } else if (select_item.equals("g")) {
                        counter(cart_items,color);
                    } else if (select_item.equals("c")) {
                        color_off = !color_off;
                        color = colorSwitch(color_off);
                        sleep(1);
                    } else {
                        String item_data = get_price(1, select_item);
                        String[] item_data_arr = item_data.split("\\|");
                        String price = item_data_arr[0];
                        String name = item_data_arr[1];
                        if (!price.equals("null")) {
                            cart_items += item_data + ",";
                            total_fruits += 1;
                            if (total_fruits >= 10) {
                                fruit_total_indicator = total_fruits + "   ";
                            } else if (total_fruits >= 100) {
                                fruit_total_indicator = total_fruits + "   ";
                            } else {
                                fruit_total_indicator = total_fruits + "    ";
                            }
                            count_cart_item += 1;
                            if (count_cart_item >= 10) {

                                cart_total_indicator = count_cart_item + "    ";
                            } else if (count_cart_item >= 100) {
                                cart_total_indicator = count_cart_item + "    ";
                            } else {
                                cart_total_indicator = count_cart_item + "     ";
                            }
                            System.out.println("  " + color.white+ "[" + color.green + "+" + color.white+ "]" + color.reset + " The '" + color.green + name + color.reset + "' is added to cart." + color.reset);
                            sleep(1);
                        } else {
                            Info("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.yellow + " Sorry but that item is not available.\n" + color.reset);
                            sleep(2);
                        }
                    }
                }

            } else if (select.equals("2")) {

                while (true) {
                    clear();
                    String bakery_layout = "\n" +
                        color.cyan + "   ┌─────────────────────────────────────┐" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Title      " + color.red + ":" + color.green + "  Mini Grocery Store    " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Date       " + color.red + ":" + color.green + "  " + formattedDate +"            " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Developer  " + color.red + ":" + color.green + "  Juster M. Ube         " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Section    " + color.red + ":" + color.green + "  BSIT-NA               " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   ├─────────────────────────────────────┤" + color.reset + "\n" +
                        color.border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + color.reset +
                        color.border_color + "  ║" + color.cyan + "   Category:" + color.green + " Bakery   " + color.border_color + "║" + color.cyan + "   Item Price   " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ╠══════════════════════╬════════════════╣\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 1. " + color.white+ "Cupcake.       " + color.border_color + "║" + color.green + " ₱20" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 2. " + color.white+ "Cookies.       " + color.border_color + "║" + color.green + " ₱20" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 3. " + color.white+ "Donuts.        " + color.border_color + "║" + color.green + " ₱30" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 4. " + color.white+ "Bread.         " + color.border_color + "║" + color.green + " ₱30" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 5. " + color.white+ "Cake.          " + color.border_color + "║" + color.green + " ₱90" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 6. " + color.white+ "Pie.           " + color.border_color + "║" + color.green + " ₱80" + color.yellow + " pr. piece." + color.border_color + " ║\n" + color.reset +
                        color.border_color + "  ║                      ║                ║\n" + color.reset +
                        color.border_color + "  ║──────────────────────║────────────────║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.red + " 0. " + color.white+ "Back to CATG.  " + color.border_color + "║ " + color.white+ "Total items in " + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " s. " + color.white+ "Show items     " + color.border_color + "║ " + color.white+ "cart" + color.red + ": " + color.green + cart_total_indicator + color.border_color + "   ║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " g. " + color.white+ "Go to counter  " + color.border_color + "║" + color.border_color + "                ║" + color.reset + "\n" +
                        color.border_color + "  ║──────────────────────║────────────────║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " c. " + color.white+ "on/off colors" + color.border_color + "  ║ " + color.white+ "Status" + color.red + ": " + color.status + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ╠══════════════════════╩════════════════╝" + color.reset + "\n" +
                        color.border_color + "  ║" + color.reset;
                    System.out.println(bakery_layout);
                    System.out.print(color.border_color + "  ╚═[" + color.green + "Select" + color.border_color + "]─ " + color.green);
                    String select_item = scanner.next();

                    if (select_item.equals("0")) {
                        break;
                    } else if (select_item.equals("s")) {
                        Display_CartItems(cart_items,color);
                        sleep(1);
                    } else if (select_item.equals("g")) {
                        counter(cart_items,color);
                    } else if (select_item.equals("c")) {
                        color_off = !color_off;
                        color = colorSwitch(color_off);
                        sleep(1);
                    } else {
                        String item_data = get_price(2, select_item);
                        String[] item_data_arr = item_data.split("\\|");
                        String price = item_data_arr[0];
                        String name = item_data_arr[1];
                        if (!price.equals("null")) {
                            cart_items += item_data + ",";
                            total_bakery += 1;
                            if (total_bakery >= 10) {
                                bakery_total_indicator = total_bakery + "   ";
                            } else if (total_bakery >= 100) {
                                bakery_total_indicator = total_bakery + "   ";
                            } else {
                                bakery_total_indicator = total_bakery + "    ";
                            }
                            count_cart_item += 1;
                            if (count_cart_item >= 10) {

                                cart_total_indicator = count_cart_item + "    ";
                            } else if (count_cart_item >= 100) {
                                cart_total_indicator = count_cart_item + "    ";
                            } else {
                                cart_total_indicator = count_cart_item + "     ";
                            }
                            System.out.println("  " + color.white+ "[" + color.green + "+" + color.white+ "]" + color.reset + " The '" + color.green + name + color.reset + "' is added to cart." + color.reset);
                            sleep(1);
                        } else {
                            Info("  " + color.white+ "[" + color.yellow + "!" + color.white+ "]" + color.yellow + " Sorry but that item is not available.\n" + color.reset);
                            sleep(3);
                        }
                    }
                }

            } else if (select.equals("3")) {

                while (true) {
                    clear();
                    String vegies_layout = "\n" +
                        color.cyan + "   ┌─────────────────────────────────────┐" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Title      " + color.red + ":" + color.green + "  Mini Grocery Store    " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Date       " + color.red + ":" + color.green + "  " + formattedDate +"            " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Developer  " + color.red + ":" + color.green + "  Juster M. Ube         " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Section    " + color.red + ":" + color.green + "  BSIT-NA               " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   ├─────────────────────────────────────┤" + color.reset + "\n" +
                        color.border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + color.reset +
                        color.border_color + "  ║" + color.cyan + "    Category: " + color.green + "Vegies  " + color.border_color + "║" + color.cyan + "   Item Price   " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ╠══════════════════════╬════════════════╣\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 1. " + color.white+ "Cucumber.      " + color.border_color + "║ " + color.green + "₱10 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 2. " + color.white+ "Lettuce.       " + color.border_color + "║ " + color.green + "₱30 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 3. " + color.white+ "Tomato.        " + color.border_color + "║ " + color.green + "₱50 " + color.yellow + "pr. wrap.  " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 4. " + color.white+ "Potato.        " + color.border_color + "║ " + color.green + "₱25 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 5. " + color.white+ "Onion.         " + color.border_color + "║ " + color.green + "₱20 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 6. " + color.white+ "Cabbage.       " + color.border_color + "║ " + color.green + "₱30 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║                      ║                ║\n" + color.reset +
                        color.border_color + "  ║──────────────────────║────────────────║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.red + " 0. " + color.white+ "Back to CATG.  " + color.border_color + "║ " + color.white+ "Total items in " + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " s. " + color.white+ "Show items     " + color.border_color + "║ " + color.white+ "cart" + color.red + ": " + color.green + cart_total_indicator + color.border_color + "   ║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " g. " + color.white+ "Go to counter  " + color.border_color + "║" + color.border_color + "                ║" + color.reset + "\n" +
                        color.border_color + "  ║──────────────────────║────────────────║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+""+color.cyan+"--" + color.red + ">" + color.green + " c. " + color.white+ "on/off colors" + color.border_color + "  ║ " + color.white+ "Status" + color.red + ": " + color.status + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ╠══════════════════════╩════════════════╝" + color.reset + "\n" +
                        color.border_color + "  ║" + color.reset;
                    System.out.println(vegies_layout);
                    System.out.print(color.border_color + "  ╚═[" + color.green + "Select" + color.border_color + "]─ " + color.green);
                    String select_item = scanner.next();

                    if (select_item.equals("0")) {
                        break;
                    } else if (select_item.equals("s")) {
                        Display_CartItems(cart_items,color);
                        sleep(1);
                    } else if (select_item.equals("g")) {
                        counter(cart_items,color);
                    } else if (select_item.equals("c")) {
                        color_off = !color_off;
                        color = colorSwitch(color_off);
                        sleep(1);
                    } else {

                        String item_data = get_price(3, select_item);
                        String[] item_data_arr = item_data.split("\\|");
                        String price = item_data_arr[0];
                        String name = item_data_arr[1];
                        if (!price.equals("null")) {

                            cart_items += item_data + ",";
                            total_vegies += 1;
                            if (total_vegies >= 10) {
                                vegies_total_indicator = total_vegies + "   ";
                            } else if (total_vegies >= 100) {
                                vegies_total_indicator = total_vegies + "   ";
                            } else {
                                vegies_total_indicator = total_vegies + "    ";
                            }

                            count_cart_item += 1;
                            if (count_cart_item >= 10) {

                                cart_total_indicator = count_cart_item + "    ";
                            } else if (count_cart_item >= 100) {
                                cart_total_indicator = count_cart_item + "    ";
                            } else {
                                cart_total_indicator = count_cart_item + "     ";
                            }

                            System.out.println("  " + color.white+ "[" + color.green + "+" + color.white+ "]" + color.reset + " The '" + color.green + name + color.reset + "' is added to cart." + color.reset);
                            sleep(1);
                        } else {
                            Info("  " + color.white+ "[" + color.yellow + "!" + color.white+ "]" + color.yellow + " Sorry but that item is not available.\n" + color.reset);
                            sleep(3);
                        }
                    }
                }

            } else if (select.equals("4")) {

                while (true) {
                    clear();
                    String dairy_layout = "\n" +
                        color.cyan + "   ┌─────────────────────────────────────┐" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Title      " + color.red + ":" + color.green + "  Mini Grocery Store    " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Date       " + color.red + ":" + color.green + "  " + formattedDate +"            " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Developer  " + color.red + ":" + color.green + "  Juster M. Ube         " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Section    " + color.red + ":" + color.green + "  BSIT-NA               " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   ├─────────────────────────────────────┤" + color.reset + "\n" +
                        color.border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + color.reset +
                        color.border_color + "  ║" + color.cyan + "    Category:" + color.green + " Dairy   " + color.border_color + "║" + color.cyan + "   Item Price   " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ╠══════════════════════╬════════════════╣\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 1. " + color.white+ "Cheese.        " + color.border_color + "║ " + color.green + "₱45 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 2. " + color.white+ "Butter.        " + color.border_color + "║ " + color.green + "₱30 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 3. " + color.white+ "Yogurt.        " + color.border_color + "║ " + color.green + "₱20 " + color.yellow + "pr. wrap.  " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 4. " + color.white+ "Cream.         " + color.border_color + "║ " + color.green + "₱40 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 5. " + color.white+ "Milk.          " + color.border_color + "║ " + color.green + "₱60 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 6. " + color.white+ "Egg.           " + color.border_color + "║ " + color.green + "₱20 " + color.yellow + "pr. piece. " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║                      ║                ║\n" + color.reset +
                        color.border_color + "  ║──────────────────────║────────────────║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.red + " 0. " + color.white+ "Back to CATG.  " + color.border_color + "║ " + color.white+ "Total items in " + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " s. " + color.white+ "Show items     " + color.border_color + "║ " + color.white+ "cart" + color.red + ": " + color.green + cart_total_indicator + color.border_color + "   ║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " g. " + color.white+ "Go to counter  " + color.border_color + "║" + color.border_color + "                ║" + color.reset + "\n" +
                        color.border_color + "  ║──────────────────────║────────────────║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " c. " + color.white+ "on/off colors" + color.border_color + "  ║ " + color.white+ "Status" + color.red + ": " + color.status + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ╠══════════════════════╩════════════════╝" + color.reset + "\n" +
                        color.border_color + "  ║" + color.reset;
                    System.out.println(dairy_layout);
                    System.out.print(color.border_color + "  ╚═[" + color.green + "Select" + color.border_color + "]─ " + color.green);
                    String select_item = scanner.next();

                    if (select_item.equals("0")) {
                        break;
                    } else if (select_item.equals("s")) {
                        Display_CartItems(cart_items,color);
                        sleep(1);
                    } else if (select_item.equals("g")) {
                        counter(cart_items,color);
                    } else if (select_item.equals("c")) {
                        color_off = !color_off;
                        color = colorSwitch(color_off);
                        sleep(1);
                    } else {
                        String item_data = get_price(4, select_item);
                        String[] item_data_arr = item_data.split("\\|");
                        String price = item_data_arr[0];
                        String name = item_data_arr[1];
                        if (!price.equals("null")) {
                            cart_items += item_data + ",";
                            total_dairy += 1;
                            if (total_dairy >= 10) {
                                dairy_total_indicator = total_dairy + "   ";
                            } else if (total_dairy >= 100) {
                                dairy_total_indicator = total_dairy + "   ";
                            } else {
                                dairy_total_indicator = total_dairy + "    ";
                            }
                            count_cart_item += 1;
                            if (count_cart_item >= 10) {

                                cart_total_indicator = count_cart_item + "    ";
                            } else if (count_cart_item >= 100) {
                                cart_total_indicator = count_cart_item + "    ";
                            } else {
                                cart_total_indicator = count_cart_item + "     ";
                            }
                            System.out.println("  " + color.white+ "[" + color.green + "+" + color.white+ "]" + color.reset + " The '" + color.green + name + color.reset + "' is added to cart. ");
                            sleep(1);
                        } else {
                            Info("  " + color.white+ "[" + color.yellow + "!" + color.white+ "]" + color.yellow + " Sorry but that item is not available.\n" + color.reset);
                            sleep(3);
                        }
                    }
                }



            } else if (select.equals("5")) {

                while (true) {
                    clear();
                    String meat_layout = "\n" +
                        color.cyan + "   ┌─────────────────────────────────────┐" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Title      " + color.red + ":" + color.green + "  Mini Grocery Store    " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Date       " + color.red + ":" + color.green + "  " + formattedDate +"            " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Developer  " + color.red + ":" + color.green + "  Juster M. Ube         " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Section    " + color.red + ":" + color.green + "  BSIT-NA               " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   ├─────────────────────────────────────┤" + color.reset + "\n" +
                        color.border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + color.reset +
                        color.border_color + "  ║" + color.cyan + "    Category: " + color.green + "Meat    " + color.border_color + "║" + color.cyan + "   Item Price   " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ╠══════════════════════╬════════════════╣\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 1. " + color.white+ "Chicken.       " + color.border_color + "" + color.border_color + "║" + color.green + " ₱200" + color.yellow + " 1kg.      " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 2. " + color.white+ "Bacon.         " + color.border_color + "║" + color.green + " ₱140" + color.yellow + " pack      " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 3. " + color.white+ "Pork.          " + color.border_color + "║" + color.green + " ₱250" + color.yellow + " 1kg       " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 4. " + color.white+ "Beef.          " + color.border_color + "║" + color.green + " ₱250" + color.yellow + " 1kg       " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 5. " + color.white+ "Duck.          " + color.border_color + "║" + color.green + " ₱230" + color.yellow + "" + color.yellow + " 1kg       " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 6. " + color.white+ "Ham.           " + color.border_color + "║" + color.green + " ₱120" + color.yellow + " pack      " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║                      ║                ║\n" + color.reset +
                        color.border_color + "  ║──────────────────────║────────────────║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.red + " 0. " + color.white+ "Back to CATG.  " + color.border_color + "║ " + color.white+ "Total items in " + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " s. " + color.white+ "Show items     " + color.border_color + "║ " + color.white+ "cart" + color.red + ": " + color.green + cart_total_indicator + color.border_color + "   ║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " g. " + color.white+ "Go to counter  " + color.border_color + "║" + color.border_color + "                ║" + color.reset + "\n" +
                        color.border_color + "  ║──────────────────────║────────────────║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " c. " + color.white+ "on/off colors" + color.border_color + "  ║ " + color.white+ "Status" + color.red + ": " + color.status + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ╠══════════════════════╩════════════════╝" + color.reset + "\n" +
                        color.border_color + "  ║" + color.reset;
                    System.out.println(meat_layout);
                    System.out.print(color.border_color + "  ╚═[" + color.green + "Select" + color.border_color + "]─ " + color.green);
                    String select_item = scanner.next();

                    if (select_item.equals("0")) {
                        break;
                    } else if (select_item.equals("s")) {
                        Display_CartItems(cart_items,color);
                        sleep(1);
                    } else if (select_item.equals("g")) {
                        counter(cart_items,color);
                    } else if (select_item.equals("c")) {
                        color_off = !color_off;
                        color = colorSwitch(color_off);
                        sleep(1);
                    } else {
                        String item_data = get_price(5, select_item);
                        String[] item_data_arr = item_data.split("\\|");
                        String price = item_data_arr[0];
                        String name = item_data_arr[1];
                        if (!price.equals("null")) {
                            cart_items += item_data + ",";
                            total_meat += 1;
                            if (total_meat >= 10) {
                                meat_total_indicator = total_meat + "   ";
                            } else if (total_meat >= 100) {
                                meat_total_indicator = total_meat + "   ";
                            } else {
                                meat_total_indicator = total_meat + "    ";
                            }
                            count_cart_item += 1;
                            if (count_cart_item >= 10) {

                                cart_total_indicator = count_cart_item + "    ";
                            } else if (count_cart_item >= 100) {
                                cart_total_indicator = count_cart_item + "    ";
                            } else {
                                cart_total_indicator = count_cart_item + "     ";
                            }
                            System.out.println("  " + color.white+ "[" + color.green + "+" + color.white+ "]" + color.reset + " The '" + color.green + name + color.reset + "' is added to cart." + color.reset);
                            sleep(1);
                        } else {
                            Info("  " + color.white+ "[" + color.yellow + "!" + color.white+ "]" + color.yellow + " Sorry but that item is not available.\n" + color.reset);
                            sleep(3);
                        }
                    }

                }

                Main_Menu(color_off);

            } else if (select.equals("6")) {

                while (true) {
                    clear();
                    String meat_layout = "\n" + color.reset +
                        color.cyan + "   ┌─────────────────────────────────────┐" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Title      " + color.red + ":" + color.green + "  Mini Grocery Store    " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Date       " + color.red + ":" + color.green + "  " + formattedDate +"            " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Developer  " + color.red + ":" + color.green + "  Juster M. Ube         " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   │ " + color.yellow + "Section    " + color.red + ":" + color.green + "  BSIT-NA               " + color.cyan + "│" + color.reset + "\n" +
                        color.cyan + "   ├─────────────────────────────────────┤" + color.reset + "\n" +
                        color.border_color + "  ╔╩═════════════════════╦═══════════════╩╗\n" + color.reset +
                        color.border_color + "  ║ " + color.cyan + "Category:" + color.green + " Others  " + color.border_color + "   ║" + color.green + " Item Price     " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ╠══════════════════════╬════════════════╣\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 1. " + color.white+ "Coffee.        " + color.border_color + "║ " + color.green + "₱30 " + color.yellow + "bottle     " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 2. " + color.white+ "Tea.           " + color.border_color + "║ " + color.green + "₱30 " + color.yellow + "bottle     " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 3. " + color.white+ "Soda.          " + color.border_color + "║ " + color.green + "₱20 " + color.yellow + "bottle     " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 4. " + color.white+ "Ketchup.       " + color.border_color + "║ " + color.green + "₱20 " + color.yellow + "pouch      " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 5. " + color.white+ "Pepper.        " + color.border_color + "║ " + color.green + "₱13 " + color.yellow + "pouch      " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 6. " + color.white+ "Salt.          " + color.border_color + "║ " + color.green + "₱25 " + color.yellow + "1kg        " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 7. " + color.white+ "Oregano.       " + color.border_color + "║ " + color.green + "₱15 " + color.yellow + "pack       " + color.border_color + "" + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 8. " + color.white+ "Ice cream.     " + color.border_color + "║ " + color.green + "₱80 " + color.yellow + "box        " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 9. " + color.white+ "Noodles.       " + color.border_color + "║ " + color.green + "₱23 " + color.yellow + "pack       " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 10. " + color.white+ "Lolipop.      " + color.border_color + "║ " + color.green + "₱70 " + color.yellow + "pack       " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 11. " + color.white+ "Vinegar.      " + color.border_color + "║ " + color.green + "₱15 " + color.yellow + "pouch      " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 12. " + color.white+ "Water.        " + color.border_color + "║ " + color.green + "₱15 " + color.yellow + "bottle     " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 13. " + color.white+ "Pasta.        " + color.border_color + "║ " + color.green + "₱45 " + color.yellow + "pack       " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 14. " + color.white+ "Sardines.     " + color.border_color + "║ " + color.green + "₱23 " + color.yellow + "canned     " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " 15. " + color.white+ "Popcorn.      " + color.border_color + "║ " + color.green + "₱74 " + color.yellow + "pack       " + color.border_color + "║\n" + color.reset +
                        color.border_color + "  ║                      ║                ║\n" + color.reset +
                        color.border_color + "  ║──────────────────────║────────────────║\n" + color.reset +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.red + " 0. " + color.white+ "Back to CATG.  " + color.border_color + "║ " + color.white+ "Total items in " + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " s. " + color.white+ "Show items     " + color.border_color + "║ " + color.white+ "cart" + color.red + ": " + color.green + cart_total_indicator + color.border_color + "   ║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " g. " + color.white+ "Go to counter  " + color.border_color + "║" + color.border_color + "                ║" + color.reset + "\n" +
                        color.border_color + "  ║──────────────────────║────────────────║" + color.reset + "\n" +
                        color.border_color + "  ║"+color.cyan+"--" + color.red + ">" + color.green + " c. " + color.white+ "on/off colors" + color.border_color + "  ║ " + color.white+ "Status" + color.red + ": " + color.status + color.border_color + "║" + color.reset + "\n" +
                        color.border_color + "  ╠══════════════════════╩════════════════╝" + color.reset + "\n" +
                        color.border_color + "  ║" + color.reset;
                    System.out.println(meat_layout);
                    System.out.print(color.border_color + "  ╚═[" + color.green + "Select" + color.border_color + "]─ " + color.green);
                    String select_item = scanner.next();

                    if (select_item.equals("0")) {
                        break;
                    } else if (select_item.equals("s")) {
                        Display_CartItems(cart_items,color);
                        sleep(1);
                    } else if (select_item.equals("g")) {
                        counter(cart_items,color);
                    } else if (select_item.equals("c")) {
                        color_off = !color_off;
                        color = colorSwitch(color_off);
                        sleep(1);

                    } else {
                        String item_data = get_price(6, select_item);
                        String[] item_data_arr = item_data.split("\\|");
                        String price = item_data_arr[0];
                        String name = item_data_arr[1];
                        if (!price.equals("null")) {
                            cart_items += item_data + ",";
                            total_others += 1;
                            if (total_others >= 10) {
                                others_total_indicator = total_others + "   ";
                            } else if (total_bakery >= 100) {
                                others_total_indicator = total_others + "   ";
                            } else {
                                others_total_indicator = total_others + "    ";
                            }
                            count_cart_item += 1;
                            if (count_cart_item >= 10) {
                                cart_total_indicator = count_cart_item + "    ";
                            } else if (count_cart_item >= 100) {
                                cart_total_indicator = count_cart_item + "    ";
                            } else {
                                cart_total_indicator = count_cart_item + "     ";
                            }
                            System.out.println("  " + color.white+ "[" + color.green + "+" + color.white+ "]" + color.reset + " The '" + color.green + name + color.reset + "' is added to cart." + color.reset);
                            sleep(1);
                        } else {
                            Info("  " + color.white+ "[" + color.yellow + "!" + color.white+ "]" + color.yellow + " Sorry but that item is not available.\n" + color.reset);
                            sleep(3);
                        }

                    }
                }


            } else if (select.equals("0")) {
                if (count_cart_item > 0) {
                    while (true) {
                        System.out.println("  " + color.white+ "[" + color.red + "!" + color.white+ "]" + color.red + " Your cart is not empty." + color.reset);
                        System.out.print("  " + color.white+ "[" + color.green + "?" + color.white+ "]" + color.reset + " Still go exit? (y/N): " + color.green);
                        String ext = scanner.next();

                        if (ext.toLowerCase().equals("y")) {
                            break;
                        } else {
                            break;
                        }
                    }

                }

                Info("  " + color.white+ "[" + color.green + "+" + color.white+ "] " + color.reset + byebye_msg() +" \n" + color.reset);
                scanner.close();
                System.exit(0);
            } else if (select.equals("g")) {
                counter(cart_items,color);

            } else if (select.equals("s")) {
                if (cart_items.equals("")) {
                    Info("  " + color.white+ "[" + color.blue + "*" + color.white+ "]" + color.green + " Ow, It looks like your cart is empty...\n" + color.reset);
                } else {
                    Display_CartItems(cart_items,color);
                }
                sleep(2);

            } else if (select.equals("c")) {
                color_off = !color_off;
                color = colorSwitch(color_off);
                sleep(1);

            } else {
                Info("  " + color.white+ "[" + color.yellow + "!" + color.white+ "]" + color.yellow + " Sorry but that category is not available.\n" + color.reset);
                sleep(3);
            }
        }
    }



    public static void loading_main() {
        int num_loop = 10;
        for (int x = 0;x < num_loop;x++) {
            String load;

            switch (x % 4) {
                case 0:
                    load = "|";
                    break;
                case 1:
                    load = "/";
                    break;
                case 2:
                    load = "-";
                    break;
                case 3:
                    load = "\\";
                    break;
                default:
                    load = " ";
            }

            System.out.print("\r  [*] Loading, Please wait..." + load);
            sleep(4101);
        }
    }



    public static void main(String[] args) {
        loading_main();
        clear();
        Boolean color_off = true;

        Scanner scan = new Scanner(System.in);
        String[] greetings = {
            "Welcome to our grocery store!",
            "Good day! Enjoy your time in our store.",
            "Greetings! Find everything you need today.",
            "Welcome back! We're glad to see you again.",
            "Namaste! Welcome to our grocery store.",
        };

        Random random = new Random();
        int index = random.nextInt(greetings.length);
        System.out.print("\r  [-] ");
        Info(greetings[index]+"\n");
        while (true) {
            System.out.print("  [?] Enable color mode (Y/n): ");
            String select = scan.next();

            if (select.toLowerCase().equals("y")) {
                color_off = false;
                break;

            } else if (select.toLowerCase().equals("n")) {
                 break;

            } else {
                Info("  [!] Please select only 'y' if yes and 'n' if no.\n");
            }
        }
        Instruction_usage(color_off);
        Main_Menu(color_off);
    }


}
