package Problem_1662;

import java.util.Scanner;

public class Main {
    static boolean[] isvisited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        isvisited = new boolean[str.length()];

        int N = getLength(str, 0);    
        System.out.println(N);
        sc.close();
    }

    public static int getLength(String str, int idx) {
        int cnt = 0;
        
        for(int i = idx; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' && !isvisited[i]) {
                isvisited[i] = true;
                int num = str.charAt(i-1) - '0';
                cnt--;
                cnt += num * getLength(str, i+1);
            } else if (c == ')' && !isvisited[i]) {
                isvisited[i] = true;
                return cnt;
            } else if(!isvisited[i]){
                isvisited[i] = true;
                cnt++;
            }
        }

        return cnt;
    }
}
