package Problem_7572;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        
        int a = (year+6) % 10; // 십간
        int b = (year+8) % 12; // 십이간지
        
        System.out.println(String.valueOf((char)(b+'A'))+String.valueOf(a));
        
        sc.close();
    }
}
