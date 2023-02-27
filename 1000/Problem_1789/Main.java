package Problem_1789;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long a = 0, i = 0;

        while(true) {
            a+=i;
            if(a>N) break;
            i++;
        }
        
        i-=1;
        System.out.println(i);
        sc.close();
    }
}
