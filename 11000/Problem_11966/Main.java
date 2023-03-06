package Problem_11966;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        while(l > 1) {
            if(l%2 != 0) break;
            l/=2;
        }
        System.out.println(l > 1 ? 0 : 1);
        sc.close();
    }
}
