package Problem_5532;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        A = (int)(Math.ceil((double)A/(double)C));
        B = (int)(Math.ceil((double)B/(double)D));
        L -= A > B ? A : B;
        
        System.out.println(L);
        sc.close();
    }
}
