package Problem_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] alphas = new boolean[26];
        char cur = '1';
        int idx = 0;
        int cnt = 0;
        for(int i = 0; i<N; i++) {
            String str = br.readLine();

            for(idx = 0; idx<str.length();idx++) {
                if(cur == str.charAt(idx)) continue;
                if(alphas[str.charAt(idx)-'a']) break;
                alphas[str.charAt(idx)-'a'] = true;
                cur = str.charAt(idx);
            }

            if(idx == str.length()) cnt++;
            
            Arrays.fill(alphas, false);
            cur = '1';
            idx = 0;
        }

        System.out.println(cnt);
    }
}