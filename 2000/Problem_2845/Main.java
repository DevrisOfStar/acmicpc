package Problem_2845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int peoples = Integer.parseInt(buf.split(" ")[0]) * Integer.parseInt(buf.split(" ")[1]);
        buf = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<buf.split(" ").length; i++) {
            sb.append(Integer.parseInt(buf.split(" ")[i]) - peoples).append(" ");
        }

        System.out.println(sb.toString().trim());
        
    }
}
