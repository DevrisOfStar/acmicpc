package Problem_1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static String[] arr;
    static HashSet<Integer> alpha;
    static Object[] alphas_;
    static int[] order;
    static boolean[] visited;
    static int[] number = new int[26];
    static Long max = Long.MIN_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new String[N];
        alpha = new HashSet<>();

        for(int i = 0; i<N; i++) {
            arr[i] = br.readLine();
            for(int j = 0; j<arr[i].length();j++) {
                alpha.add(arr[i].charAt(j) - 'A');
            }
        }
        order = new int[alpha.size()];
        visited = new boolean[alpha.size()];
        alphas_ = alpha.toArray();
        process(0);
        System.out.println(max);
    }

    public static void process(int idx) {
        if(idx == alpha.size()) {
            for(int i = 0;i<alpha.size();i++){
                number[(int)alphas_[i]] = 9-order[i];
            }
            StringBuilder sb = new StringBuilder();
            long d_ = 0l;
            for(int i = 0; i<arr.length; i++) {
                for(int j = 0; j<arr[i].length();j++) {
                    sb.append(number[arr[i].charAt(j)-'A']);
                }
                d_ += Long.parseLong(sb.toString());
                sb.setLength(0); // init
            }
            if(d_ > max) max = d_;
        } else {
            for(int i = 0; i<alpha.size(); i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    order[idx] = i;
                    process(idx+1);
                    visited[i] = false;
                }    
            }
        }
    }
}
