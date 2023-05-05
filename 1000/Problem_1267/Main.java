package Problem_1267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int YSum = 0;
        int MSum = 0;
        int YungSik = 10; // per 30s
        int MinSik = 15; // per 60s
        String log = br.readLine();
        for(int i = 0; i <N; i++) {
            int time = Integer.parseInt(log.split(" ")[i]);
            YSum +=  YungSik * (time/30 == 0 ? 1 : (time/30)+1);
            MSum +=  MinSik * (time/60 == 0 ? 1 : (time/60)+1);
        }
        
        if(YSum < MSum) { System.out.println("Y " + YSum); }
        else if(YSum > MSum) { System.out.println("M " + MSum); } 
        else { System.out.println("Y M " + YSum); }
    }
}
