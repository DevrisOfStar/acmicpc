package Problem_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<N; i++) {
            String data = br.readLine();
            if(map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }
        String MaxBookTitle = "";
        int MaxCnt = Integer.MIN_VALUE;
        for(Object key : map.keySet()) {
            if(MaxCnt < map.get(key)) {
                MaxCnt = map.get(key);
                MaxBookTitle = key.toString();
            }
            else if(MaxCnt == map.get(key)) {
                if(MaxBookTitle.compareTo(key.toString()) > 0)
                    MaxBookTitle = key.toString();
            }
        }
        System.out.println(MaxBookTitle);
    }
}
