package Problem_1057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int size, a, b;
	static int answer = -1;

	public static void solution() {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1; i <= size;i++) {
			arr.add(i);
		}
		int cnt = 1;
		ArrayList<Integer> temp = new ArrayList<>();
		while(arr.size() != 1) {
			
			for(int i = 0; i<arr.size()/2;i++) {
				int o = arr.get(i*2);
				int p = arr.get(i*2+1);
				if((o == a && p == b)|| (o==b && p == a)) {
					answer = cnt;
					return;
				}
				if(o == a || o == b) temp.add(o);
				else if(p == a || p == b) temp.add(p);
				else temp.add(o);
			}
			
			if(arr.size()%2 == 1) temp.add(arr.get(arr.size()-1));

			arr.clear();
			for(int i = 0; i<temp.size();i++) {
				arr.add(temp.get(i));
			}
			temp.clear();
			cnt++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		size = Integer.parseInt(str.split(" ")[0]);
		a = Integer.parseInt(str.split(" ")[1]);
		b = Integer.parseInt(str.split(" ")[2]);

		solution();
		System.out.println(answer);
	}
}
