package Problem_4779;

import java.util.Scanner;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while(sc.hasNextInt()) {
            n = sc.nextInt();
            int len = (int)(Math.pow(3, n));
            sb = new StringBuilder();
            for(int i = 0; i<len; i++) sb.append("-");
            getAnswer(0, len);   

            System.out.println(sb.toString());            
        }
    }

    public static void getAnswer(int start, int size) {
        if(size == 1) return;
        int newSize = size/3;
        for(int i = start+newSize; i<start+newSize*2;i++) sb.setCharAt(i, ' ');
                
        getAnswer(start, newSize);
        getAnswer(start + 2*newSize, newSize);
    }
}
