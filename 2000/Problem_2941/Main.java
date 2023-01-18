package Problem_2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] c = {"c=","c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(int i = 0; i<c.length;i++)
        str = str.replace(c[i],"a");
        System.out.println(str.length());
    }   
}
