package Problem_1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int T = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2, x, y, r;
        int k, answer;
        String buf;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<T;t++) {
            buf = br.readLine();
            answer = 0;
            x1 = Integer.parseInt(buf.split(" ")[0]);
            y1 = Integer.parseInt(buf.split(" ")[1]);
            x2 = Integer.parseInt(buf.split(" ")[2]);
            y2 = Integer.parseInt(buf.split(" ")[3]);
            k = Integer.parseInt(br.readLine());
        
            for(int i = 0; i<k; i++) {
                buf = br.readLine();
                x = Integer.parseInt(buf.split(" ")[0]);
                y = Integer.parseInt(buf.split(" ")[1]);
                r = Integer.parseInt(buf.split(" ")[2]);
                int d1 = (x1-x) * (x1-x) + (y1-y)*(y1-y);
                int d2 = (x2-x) * (x2-x) + (y2-y)*(y2-y);
                if(d1 < r*r && d2 < r*r) continue;
                else if(d1 < r*r) answer++;
                else if(d2 < r*r) answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
