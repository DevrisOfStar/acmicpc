package Problem_1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] node = new int[N];
        boolean[] isvisited = new boolean[N];
        String buf = br.readLine();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<N; i++) {
            node[i] = Integer.parseInt(buf.split(" ")[i]);
            if(node[i] == -1) {
                q.add(i);
                isvisited[i] = true;
            }
        }

        int luckNumber = Integer.parseInt(br.readLine());
        int ans = 0;

        while(!q.isEmpty()) {
            int data = q.poll();
            boolean flag = false;
            for(int i = 0; i<N;i++) {
                if(isvisited[i]) continue;
                if(i == luckNumber) continue;
                if(node[i] == luckNumber) continue;
                if(node[i] == data) {
                    flag = true;
                    isvisited[i] = true;
                    q.add(i);
                }
            }

            if(!flag) ans++;
            if(node[data] == -1 && data == luckNumber) ans--;
        }
        System.out.println(ans);
    }
}
