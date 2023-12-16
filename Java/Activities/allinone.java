public class allinone {
    public static void main(String[] args) {
        int[] data = {1,2,7,23,12,25,14};
        int[] sorted_data = sort_data(data);
        System.out.println("[*] Gathered data: "+sorted_data.toString());

        int highest = sorted_data[sorted_data.length-1];
        int second = sorted_data[sorted_data.length-2];
    
        System.out.println("[*] Second largest element: "+second);
        System.out.println("[*] Greatest average element: "+highest);


    }
    
    public static void calc_ave(int[] data) {
        int sum = get_total(data);
        double average = sum / data.length;
        System.out.println("[*] Total elements of data: "+data.length);
        System.out.println("[*] Total sum of data elements: "+sum);
        System.out.println("[*] Average of the data: "+sum);

    }

    public static int get_total(int[] data) {
        int sum = 0;
        for(int i = 0;i<data.length;i++) {
            sum += data[i];
        }
        return sum;

    }

    public static int[] sort_data(int[] data) {
        int[] tmpdata = data;
        for (int i = 0;i<data.length;i++) {
            for (int x = i+1;x<data.length;i++) {
                int tmp = 0;
                if (data[i] > data[x]) {
                    tmp = data[i];
                    data[i] = data[x];
                    data[x] = tmp;
                }
            }
        tmpdata[i] = data[i];
        }
        return tmpdata;
     }
}
