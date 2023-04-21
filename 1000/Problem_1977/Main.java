package Problem_1977;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int st = sc.nextInt();
        int en = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = st; i<= en; i++) {
            int tmp = (int)(Math.sqrt(i));
            if(i == tmp * tmp) {
                if(min > i) min = i;
                sum += i;
            }
        }
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
        
        sc.close();
    }
}
