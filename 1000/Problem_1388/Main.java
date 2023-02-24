package Problem_1388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] isvisited;
    static int[][] cord_c = {{-1,1},{0,0}}; // |
    static int[][] cord_r = {{0,0},{-1,1}}; // -
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        N = Integer.parseInt(buf.split(" ")[0]);
        M = Integer.parseInt(buf.split(" ")[1]);
        map = new int[N][M];
        isvisited = new boolean[N][M];
        for(int i = 0; i<N; i++) {
            buf = br.readLine();
            for(int j = 0; j<M;j++) {
                map[i][j] = buf.charAt(j) == '-' ? 1 : 2;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(!isvisited[i][j]) {
                    cnt++;

                    isvisited[i][j] = true;
                    if(map[i][j] == 1) { // '-'
                        q.add(new int[]{i,j,1});
                    } else { // '|'
                        q.add(new int[]{i,j,2});
                    }

                    while(!q.isEmpty()) {
                        int[] data = q.poll();
                        if(data[2] == 1) {
                            for(int k = 0; k< 2; k++) {
                                int x_ = data[0] + cord_r[0][k];
                                int y_ = data[1] + cord_r[1][k];
                                if(x_ < 0 || y_ < 0 || x_ >= N || y_ >= M) continue;
                                if(isvisited[x_][y_]) continue;
                                if(map[x_][y_] != data[2]) continue;
                                isvisited[x_][y_] = true;
                                q.add(new int[] {x_,y_, data[2]});
                            }
                        } else {
                            for(int k = 0; k< 2; k++) {
                                int x_ = data[0] + cord_c[0][k];
                                int y_ = data[1] + cord_c[1][k];
                                if(x_ < 0 || y_ < 0 || x_ >= N || y_ >= M) continue;
                                if(isvisited[x_][y_]) continue;
                                if(map[x_][y_] != data[2]) continue;
                                isvisited[x_][y_] = true;
                                q.add(new int[] {x_,y_, data[2]});
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(cnt);
    }
}
