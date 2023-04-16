package Problem_2417;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long l = 0, r = Long.MAX_VALUE;

        while(l < r) {
            long mid = (l+r)/2;
            if(Math.pow(mid,2) < n) {
                l = mid + 1; 
            } else {
                r = mid;
            }
        }
        System.out.println(l);
        sc.close();

    }
}
