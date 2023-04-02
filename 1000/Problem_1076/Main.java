package Problem_1076;

import java.util.Scanner;

public class Main {
    static String[] name = {
        "black", "brown", "red", "orange",
        "yellow","green", "blue","violet",
        "grey","white"
    };
    static long value;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        value = getIndex(sc.nextLine());
        
        value *=10;
        value += getIndex(sc.nextLine());
        
        value *= Math.pow(10, getIndex(sc.nextLine()));
        System.out.println(value);
        sc.close();
    }

    public static int getIndex(String str) {
        for(int i = 0; i<10;i++) {
            if(name[i].equals(str)) return i;
        }
        return -1;
    }


}
