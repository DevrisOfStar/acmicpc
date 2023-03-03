package Problem_1159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26]; // a-z
        String buf;
        for(int i = 0; i<N;i++) {
            buf = br.readLine();
            arr[buf.charAt(0)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<26;i++) 
            if(arr[i] >= 5)
                sb.append((char)('a'+ i));
        
        if(sb.toString().equals("")) System.out.println("PREDAJA");
        else System.out.println(sb.toString());

    }
}
