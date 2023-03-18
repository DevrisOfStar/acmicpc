package Problem_2576;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int min = 100;
        for(int i = 0; i<7; i++) {
            int num = sc.nextInt();
            if(num % 2 == 1) {
                sum += num;
                if(min > num) min = num;
            }
        }
        if(min == 100) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }
        sc.close();
    }
}
