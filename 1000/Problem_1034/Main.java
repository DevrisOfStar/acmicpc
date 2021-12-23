package Problem_1034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		String buf = br.readLine();
		int N = Integer.parseInt(buf.split(" ")[0]);
		int M = Integer.parseInt(buf.split(" ")[1]);

		for (int i = 0; i < N; i++) {
			buf = br.readLine();
			if (map.containsKey(buf)) {
				map.put(buf, map.get(buf) + 1);
			} else {
				map.put(buf, 1);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		int answer = 0;
		
		if (K == 0) {
			String s = "";
			for (int i = 0; i < M; i++)
				s += '1';
			if (map.containsKey(s))
				System.out.println(map.get(s));
			else
				System.out.println(0);
		} else {
			for (String str : map.keySet()) {
				int zeros_ = 0;
				for (int i = 0; i < str.length(); i++)
					if (str.charAt(i) == '0')
						zeros_++;
				if (zeros_ <= K && zeros_ % 2 == K % 2)
					answer = Math.max(answer, map.get(str));
			}
			System.out.println(answer);
		}
	}
}
