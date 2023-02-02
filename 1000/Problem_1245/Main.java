package Problem_1245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String buf;
    static int[][] arr;
    static boolean[][] isvisited;
    static int cnt;
    static int[] dx = {1,1,1,-1,-1,-1,0,0};
    static int[] dy = {-1,0,1,-1,0,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        buf = br.readLine();
        N = Integer.parseInt(buf.split(" ")[0]);
        M = Integer.parseInt(buf.split(" ")[1]);
        arr = new int[N][M];
        isvisited = new boolean[N][M];
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(arr[i][j] > 0 && !isvisited[i][j]) {
                    if(bfs(i,j)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean isIn(int x, int y) {
        return ((x >= 0 && x<N) && (y >= 0 && y<M));
    }

    public static boolean isTop(int x, int y) {
        for(int k = 0; k<8;k++) {
            int x_ = x + dx[k];
            int y_ = y + dy[k];
          
            if(isIn(x_, y_) && arr[x][y] < arr[x_][y_]) return false;
        }
        return true;
    }

    public static boolean bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isvisitedInbfs = new boolean[N][M];
        q.add(new int[]{i,j});
        isvisitedInbfs[i][j] = true;
        isvisited[i][j] = true;
        if(!isTop(i,j)) {return false;}
        while(!q.isEmpty()) {
            int[] data = q.poll();
            for(int k = 0; k<8; k++) {
                int x_ = data[0] + dx[k];
                int y_ = data[1] + dy[k];
                
                if(isIn(x_, y_) && !isvisitedInbfs[x_][y_] && arr[i][j] == arr[x_][y_]) {
                    if(isTop(x_, y_)){
                        isvisited[x_][y_] = true;
                        isvisitedInbfs[x_][y_] = true;
                        q.add(new int[]{x_,y_});
                    } else return false;
                }
            }
        }

        return true;
    }
}
 