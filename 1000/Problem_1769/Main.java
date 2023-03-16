package Problem_1769;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int cnt = 0;
        while(true) {
            if(num.length() == 1) break;
            long number = 0;
            for(int i = 0; i<num.length();i++) number += (num.charAt(i)- '0');
            num = String.valueOf(number);
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(Integer.valueOf(num) % 3 == 0 ? "YES": "NO");

        sc.close();
    }
}
