package Problem_1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> { return o2-o1; });

        // input
        for(int i = 0; i<N; i++) pq.add(Integer.parseInt(br.readLine()));
        long answer = 0;
        long temp = 0;
        for(int i = 1; !pq.isEmpty(); i++) {
            temp = pq.poll() - (i-1);
            answer += temp > 0 ? temp : 0;
        }

        System.out.println(answer);
    }
}
