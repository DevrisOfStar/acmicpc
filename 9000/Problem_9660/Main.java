package Problem_9660;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 창영 win : true, 상근 win : false
		long N = sc.nextLong();
		
		// 2, 7 : CY, not(2,7) : SK
		if(N%7 == 2 || N%7 == 0) System.out.println("CY");
		else System.out.println("SK");
	}
}