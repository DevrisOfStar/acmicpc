package Problem_14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {0,-1,1,0};
    static int[] dy = {1,0,0,-1};
    static int n,m;
    static int[][] map;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] buf = br.readLine().split(" ");
        n = Integer.parseInt(buf[0]);
        m = Integer.parseInt(buf[1]);
        
        Queue<int[]> q = new LinkedList<>();

        map = new int[n][m];
        answer = new int[n][m];

        
        
        for(int i = 0; i<n; i++) {
            buf = br.readLine().split(" ");
            
            for(int j =0; j<m; j++) {
                map[i][j] = Integer.parseInt(buf[j]);
                answer[i][j] = -1;

                if(map[i][j] == 2) {
                    q.add(new int[]{i, j});            
                    answer[i][j] = 0;
                }
            }
        }

        
        int x_, y_;
        while(!q.isEmpty()) {
            int[] data = q.poll();
            
            for(int k = 0; k < 4; k++) {
                x_ = data[0] + dx[k];
                y_ = data[1] + dy[k];
                if(x_ < 0 || y_ < 0 || x_ >= n || y_ >= m) continue;
                if(answer[x_][y_] >= 0) continue;
                if(map[x_][y_] == 0 || map[x_][y_] == 2) continue; 

                q.add(new int[]{x_, y_});
                answer[x_][y_] = answer[data[0]][data[1]] + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                sb.append(map[i][j]== 0 ? 0 : answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
