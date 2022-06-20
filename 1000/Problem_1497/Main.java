package Problem_1497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static int Max_SingCnt = Integer.MIN_VALUE;
    static String bf;
    static boolean[][] isPossible;
    static boolean[] buyList;
    static boolean[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bf = br.readLine();
        N = Integer.parseInt(bf.split(" ")[0]);
        M = Integer.parseInt(bf.split(" ")[1]);
        isPossible = new boolean[N][M];
        buyList = new boolean[N];
        result = new boolean[M];

        for(int i = 0; i<N; i++) {
            bf = br.readLine().split(" ")[1];
            for(int j = 0; j<M;j++) {
                isPossible[i][j] = bf.charAt(j) == 'Y' ? true : false;
            }
        }
        
        solved(0);
        if(answer > M+1) answer = -1;
        System.out.println(answer);
    }

    public static void solved(int idx) {
        if(idx == N) { 
            for(int i = 0; i<M; i++) result[i] = false;
            for(int i = 0; i<N;i++) {
                if(buyList[i]) {
                    for(int j = 0; j<M; j++) {
                        result[j]|=isPossible[i][j];
                    }
                }
            }

            int Getter = 0;
            for(int i = 0; i<M;i++) Getter += (result[i] ? 1 : 0);
            if(Getter <= M && Getter > 0) {
                int SingCnt = Getter;
                if(Max_SingCnt <= SingCnt) {
                    Max_SingCnt = SingCnt;

                    Getter = 0;
                    for(int i = 0; i<N; i++) Getter += (buyList[i] ? 1 : 0);
                    if(answer > Getter) answer = Getter;
                }
                
            }

        } else {
            buyList[idx] = true;
            solved(idx+1);
            buyList[idx] = false;
            solved(idx+1);
        }
    }
}
