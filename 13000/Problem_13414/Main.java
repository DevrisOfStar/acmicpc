package Problem_13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static int K,L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		K = Integer.parseInt(str.split(" ")[0]);
		L = Integer.parseInt(str.split(" ")[1]);
		Map<String, Integer> map = new HashMap<>();
		int num = 0;	
		
		for(int i = 0; i<L;i++) {
			num++;
			str = br.readLine();
			map.put(str, num);
		}
		List<String> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
	
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<Math.min(K, keyList.size()); i++) {
			sb.append(keyList.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
