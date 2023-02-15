package Problem_8896;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] robots = new String[N];
            boolean[] isLose = new boolean[N];
            
            for(int i = 0; i<N; i++) robots[i] = br.readLine();
            int round = robots[0].length();
            
            for(int j = 0; j<round;j++){
                int[] playGame = new int[3]; // R,P,S

                for(int i = 0; i<N; i++) {
                    if(isLose[i]) continue;
                    char p = robots[i].charAt(j);
                    switch(p) {
                        case 'R': playGame[0]++; break;
                        case 'P': playGame[1]++; break;
                        case 'S': playGame[2]++; break;
                    }
                }
                // round 판단
                int flag = 0;
                for(int i = 0; i<3; i++) if(playGame[i] == 0) flag++;
                if(flag >= 2 || flag == 0) continue;
                char loser;
                if(playGame[0] == 0) { // P,S
                    loser = 'P';
                }
                else if(playGame[1] == 0) { // R, S
                    loser = 'S';
                }
                else { // R, P
                    loser = 'R';
                }

                for(int i = 0; i<N; i++) {
                    if(isLose[i]) continue;
                    char p = robots[i].charAt(j);
                    if(loser == p) {
                        isLose[i] = true;
                    }
                }
            }    
            int cnt = 0; 
            int winner = 0;
            for(int i = 0; i<N; i++){
                if(!isLose[i]) {
                    cnt++;
                    winner = i+1;
                }
            }
            if(cnt >= 2) sb.append("0").append("\n");
            else sb.append(winner).append("\n");
        }
        System.out.print(sb.toString());
    }
}
