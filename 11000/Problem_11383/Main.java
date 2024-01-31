package Problem_11383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String buf = br.readLine();
        int N = Integer.parseInt(buf.split(" ")[0]);
        int M = Integer.parseInt(buf.split(" ")[1]);

        String[] arr = new String[N];

        for(int i =0; i<arr.length;i++) 
            arr[i] = br.readLine();
        for(int i = 0; i<arr.length;i++) {
            String comp = br.readLine();
            
            for(int j = 0; j<comp.length();j++) {
                if(comp.charAt(j) != arr[i].charAt(j/2)) {
                    System.out.println("Not Eyfa");
                    return;
                }
            }
        }
        
        System.out.println("Eyfa");
    }
}
