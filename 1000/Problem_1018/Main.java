package Problem_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int N = Integer.parseInt(buf.split(" ")[0]);
        int M = Integer.parseInt(buf.split(" ")[1]);
        boolean[][] arr = new boolean[N][M];
        
        for(int i = 0; i<N;i++) {
            buf = br.readLine();
            for(int j = 0; j<M;j++) {
                arr[i][j] = buf.charAt(j) =='W' ? true : false; // W : B
            }
        }

        int cnt = 0, cnt2 = 0;
        int min = Integer.MAX_VALUE;
        //cnt WBWBWB, cnt2 BWBWBw
        for(int i = 0; i<=N-8; i++) {
            for(int j=0;j<=M-8;j++) {
                for(int k = 0; k<8; k++) {
                    for(int l = 0; l<8;l++) {
                        if((i+j+k+l)%2 == 0) {
                            if(arr[i+k][j+l]) cnt2++;
                            else cnt++;
                        }
                        else if((i+j+k+l)%2 == 1) {
                            if(arr[i+k][j+l]) cnt++;
                            else cnt2++;                
                        }
                    }
                }
                if(min > cnt) min = cnt;
                if(min > cnt2) min = cnt2;
                cnt = 0; cnt2 = 0;
            }
        }
        
        System.out.println(min);
    }
}
