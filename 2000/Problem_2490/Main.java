package Problem_2490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] answer = {"E","A","B","C","D"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            while(st.hasMoreTokens()) {
                String sts = st.nextToken();
                if(sts.equals("0")) cnt++;
            }

            System.out.println(answer[cnt]);
        }
    }
}
