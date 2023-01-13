package Problem_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<N; i++) {
            int[] data = {arr[i], i+1};

            while(!stack.isEmpty()) {
                if(stack.peek()[0] < data[0]) {
                    stack.pop();
                } else {
                    sb.append(stack.peek()[1]).append(" ");
                    break;
                }
            }

            if(stack.isEmpty()) sb.append(0).append(" ");
            stack.add(data);
        }

        System.out.print(sb.toString());
        
    }
}
