package Problem_1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i = 0; i<arr.length; i++) hashMap.put(arr[i],i);

        if(number.length() % 3 != 0) {
            int itor = number.length()%3;
            for(int i = 0; i<(3-itor);i++){
                number = "0" + number;
            }
        }

        StringBuilder answer = new StringBuilder();
        String temp;
        for(int i = 0; i<number.length()-1; i+=3) {
               temp = number.substring(i, i+3);
               answer.append(hashMap.get(temp));
        }

        System.out.println(answer.toString());
    }
}
