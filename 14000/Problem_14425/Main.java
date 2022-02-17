package Problem_14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		Set<String> arr = new HashSet<>();
		int answer = 0;
		for(int i = 0; i<N; i++) arr.add(br.readLine());
		for(int i = 0; i<M; i++) {
			str = br.readLine();
			arr.add(str);
			if(arr.size() == N) answer++;
			else arr.remove(str);
		}
		
		System.out.println(answer);
	}
}