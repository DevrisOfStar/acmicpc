package Problem_10546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		String tmp;
		for(int i = 0; i<2*N-1; i++) {
			tmp = br.readLine();
			if(map.containsKey(tmp)) map.put(tmp, map.get(tmp)+1);
			else  map.put(tmp, 1);
		}
		
		for(String k : map.keySet()) 
			if(map.get(k)%2==1) System.out.println(k);
	}
}
