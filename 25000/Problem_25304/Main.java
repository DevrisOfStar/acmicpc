package Problem_25304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        String str;
        int cntAmount = 0;
        for(int i = 0; i<N; i++) {
            str = br.readLine();
            cntAmount += ( Integer.parseInt(str.split(" ")[0]) *
                           Integer.parseInt(str.split(" ")[1]));
        }
        if(amount == cntAmount) System.out.println("Yes");
        else System.out.println("No");
    }
}
