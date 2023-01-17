package Problem_13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int M = Integer.parseInt(buf.split(" ")[0]);
        int N = Integer.parseInt(buf.split(" ")[1]);

        int[][] map = new int[M][N];
        boolean[][] isvisited = new boolean[M][N];

        for(int i = 0 ;i<M; i++) {
            buf = br.readLine();
            for(int j = 0; j<N; j++) {
                map[i][j] = buf.charAt(j) -'0';
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<N;i++) {
            if(map[0][i] == 0){
                q.add(new int[]{0,i});
                isvisited[0][i] = true;
            }
        }

        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};
        while(!q.isEmpty()) {
            int[] data = q.poll();
            for(int k = 0; k<4; k++) {
                int x_ = dx[k] + data[0];
                int y_ = dy[k] + data[1];
                if(x_ < 0 || y_ < 0 || x_ >= M || y_ >= N) continue;
                if(isvisited[x_][y_]) continue;
                if(map[x_][y_] > 0) continue;
                q.add(new int[]{x_,y_});
                map[x_][y_] = 2;
                isvisited[x_][y_] = true;
            }
        }   

        for(int i = 0; i<N; i++) {
            if(map[M-1][i] == 2) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }
}