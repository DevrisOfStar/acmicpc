package Problem_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h, cnt;
    static boolean[][] isvisited = new boolean[51][51];
    static int[][] map = new int[51][51];
    static Queue<int[]> q = new LinkedList<>();
    static String buf;
    static int[] dx = {0,0,-1,1,1,-1,1,-1};
    static int[] dy = {1,-1,0,0,1,-1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(;;) {
            buf = br.readLine();
            w = Integer.parseInt(buf.split(" ")[1]);
            h = Integer.parseInt(buf.split(" ")[0]);
            
            if(w == 0 && h == 0) { // exit
                System.out.print(sb.toString());
                return;
            }
            // init data
            for(int i = 0 ;i<w; i++) {
                buf = br.readLine();
                st = new StringTokenizer(buf);
                for(int j = 0; j<h;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // process
            for(int i = 0; i<w;i++) {
                for(int j =0; j<h;j++) {
                    if(map[i][j] == 1 && !isvisited[i][j]) {
                        cnt++;
                        q.add(new int[]{i,j});

                        while(!q.isEmpty()) {
                            int[] d = q.poll();
                            for(int k = 0; k<8; k++) {
                                int dx_ = d[0] + dx[k];
                                int dy_ = d[1] + dy[k];
                                if(dx_ < 0 || dy_ < 0 || dx_ > w || dy_ > h) continue;
                                if(map[dx_][dy_] == 0) continue;
                                if(isvisited[dx_][dy_]) continue;
                                isvisited[dx_][dy_] = true;
                                q.add(new int[]{dx_,dy_});
                            }
                        }
                    }
                }
            }

            sb.append(cnt).append("\n"); // getAnswer

            // init
            for(int i = 0; i<w; i++) {
                Arrays.fill(isvisited[i], false);
                Arrays.fill(map[i], 0);
            }

            q.clear();
            cnt = 0;
        }    
    }
}
