package Problem_10867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        HashSet<Integer> hashset = new HashSet<>();
        for(int i = 0 ; i<N; i++) hashset.add(arr[i]);
        Object[] arr2 = hashset.toArray();
        Arrays.sort(arr2);
        
        for(Object obj : arr2) sb.append(obj).append(" ");
        System.out.print(sb.toString());
    }
}
