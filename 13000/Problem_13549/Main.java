package Problem_13549;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] isvisited = new boolean[1000001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        isvisited[N] = true;

        while(!q.isEmpty()) {
            int[] data = q.poll();

            if(data[0] == K) {
                System.out.println(data[1]);
                sc.close();
                return;
            }
            if(data[0] != 0) {
                for(int i = 2; i*data[0]<= 100000; i*=2) {
                    if(!isvisited[i*data[0]]) {
                        q.add(new int[] {i*data[0], data[1]});
                        isvisited[i*data[0]] = true;
                    }
                }
            }

            if(data[0]-1 >= 0 && !isvisited[data[0]-1]) {
                isvisited[data[0]-1] = true;
                q.add(new int[] {data[0]-1, data[1]+1});
            }

            if(data[0]+1 <= 100000 && !isvisited[data[0]+1]) {
                isvisited[data[0]+1] = true;
                q.add(new int[] {data[0]+1, data[1]+1});
            }
        }

        sc.close();
    }
}
