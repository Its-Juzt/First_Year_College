import java.util.ArrayList;
import java.util.Arrays;
public class foreachloop {
    public static void main(String[] args) {
        // int hello[] 
        String hello[] = {"juster","mango","ube"};

        for (int x = 0;x<hello.length;x++) {
            System.out.println(hello[x]);
        }
        ArrayList<String> mylist = new ArrayList<String>();

        mylist.add("1234");
        mylist.add("123");
        mylist.remove("123");
        System.out.println(mylist);
        System.out.println(Arrays.toString(hello));
    }
}
