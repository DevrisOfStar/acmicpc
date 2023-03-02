package Problem_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int N = Integer.parseInt(buf.split(" ")[0]);
        int M = Integer.parseInt(buf.split(" ")[1]);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<N+M;i++) {
            buf = br.readLine();
            if(map.containsKey(buf)) 
                map.put(buf, (map.get(buf) + 1));
            else map.put(buf, 1);
        }
        Set<String> Keys = map.keySet();
        Set<String> answer = new HashSet<>();

        for(String key : Keys) {
            if(map.get(key) >= 2)  answer.add(key);
        }
        Object[] answer_array = answer.toArray();
        Arrays.sort(answer_array);

        StringBuilder sb = new StringBuilder();
        sb.append(answer_array.length).append("\n");
        for(int i = 0; i<answer_array.length; i++) {
            sb.append(answer_array[i]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
