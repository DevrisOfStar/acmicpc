package Problem_1284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf;
        StringBuilder sb = new StringBuilder();
        do {
            buf = br.readLine();
            if(buf.equals("0")) {
                System.out.print(sb.toString());
                return;
            }
            int cnt = 1;
            for(int i = 0; i<buf.length(); i++) {
                switch(buf.charAt(i)) {
                    case '1':
                        cnt+=2;
                        break;
                    case '0':
                        cnt+=4;
                        break;
                    default:
                        cnt+=3;
                        break;
                }
                cnt++;
            }
            sb.append(cnt).append("\n");
            
        } while(true);
    }
}
