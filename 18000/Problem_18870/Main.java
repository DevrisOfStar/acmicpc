package Problem_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] data = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Long> map = new HashSet<>();

        for(int i = 0; i<N; i++) {
            data[i] = Long.parseLong(st.nextToken());
            map.add(data[i]);
        }
        Object[] obj = map.toArray();
        Arrays.sort(obj);
        
        HashMap<Long, Integer> hsmap = new HashMap<>();
        for(int i = 0; i<obj.length;i++) {
            hsmap.put((Long)obj[i], i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N;i++) {
            sb.append(hsmap.get(data[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
