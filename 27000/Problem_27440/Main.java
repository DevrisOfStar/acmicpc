package Problem_27440;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        Queue<long[]> q = new LinkedList<>();
        HashSet<Long> hs = new HashSet();
        
        q.add(new long[]{N, 0});
        hs.add(N);

        while(!q.isEmpty()) {
            long[] data = q.poll();
            if(data[0] == 1) {
                System.out.println(data[1]);
                sc.close();
                return;
            }

            if(data[0] % 3 == 0 && !hs.contains(data[0] / 3)) {
                hs.add(data[0] / 3);
                q.add(new long[]{data[0]/3, data[1] + 1});
            }

            if(data[0] % 2 == 0 && !hs.contains(data[0] / 2)) {
                hs.add(data[0] / 2);
                q.add(new long[]{data[0]/2, data[1] + 1});
            }
            
            if(!hs.contains(data[0]-1)) {
                hs.add(data[0]-1);
                q.add(new long[]{data[0]-1, data[1] + 1});
            }
        }
        sc.close();
    }
}
