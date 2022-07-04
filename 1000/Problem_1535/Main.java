package Problem_1535;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] L = new int[N];
        int[] J = new int[N];
        String buf = br.readLine();
        
        for(int i = 0; i<N; i++) L[i] = Integer.parseInt(buf.split(" ")[i]);
        buf = br.readLine();
        for(int i = 0; i<N; i++) J[i] = Integer.parseInt(buf.split(" ")[i]);
        
        int MaxJoy = 0;

        for(int i = 0; i < 1 << N; i++) {
            int HP = 100;
            int cntJoy = 0;

            for(int j = 0; j<N; j++) {
                if((i & (1 << j)) == 1<<j) {
                    HP-=L[j];
                    cntJoy+=J[j];
                }    
            }

            if(HP <= 0) continue;
            if(MaxJoy < cntJoy) MaxJoy = cntJoy;    
        }

        System.out.println(MaxJoy);

    }
}
