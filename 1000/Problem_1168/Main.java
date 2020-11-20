package Problem_1168;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int K = Integer.parseInt(str.split(" ")[1])-1;
		StringBuilder sb = new StringBuilder("<");
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i < N; i++) arr.add(i+1) ;
		int idx =0;
		for(int i = 0; i< N; i++) {
			idx += K;
			idx %= arr.size();
			int tmp = arr.get(idx);
			ans.add(tmp);
			arr.remove(idx);
		}
		for(int i = 0; i<ans.size()-1;i++) sb.append(ans.get(i)).append(", ");
		sb.append(ans.get(ans.size()-1)).append(">");
		System.out.println(sb);

	}
}
