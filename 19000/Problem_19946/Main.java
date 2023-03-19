package Problem_19946;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 64;
        BigInteger num = new BigInteger(sc.nextLine());
        
        while(true) {
            if(num.mod(BigInteger.TWO).equals(BigInteger.ONE) ) {
                System.out.println(answer);
                break;
            }
            num = num.divide(BigInteger.TWO);
            answer--;
        }

        
        sc.close();
    }
}
