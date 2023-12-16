public class numThree {
	public static void main(String[] args) {
		String myword = "abc";
		int word_length = myword.length();
		int total_combo = (int) Math.pow(word_length, word_length);
		String word = "";

		for (int x=0;x < total_combo;x++) {
			int i = x;
			for (int c=0;c < word_length;c++) {
				word += myword.charAt(i % myword.length());
				i = x / myword.length();
			}
			System.out.println(word);
			word = "";
		}

	}
}

