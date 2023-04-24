package Problem_2776;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static List<Integer> arr = new ArrayList<>();
    static int N, M;

    static boolean findIdx(int target) {
        int l = 0; int r = arr.size()-1;
        int mid = -1;
        while(l<=r) {
            mid = (l+r)/2;
            
            int arrNum = arr.get(mid);
            if(arrNum == target) { return true; } 
            else if(arrNum < target) { l = mid+1; }
            else { r = mid-1; }
        }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr.clear();
            st = new StringTokenizer(br.readLine());
            // N
            for (int i = 0; i < N; i++) arr.add(Integer.parseInt(st.nextToken()));
            Collections.sort(arr);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            // M
            for (int i = 0; i < M; i++){
                if(findIdx(Integer.parseInt(st.nextToken()))) sb.append(1).append("\n");
                else sb.append(0).append("\n");           
            } 

        }

        System.out.print(sb.toString());

    }
}
