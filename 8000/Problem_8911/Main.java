package Problem_8911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int dir;
    static int max_x, max_y;
    static int min_x, min_y;
    static int cur_x, cur_y;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String buf;
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t<=T; t++) {
            buf = br.readLine();
            dir = 0;
            cur_x = 0; cur_y = 0;
            max_x = 0; max_y = 0;
            min_x = 0; min_y = 0;

            for(int i = 0; i<buf.length();i++) {
                char c = buf.charAt(i);
                switch(c) {
                    case 'F':
                        cur_x += dx[dir];
                        cur_y += dy[dir];
                        break;
                    case 'B':
                        cur_x -= dx[dir];
                        cur_y -= dy[dir];
                        break;
                    case 'L':
                        dir = (dir+1)%4;
                        break;
                    case 'R':
                        dir = (dir+3)%4;
                        break;
                }
                if(cur_x > max_x) max_x = cur_x;
                if(cur_y > max_y) max_y = cur_y;
                if(cur_x < min_x) min_x = cur_x;
                if(cur_y < min_y) min_y = cur_y;
            }
            sb.append((max_x - min_x)*(max_y - min_y)).append("\n");
        }

        System.out.print(sb.toString());
    }
}
