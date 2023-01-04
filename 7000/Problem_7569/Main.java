package Problem_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int N = Integer.parseInt(buf.split(" ")[0]);
        int M = Integer.parseInt(buf.split(" ")[1]);
        int H = Integer.parseInt(buf.split(" ")[2]);

        // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
        int[] dx = {0,0,-1,0,1,0};
        int[] dy = {0,0,0,1,0,-1};
        int[] dz = {1,-1,0,0,0,0};

        int[][][] arr = new int[H][M][N];
        Queue<int[]> q = new LinkedList<>();

        StringTokenizer st;
        for(int i = H-1; i>=0;i--) {
            for(int j = 0; j<M;j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0;k<N;k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) {
                        q.add(new int[]{i,j,k});
                    }
                }
            }    
        }

        if(q.size() == M*N*H) {
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()) {
            int size = q.size();

            for(int k = 0; k<size; k++){
                int[] data = q.poll();

                for(int i = 0; i<6; i++) {
                    int x_ = data[0] + dx[i];
                    int y_ = data[1] + dy[i];
                    int z_ = data[2] + dz[i];

                    if(x_ >= H || x_ < 0 || y_ >= M || y_ < 0 || z_ >= N || z_ < 0) continue;
                    if(arr[x_][y_][z_] == 0) {
                        arr[x_][y_][z_] = arr[data[0]][data[1]][data[2]] + 1;
                        q.add(new int[]{x_,y_,z_});
                    }
                }
            }
        }
       
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<H; i++) {
            for(int j = 0; j<M;j++) {
                for(int k = 0; k<N;k++) {
                    if(arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if(arr[i][j][k] > max) {
                        max = arr[i][j][k];
                    }       
                }
            }
        }
        
        System.out.println(max-1);
    }
}
