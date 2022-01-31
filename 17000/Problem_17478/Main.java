package Problem_17478;

import java.util.Scanner;

public class Main {
	static int N;
	static String tab = "____";
	static String question = "\"재귀함수가 뭔가요?\"";
	static String[] answer = {
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
	};
	static String end = "라고 답변하였지.";
	static String desc = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		print(0);
		System.out.print(sb.toString());
	}
	
	public static void print(int num) {
		if(N<num) return;
		String tab_ = "";
		for(int i = 0; i<num;i++) tab_ += tab;
		sb.append(tab_).append(question).append("\n");
		if(N == num) {
			sb.append(tab_).append(desc).append("\n");
		}
		else {
			for(int i =0; i<answer.length; i++) {
				sb.append(tab_).append(answer[i]).append("\n");
			}	
		}
		print(num+1);
		sb.append(tab_).append(end).append("\n");
	}
}