package Problem_2010;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 1;
        for(int i = 0; i<N; i++) { cnt += (sc.nextInt()-1); }
        System.out.println(cnt);
        sc.close();
    }
}
