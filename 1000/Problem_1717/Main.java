package Problem_1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    static int find(int idx) {
        if(parent[idx] == idx) return idx;
        return parent[idx] = find(parent[idx]);
    }
    static void merge(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x == y) return;
        parent[y] = x;
    }

    static boolean isUnion(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x == y) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int N = Integer.parseInt(buf.split(" ")[0]);
        int M = Integer.parseInt(buf.split(" ")[1]);
        parent = new int[N+1];
        for(int i = 1; i<=N;i++) parent[i] = i;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M; i++) {
            buf = br.readLine();
            String token = buf.split(" ")[0];
            int a_ = Integer.parseInt(buf.split(" ")[1]);
            int b_ = Integer.parseInt(buf.split(" ")[2]);
            switch(token) {
                case "0": // merge
                    merge(a_, b_);
                break;
                case "1": // isUnion
                    if(isUnion(a_, b_)) sb.append("YES");
                    else sb.append("NO");
                    
                    sb.append("\n");
                break;
            }
        }
        System.out.print(sb.toString());
    }
}
