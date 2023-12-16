public class numThree {

	public static void main(String[] args) {

		int[] data = {39,23,16,52,64,73,45,1,3,4,21};
		int[] sort_data = sort_format_data(data);

		System.out.print("[*] Given list of data: "+sort_data.toString());
		for (int x =0;x<sort_data.length;x++) {
			System.out.print(sort_data[x]+", ");
		}

		System.out.println();
		System.out.println();
		
//		int total_sum = total_data(sort_data);
//		double average = calc_average(sort_data);

		int highest_value = sort_data[sort_data.length-1];
		int secound_highest_value = sort_data[sort_data.length-2];

		System.out.println("[*] Second largest element   :  "+secound_highest_value);
		System.out.println("[*] Greatest average element :  "+highest_value);

	}

	public static int[] sort_format_data(int[] data) {
		int[] tmpdata =  new int[data.length];
		for (int i = 0; i < data.length; i++) {  
			for (int j = i + 1; j < data.length; j++) {  
				int tmp = 0;  
				if (data[i] > data[j]){  
					tmp = data[i];  
					data[i] = data[j];  
					data[j] = tmp;  
				}  
			}  
		tmpdata[i] = data[i];
		}

		return tmpdata;
	}


	public static double calc_average(int[] data) {
		int ages_sum = 0;
		for (int x = 0;x<data.length;x++) {
		    ages_sum += data[x];
		}

		double get_average = ages_sum / data.length;
		System.out.println("[*] Total count of data      :  "+data.length);
		System.out.println("[*] Total sum of data        :  "+ages_sum);
		System.out.println("[*] Average of the data      :  "+get_average);

		return get_average;
	}


	public static int total_data(int[] data) {
		int sum = 0;
		for (int x = 0; x< data.length;x++) {
			sum += data[x];
		}
		return sum;
	}
}

