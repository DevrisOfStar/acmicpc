package Problem_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i<N;i++) {
			list.add(br.readLine());
		}
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) {
					return 1;
				}
				else if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return -1;
			}
			
		});
		List<String> lis = list.stream().distinct().collect(Collectors.toList());
		
		for(String d : lis) {
			System.out.println(d);
		}
	}
}
