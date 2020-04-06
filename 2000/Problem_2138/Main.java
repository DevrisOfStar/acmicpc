package Problem_2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int len;
	static int[] a;
	static int[] b;
	static int cnt_a, cnt_b, cnt;
	static boolean is_a, is_b;

	public static void push(int idx) {
		for (int i = idx - 1; i <= idx + 1; i++) {
			if (i < 0 || i >= len)
				continue;
			a[i] = 1 - a[i];
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		int[] arr = new int[len];
		a = new int[len];
		b = new int[len];
		is_a = true;
		is_b = true;
		String a_ = br.readLine();
		String b_ = br.readLine();
		for (int i = 0; i < len; i++) {
			a[i] = a_.charAt(i) - '0';
			b[i] = b_.charAt(i) - '0';
			arr[i] = a[i];
		}
		
		// 첫번째를 눌렀을때,
		push(0);
		cnt_a++;
		for (int i = 0; i < len - 1; i++) {
			if (a[i] != b[i]) {
				push(i + 1);
				cnt_a++;
			}
		}
		if (a[len - 1] != b[len - 1]) is_a = false;
		
		for (int i = 0; i < len; i++) a[i] = arr[i];
		
		// 첫번째를 안 눌렀을때,
		for (int i = 0; i < len - 1; i++) {
			if (a[i] != b[i]) {
				push(i + 1);
				cnt_b++;
			}
		}
		if (a[len - 1] != b[len - 1])
			is_b = false;
		if (is_a && is_b)
			cnt = Math.min(cnt_a, cnt_b);
		else if (!is_a && !is_b)
			cnt = -1;
		else if (!is_a)
			cnt = cnt_b;
		else if (!is_b)
			cnt = cnt_a;

		System.out.println(cnt);

	}
}
