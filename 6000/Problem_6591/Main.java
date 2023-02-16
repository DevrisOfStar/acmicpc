package Problem_6591;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 && b == 0) break;
            if(a-b < b) {
                b = a-b;
            }
            int div = 1;
            long answer = 1;
    
            while(b-- > 0) {
                answer *= a--;
                answer /= div++;
            }
    
            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }
}
