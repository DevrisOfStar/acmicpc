package Problem_1292;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int[] arr = new int[1001];
        int idx = 1;
        for(int i = 1;;i++) {
            if(idx > 1000) break;
            for(int j = 0; j<i; j++) {
                if(idx > 1000) break;
                arr[idx] = (arr[idx-1] + i);
                idx++;
            }
        }
        System.out.println(arr[B] - arr[A-1]);
        sc.close();
    }
}
