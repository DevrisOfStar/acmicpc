package Problem_4673;

public class Main {
    public static void main(String[] args) {
        boolean[] visited = new boolean[10001];
        String buf;
        for(int i = 1; i<=10000;i++) {
            int num = 0;
            num += i;
            buf = String.valueOf(i);
            for(int j = 0; j<buf.length();j++) {
                num += (buf.charAt(j) - '0');
            }
            if(num <= 10000) {
                visited[num] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<= 10000; i++) {
            if(!visited[i]) sb.append(i).append("\n");
        }

        System.out.print(sb.toString());
    }
}
