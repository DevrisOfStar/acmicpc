package Problem_4994;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        StringBuilder sb = new StringBuilder();
        Queue<String[]> q = new LinkedList<>();
        boolean[] isvisited = new boolean[201];
        while((n = sc.nextInt()) != 0) {
            q.add(new String[] {"1","1"});
            while(!q.isEmpty()) {
                String[] v = q.poll();
                String value = v[0];
                int mod = Integer.parseInt(v[1]);

                if(mod == 0) {
                    sb.append(value).append("\n");
                    break;
                }
                for(int i = 0; i<=1;i++) {
                    String value_ = value + String.valueOf(i);
                    int mod_ = (mod*10+i)%n;
                    
                    if(!isvisited[mod_]) {    
                        q.add(new String[]{value_, String.valueOf(mod_)});
                        isvisited[mod_] = true;
                    }
                }

            }
            q.clear();
            Arrays.fill(isvisited, false);
        }
        System.out.print(sb.toString());
        sc.close();
    }
}
