package Problem_1660;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        HashSet<Integer> set = new HashSet<>();
        
        int idx = 0;
        int cnt = 0;
        for(int i = 1; idx <=N; i++) {
            cnt += i;
            idx += cnt;
            if(idx > N) continue;
            dp[idx] = 1;
            set.add(idx);
        }
        Object[] myunsu = set.toArray();
        for(int i = 2; i<=N; i++) {
            for(Object Myun : myunsu) {
                if(i-(int)Myun < 0) continue;
                if(dp[i-(int)Myun] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i-(int)Myun] + 1);
            }
        }

        System.out.println(dp[N]);
        sc.close();
    }
}
