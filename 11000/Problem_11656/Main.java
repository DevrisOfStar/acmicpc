package Problem_11656;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> arr = new ArrayList<>();

        for(int i =0; i<str.length();i++) {
            arr.add(str.substring(i));
        }

        Collections.sort(arr);
        for(int i =0; i<arr.size();i++) {
            System.out.println(arr.get(i));
        }

        sc.close();
    }
}
