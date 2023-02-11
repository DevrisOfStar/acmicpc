package Problem_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int N = Integer.parseInt(buf.split(" ")[0]);
        int K = Integer.parseInt(buf.split(" ")[1]);
        HashMap<Integer, String> NumberToNameMap = new HashMap<>();
        HashMap<String, Integer> NameToNumberMap = new HashMap<>();
        for(int i = 1; i<=N; i++) {
            buf = br.readLine(); // name
            NumberToNameMap.put(i, buf);
            NameToNumberMap.put(buf, i);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<=K;i++) {
            buf = br.readLine();
            if(buf.charAt(0) - '0' >= 0 && buf.charAt(0) - '0' <= 9)
                sb.append(NumberToNameMap.get(Integer.parseInt(buf))).append("\n");
            else 
                sb.append(NameToNumberMap.get(buf)).append("\n");
        }
        System.out.print(sb.toString());
    }   
}
