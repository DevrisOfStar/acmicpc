package Problem_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	static int L,C;
	static String[] arr;
	static String[] answer;
	static boolean[] is_;
	static int cnt;
	static ArrayList<String> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void answer(int idx, int st) {
		if(idx == L) {
			cnt = 0;
			for(int i = 0; i<L;i++) {
				if("aeiou".indexOf(answer[i]) != -1) {
					cnt++;
				}
			}
			if(cnt >= 1 && (L-cnt)>=2) {
				for(int i = 0; i <L;i++) sb.append(answer[i]);
				list.add(sb.toString());
				sb.setLength(0);
			}
		} else {
			for(int i = st; i <C;i++) {
				if(!is_[i]) {
					is_[i] = true;
					answer[idx] = arr[i];
					answer(idx+1, i);
					is_[i] = false;
					
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		L = Integer.parseInt(str.split(" ")[0]);
		C = Integer.parseInt(str.split(" ")[1]);
		is_ = new boolean[C];
		arr = new String[C];
		answer = new String[L];
		str = br.readLine();
		for(int i = 0; i<C;i++) {
			arr[i] = str.split(" ")[i];
		}
		
		for(int i = 0; i<C;i++) {
			for(int j = i+1; j < C;j++) {
				if(arr[i].compareTo(arr[j]) > 0) {
					str = arr[i];
					arr[i] = arr[j];
					arr[j] = str;
				}
			}
		}
		
		answer(0, 0);
		List<String> lists = list.stream().sorted().collect(Collectors.toList());
		for(int i = 0; i < list.size();i++)
			sb.append(lists.get(i)).append("\n");
		
		System.out.println(sb.toString());
	}
}
