package Problem_1357;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        X = Integer.parseInt(sb.append(X).reverse().toString());
        sb.setLength(0);
        Y = Integer.parseInt(sb.append(Y).reverse().toString());
        sb.setLength(0);

        int answer = X+Y;
        System.out.println(Integer.parseInt(sb.append(answer).reverse().toString()));
        
        sc.close();
    }
}
