package Problem_2981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int[] arr = new int[Integer.parseInt(buf)];

        for(int i = 0; i<arr.length; i++) {
            buf = br.readLine();
            arr[i] = Integer.parseInt(buf);
        }
        Arrays.sort(arr);
        
        HashSet<Integer> subNum = new HashSet<>();
        for(int i = 0; i<arr.length-1; i++) {
            subNum.add(Math.abs(arr[i+1] - arr[i]));
        }
        
        Object[] data = subNum.toArray();
        Arrays.sort(data);
        
        int minGCD = (int)data[0];
        for(int i = 1; i<data.length;i++) {
            minGCD = gcd(minGCD, (int)data[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<=minGCD;i++) {
            if(minGCD % i == 0) {
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb.toString());
    }

    static int gcd(int a, int b) {
        if(a%b==0) return b;
       return gcd(b,a%b);
    }
}
