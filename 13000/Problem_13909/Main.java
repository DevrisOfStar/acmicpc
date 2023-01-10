package Problem_13909;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long answer = 0;
        while(answer * answer <= N) answer++;
        System.out.println(answer-1);

        sc.close();
    }
}