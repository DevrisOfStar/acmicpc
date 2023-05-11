package Problem_5543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int burger = Integer.MAX_VALUE;
        int bever = Integer.MAX_VALUE;
        int temp;
        for(int i = 0; i<3; i++) {
            temp = Integer.parseInt(br.readLine());
            if(burger > temp) burger = temp;
        }

        for(int i = 0; i<2; i++) {
            temp = Integer.parseInt(br.readLine());
            if(bever > temp) bever = temp;
        }

        temp = burger+bever-50;
        System.out.println(temp);
    }
}
