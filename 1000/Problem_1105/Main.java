package Problem_1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        String a = buf.split(" ")[0];
        String b = buf.split(" ")[1];
        if(a.length() != b.length()) System.out.println(0);
        else {
            int cnt = 0;
            for(int i = 0; i<a.length(); i++) {
                if(a.charAt(i) == b.charAt(i) && a.charAt(i) == '8') cnt++;
                else if(a.charAt(i)!=b.charAt(i)) break; 
            }

            System.out.println(cnt);
        }
        
    }
}
