	package Problem_16637;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	
	public class Main {
	
		static int max = Integer.MIN_VALUE;
		static int cnt =0;
		
		public static void dfs(ArrayList<String> arr, int idx) {
			// arr.size() < idx == 괄호를 칠 수 없을때,
			if(arr.size() >= 1 && arr.size() < idx) { // 순차계산
				while(arr.size() > 1) { // 계산한 결과가 나올때까지.
					int a = Integer.parseInt(arr.get(0));
					int b = Integer.parseInt(arr.get(2));
					
					switch(arr.get(1)) {
					case "+":
						arr.set(1,String.valueOf(a+b));
						break;
					case "*":
						arr.set(1,String.valueOf(a*b));
						break;
					case "-":
						arr.set(1,String.valueOf(a-b));
						break;
					}				
					arr.remove(2);
					arr.remove(0);
				}
				int data = Integer.parseInt(arr.get(0));
				if(data > max) max = data;
				return;
			}
			else { // 괄호 계산
				int size = arr.size();
				for(int i = idx; i < size; i++) {
					if(i%2==1) {
						List<String> temp = new ArrayList<>(arr);					
						int a = Integer.parseInt(arr.get(i-1));
						int b = Integer.parseInt(arr.get(i+1));
						
						switch(arr.get(i)) {
						case "+":
							arr.set(i,String.valueOf(a+b));
							break;
						case "*":
							arr.set(i,String.valueOf(a*b));
							break;
						case "-":
							arr.set(i,String.valueOf(a-b));
							break;
						}
						
						arr.remove(i+1);
						arr.remove(i-1);
						dfs(arr, (i+1));
						arr = new ArrayList<>(temp);
					}
				}
				dfs(arr, idx+2);
			}
				
		}
		
		
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			String t = br.readLine();
			ArrayList<String> arr = new ArrayList<>();
			for (int i = 0; i < t.length(); i++) {
				arr.add(String.valueOf(t.charAt(i)));
			}
	
			dfs(arr, 0);
			System.out.println(max);
	
		}
	}
