package Problem_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        long[][] map = new long[N][N];
        String buf;
        long max_data = Integer.MAX_VALUE;
        for(int i = 0;i<N; i++) {
            Arrays.fill(map[i], max_data);
            map[i][i] = 0;
        }

        for(int i =0; i<M;i++) {
            buf = br.readLine();
            String[] data = buf.split(" ");
            map[Integer.parseInt(data[0])-1][Integer.parseInt(data[1])-1] = 
                Math.min(map[Integer.parseInt(data[0])-1][Integer.parseInt(data[1])-1],Long.parseLong(data[2]));
        }

        for(int k = 0; k<N; k++) {
            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N;j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N;j++) {
                sb.append(map[i][j] >= max_data ? 0 : map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
