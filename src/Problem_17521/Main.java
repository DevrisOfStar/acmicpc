package Problem_17521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		int n = Integer.parseInt(buffer.split(" ")[0]);
		long wallet = Integer.parseInt(buffer.split(" ")[1]);

		int[] arr = new int[n+1];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		int min_price = arr[0];
		int max_price;
		
		for (int i = 1; i < n; i++) {

			if (min_price < arr[i]) {
				max_price = arr[i];
				++i;
				for (; i < n && max_price < arr[i] ; i++)
					max_price = arr[i];

				wallet = (wallet / min_price) * max_price + wallet % min_price;
			}
			min_price = arr[i];
		}

		System.out.println(wallet);

	}
}
