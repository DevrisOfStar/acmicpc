package Problem_11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class data implements Comparable<data>{
	int x, y;
	
	public data(int x, int y){
		this.x = x;
		this.y = y;
	}

	

	@Override
	public int compareTo(data o) {
		if(this.x > o.x) {
			return 1;
		}
		else if(this.x == o.x) {
			return this.y > o.y ? 1 : -1;
		}
		
		return -1;
	}



	@Override
	public String toString() {
		return x + " " + y;
	}
	
	
	
}
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<data> list = new ArrayList<>();
		for(int n = 0; n<N;n++) {
			String str = br.readLine();
			list.add(new data(Integer.parseInt(str.split(" ")[0]),Integer.parseInt(str.split(" ")[1])));
		}
		
		Collections.sort(list);
		
		for(data d : list) {
			System.out.println(d);
		}
	}
}
