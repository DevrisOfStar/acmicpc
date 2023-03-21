package Problem_2525;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        B += C;
        A += (B/60);
        B = B%60;
        A%= 24;

        System.out.println(A + " " + B);
        sc.close();
    }
}
