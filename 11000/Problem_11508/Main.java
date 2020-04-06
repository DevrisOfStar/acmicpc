package Problem_11508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static Integer[] sorted;

	public static void merge(Integer a[], int m, int middle, int n) {
		int i = m;
		int j = middle + 1;
		int k = m;
		while (i <= middle && j <= n) {
			if (a[i] >= a[j]) {
				sorted[k] = a[i++];
			} else {
				sorted[k] = a[j++];
			}
			k++;
		}

		if (i > middle) {
			for (int t = j; t <= n; t++, k++) {
				sorted[k] = a[t];
			}
		} else{
			for (int t = i; t <= middle; t++, k++) {
				sorted[k] = a[t];
			}
		}
		for (int t = m; t <= n; t++) {
			a[t] = sorted[t];
		}
	}

	static void mergeSort(Integer a[], int m, int n) {
		int middle;
		if (m < n) {
			middle = (m + n) / 2;
			mergeSort(a, m, middle);
			mergeSort(a, middle + 1, n);
			merge(a, m, middle, n);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		sorted = new Integer[N];
		long sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(arr, 0, N - 1);
		for (int i = 0; i < N; i++) {
			if ((i + 1) % 3 == 0)
				continue;
			sum += arr[i];
		}

		System.out.println(sum);

	}
}
