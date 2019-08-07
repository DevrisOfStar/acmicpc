package Problem_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int top = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean flag;
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			top = -1;
			flag = false;
			t: for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(') {
					++top;
				} else {

					if (top != -1)
						top--;
					else {
						System.out.println("NO");
						flag = true;
						break t;
					}
				}

			}
			if (top == -1 && !flag) {
				System.out.println("YES");
			} else if(!flag) {
				System.out.println("NO");
			}
			

		}
	}
}
