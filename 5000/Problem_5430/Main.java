package Problem_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class AC {
    Deque<Integer> deque;
    boolean isReverse = false;
    boolean isError = false;
    String command;

    AC(String data) {
        deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(data.substring(1, data.length()-1), ",");
        while(st.hasMoreTokens()) { deque.add(Integer.parseInt(st.nextToken().trim())); }
    }
    
    @Override
    public String toString() {
        if(this.isError) return "error";
        if(this.isReverse) {
            Deque<Integer> temp = new ArrayDeque<>();
            while(!deque.isEmpty()) {
                temp.add(deque.getLast());
                deque.removeLast();
            }
            this.deque = temp;
        } 
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(!deque.isEmpty()) { sb.append(deque.removeFirst()).append(",");}
        if(sb.toString().length() != 1) sb.delete(sb.toString().length()-1, sb.toString().length());
        sb.append("]");
        return sb.toString();
    }
    
    public void setCommand(String command) {
        this.command = command;
    }    

    public void excuteCommand() {
        for(int i = 0; i<command.length();i++) {
            switch(command.charAt(i)) {
                case 'R':
                    this.isReverse = !this.isReverse;
                    break;
                case 'D':
                    if(deque.isEmpty()) {
                        this.isError = true;
                        return;
                    }
                    if(this.isReverse) { deque.removeLast(); } 
                    else { deque.removeFirst();}
                    break;
                default:
                    break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String data_, command_;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <T; i++) {
            command_ = br.readLine();
            br.readLine();
            data_ = br.readLine();
            AC caseData = new AC(data_);
            caseData.setCommand(command_);
            caseData.excuteCommand();
            sb.append(caseData).append("\n");
        }
        System.out.print(sb.toString());
    }
}
