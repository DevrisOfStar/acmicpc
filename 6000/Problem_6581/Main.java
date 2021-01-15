package Problem_6581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final String br_text = "<br>";
	static final String br_value = "\n";
	static final String hr_text = "<hr>";
	static final String hr_value = "--------------------------------------------------------------------------------";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder content = new StringBuilder();

		String str;
		String text = "";
		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				switch (token) {
				case br_text:
					if(text.length() != 0) System.out.print(text);
					text="";
					System.out.print(br_value);
					break;
				case hr_text:
					if (text.length() == 0) {
						
						System.out.println(hr_value);
					} else {
						System.out.println(text + "\n" + hr_value);
					}
					text = "";
					break;
				default:
					if (token.length() + 1 + text.length() < 80) {
						if (!text.equals("")) {
							text += " " + token;
						} else {
							text += token;
						}
					} else {
						System.out.println(text);
						text = "";
						text += token;
					}
					break;
				}
			}
		}
		System.out.println(text);
	}
}
