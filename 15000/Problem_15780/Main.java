package Problem_15780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int N = Integer.parseInt(buf.split(" ")[0]);
        int K = Integer.parseInt(buf.split(" ")[1]);

        buf = br.readLine();
        StringTokenizer st = new StringTokenizer(buf);

        int cnt = 0;
        for(int i = 0; i<K; i++) {
            int c = Integer.parseInt(st.nextToken());
            cnt += (c+1)/2;
        }
        
        if(N <= cnt) System.out.println("YES");
        else System.out.println("NO");
    }
}