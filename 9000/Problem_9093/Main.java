package Problem_9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder texter = new StringBuilder();
        String str;
        for(int i = 0; i<T; i++) {
            str = br.readLine();
            String[] strs = str.split(" ");
            for(int j = 0; j<strs.length;j++) {
                texter.append(strs[j]);
                texter.reverse();
                sb.append(texter.toString()).append(" ");
                texter.setLength(0);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
