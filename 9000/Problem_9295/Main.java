package Problem_9295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String buf;
        for(int t = 1; t<=T;t++) {
            buf = br.readLine();
            sb.append("Case ")
            .append(t)
            .append(": ")
            .append(Integer.parseInt(buf.split(" ")[0]) +
                Integer.parseInt(buf.split(" ")[1]))
            .append("\n");
        }
        System.out.print(sb.toString());
    }
}
