package Problem_18222;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();

        System.out.println(getanswer(l));
        sc.close();
    }

    public static long getanswer(long l) {
        if(l == 1) return 0;
        long a = 0;
        for(a = 1; a+a < l; a+=a);
        return getanswer(l-a) == 1 ? 0 : 1;
    }
}