package Problem_10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Long> st = new Stack<>();
        long tmp = 0;
        for(int i =0; i<K;i++) {
            tmp = Long.parseLong(br.readLine());
            if(tmp > 0) {
                st.push(tmp);
            } else {
                st.pop();
            }
        }
        tmp = 0;
        while(!st.isEmpty()) {
            tmp += st.pop();
        }

        System.out.println(tmp);
    }
}
