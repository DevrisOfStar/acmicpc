package Problem_1652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        
        for(int i = 0; i<N; i++) {
            String buf = br.readLine();
            for(int j = 0; j<N;j++) {
                arr[i][j] = buf.charAt(j);
            }
        }
        int col = 0;
        int row = 0;
        for(int i = 0; i<N; i++) {
            int cnt_row = 0;
            int cnt_col = 0;
            for(int j =0;j<N; j++) {
                if(arr[i][j] == '.') {
                    cnt_row++;
                } else {
                    if(cnt_row >= 2) row++;
                    cnt_row = 0;
                }
                if(arr[j][i] == '.') {
                    cnt_col++;
                } else {
                    if(cnt_col >= 2) col++;
                    cnt_col = 0;
                }
            }
            if(cnt_row >= 2) row++;
            if(cnt_col >= 2) col++;
        }
        
        System.out.println(row + " " + col);

    }
}
