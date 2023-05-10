package Problem_17608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        
        for(int i = 0; i<N; i++) {
            num = Integer.parseInt(br.readLine());
            while(!stack.isEmpty() && stack.peek() <= num)  stack.pop();
            stack.add(num);
        }

        System.out.println(stack.size());
    }
}
