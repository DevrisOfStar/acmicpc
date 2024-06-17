package Problem_2108;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] freq = new int[8001];
        int sum = 0;

        
        for(int i = 0; i<N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            freq[arr[i]+4000]++;
        }

        Arrays.sort(arr);
        int maxIdx = 0;
        
        for(int i = 1; i<8001;i++) {
            if(freq[maxIdx] < freq[i]) maxIdx = i;
        }

        for(int i = maxIdx+1; i<8001; i++) {
            if(freq[maxIdx] == freq[i]){
                maxIdx = i;
                break;
            } 
        }

        System.out.println(Math.round(sum/(double)N));
        System.out.println(arr[N/2]);
        System.out.println(maxIdx-4000);
        System.out.println(arr[N-1]-arr[0]);

        sc.close();
    }
}
