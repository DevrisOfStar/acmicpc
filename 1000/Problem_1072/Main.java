package Problem_1072;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        int z = (int)(y*100/x);
        
        long l = 0; long r = x;
        long min = Integer.MAX_VALUE;
        while(l <= r) {
            long mid = (l+r)/2;
            int n_z = (int)((y+mid)*100 / (x+mid));
            if(n_z == z) {
                l = mid+1;    
            }
            else {
                if(min > mid) min = mid;
                r = mid-1;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        sc.close();
    }   
}
