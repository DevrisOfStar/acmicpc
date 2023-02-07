package Problem_18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N,K;
    static int[] arr;
    static boolean[] isvisited;
    static int[] order;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        N = Integer.parseInt(buf.split(" ")[0]);
        K = Integer.parseInt(buf.split(" ")[1]);
        buf = br.readLine();
        arr = new int[N];
        isvisited = new boolean[N];
        order = new int[N];
        for(int i = 0; i<N;i++) arr[i] = Integer.parseInt(buf.split(" ")[i]);
        
        getAnswer(0);
        System.out.println(cnt);
    }

    public static void getAnswer(int idx) {
        if(idx == N) {
            int weight = 500;
            for(int i = 0; i<N;i++) {
                weight-= K;
                weight+=arr[order[i]];
                if(weight < 500) return;
            }
            cnt++;
        } else {
            for(int i = 0; i<N; i++) {
                if(!isvisited[i]){
                    order[idx] = i;
                    isvisited[i] = true;
                    getAnswer(idx+1);
                    order[idx] = -1;
                    isvisited[i] = false;
                }
            }
        }
    }
}
