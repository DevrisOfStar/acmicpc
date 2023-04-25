package Problem_10886;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt_NotCute = 0;
        int cnt_Cute = 0;
        for (int i = 0; i < N; i++)
            if (sc.nextInt() == 0)
                cnt_NotCute++;
            else
                cnt_Cute++;

        System.out.println(cnt_NotCute > cnt_Cute ? "Junhee is not cute!" : "Junhee is cute!");
        sc.close();
    }
}
