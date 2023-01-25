package Problem_17298;

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
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> stk = new Stack<>();
    
        for(int i = N-1; i>=0 ;i--) {
            while(!stk.empty() && stk.peek() <= arr[i]) stk.pop();
            if(stk.empty()) answer[i] = -1;
            else answer[i] = stk.peek();
            stk.push(arr[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N;i++) sb.append(answer[i]).append(" ");
        System.out.print(sb.toString());
    }
}
