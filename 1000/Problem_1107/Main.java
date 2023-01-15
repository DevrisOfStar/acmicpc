package Problem_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isMal = new boolean[10];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i<M; i++) 
                isMal[Integer.parseInt(st.nextToken())] = true;    
        }
        
       
        int min = Math.abs(100 - N);
        
        for(int i = 0; i<=1000000;i++) {
            if(click(i)) {
                int len = Math.abs(i-N) + String.valueOf(i).length();
                if(min > len) min = len;
            }
        }
        
        System.out.println(min);
    }

    public static boolean click(int number) {
        String str = String.valueOf(number);
        for(int i = 0; i<str.length();i++) {
            if(isMal[str.charAt(i) -'0']) return false;
        }
        return true;
    }
}
