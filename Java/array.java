import java.util.ArrayList;

public class array {
    public static void main(String[] args) {
        ArrayList<String> hello = new ArrayList<String>();
		for (int x=0; x<=10;x++) {
			hello.add("Count: "+x);
		}
        System.out.print(hello.size());
    }
}
