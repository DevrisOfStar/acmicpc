package Problem_1550;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        long num = 0;
        for(int i = 0; i<str.length();i++) {
            num*=16;
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'F') {
                num += (c-'A' + 10);
            } else { num += c-'0'; }
        }
        System.out.println(num);
        sc.close();
    }
}
