package Problem_15841;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    
    static BigInteger[] arr = new BigInteger[492];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        arr[1] = BigInteger.ONE; arr[2] = BigInteger.ONE;
        int a = 0;
        while(a != -1) {
            a = sc.nextInt();
            if(a==-1) continue;
            sb.append("Hour ").append(a).append(": ")
            .append(getAnswer(a).toString()).append(" cow(s) affected").append("\n");
        }
        System.out.print(sb.toString());
        sc.close();
    }
    
    public static BigInteger getAnswer(int a) {
        if(a < 0) return BigInteger.ZERO;
        if(arr[a] != null &&
            arr[a].compareTo(BigInteger.ZERO) == 1) return arr[a];
        return arr[a] = getAnswer(a-1).add(getAnswer(a-2));
    }
}
