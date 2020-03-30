package Problem_1041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[6];
		long[] as = new long[3];
		BigInteger sum = BigInteger.ZERO;
		String str = br.readLine();
		for (int i = 0; i < 6; i++)
			arr[i] = Long.parseLong(str.split(" ")[i]);
		if (N == 1) {
			Arrays.sort(arr);
			for (int i = 0; i < 5; i++)
				sum.add(new BigInteger(String.valueOf(arr[i])));
		} else {
			BigInteger a, b, c;
			BigInteger n, n1, n2;
			as[0] = arr[0] > arr[5] ? arr[5] : arr[0];
			as[1] = arr[1] > arr[4] ? arr[4] : arr[1];
			as[2] = arr[2] > arr[3] ? arr[3] : arr[2];
			Arrays.sort(as);
			a = BigInteger.valueOf(as[0]);
			a = a.add(BigInteger.valueOf(as[1]));
			a = a.add(BigInteger.valueOf(as[2]));

			
			b = BigInteger.valueOf(as[0]);
			b = b.add(BigInteger.valueOf(as[1]));
			
			c = BigInteger.valueOf(as[0]);

			n = BigInteger.valueOf(N);
			n1 = BigInteger.valueOf(5).multiply(n).multiply(n);
			n1 = n1.subtract(BigInteger.valueOf(16).multiply(n));
			n1 = n1.add(BigInteger.valueOf(12));
			n2 = BigInteger.valueOf(8).multiply(n);
			n2 = n2.subtract(BigInteger.valueOf(12));
			sum = sum.add(c.multiply(n1));
			sum = sum.add(b.multiply(n2));
			sum = sum.add(a.multiply(BigInteger.valueOf(4)));
		}
		System.out.println(sum);
	}
}
