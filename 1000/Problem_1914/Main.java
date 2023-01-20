package Problem_1914;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger answer = BigInteger.valueOf(2).pow(N).subtract(BigInteger.valueOf(1));
        
        System.out.println(answer.toString());
        if(N <= 20) {
            getRoute(N,"1","2","3");
            System.out.print(sb.toString());
        }
        sc.close();
    }

    public static void getRoute(int N, String from, String temp, String to) {
        if(N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        getRoute(N-1, from, to, temp);
        sb.append(from).append(" ").append(to).append("\n");
        getRoute(N-1, temp, from, to);
    }
}
