package Problem_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 1; i<=n; i++) {
            int k = Integer.parseInt(br.readLine());
            while(num <= k) {
                stack.add(num);
                num++;
                sb.append("+").append("\n");
            }
            if(stack.isEmpty()) {
                flag = true;
            }
            if(stack.peek() == k) {
                sb.append("-").append("\n");
                stack.pop();
            } else {
                flag = true; 
            }
        }
        if(flag) System.out.println("NO");
        else System.out.print(sb.toString());
        
    }
}
