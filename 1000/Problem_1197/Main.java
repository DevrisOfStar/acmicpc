package Problem_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] parent;

    static int find_root(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find_root(parent[x]);
    }

    static boolean union_root(int x, int y) {
        int a = find_root(x);
        int b = find_root(y);
        if(a==b) return false;
        else parent[b] = a;
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int V, E;
        String buf;
        ArrayList<Node> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        buf = br.readLine();
        V = Integer.parseInt(buf.split(" ")[0]);
        E = Integer.parseInt(buf.split(" ")[1]);
        parent = new int[V+1];
        for(int i = 0; i<=V; i++) parent[i] = i;
        for(int i = 0; i<E;i++) {
            buf = br.readLine();
            arr.add(new Node(
                Integer.parseInt(buf.split(" ")[0]),
                Integer.parseInt(buf.split(" ")[1]),
                Integer.parseInt(buf.split(" ")[2])));
        }
        Collections.sort(arr);

        long sum = 0;
        long cnt = 0;
        for(Node N : arr) {
            if(union_root(N.a, N.b)) {
                sum+= N.c;
                cnt++;
            }
            if(cnt == E-1) break;
        }
        System.out.println(sum);
    }

    static class Node implements Comparable<Node>{
        int a, b, c;

        Node(int a_, int b_, int c_) {
            super();
            a = a_;
            b = b_;
            c = c_;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
        
        
    }
}
