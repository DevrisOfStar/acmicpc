package Problem_13301;

import java.util.Scanner;

public class Main {
    static int N;
    static long[] answer = new long[81];
    static long solve(int N) {
        if(answer[N] > 0) return answer[N];
        return answer[N] = solve(N-1) + solve(N-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        answer[0] = 1; answer[1] = 1;
        System.out.println((solve(N) + solve(N-1))*2);
        sc.close();
    }
}
