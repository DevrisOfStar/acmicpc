package Problem_16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static int N,M,K;
	static int[][] A, Y;
	static PriorityQueue<pair> trees = new PriorityQueue<>();
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,1,-1,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		N = Integer.parseInt(buf.split(" ")[0]);
		M = Integer.parseInt(buf.split(" ")[1]);
		K = Integer.parseInt(buf.split(" ")[2]);
		Y = new int[N+1][N+1]; // 양분
		A = new int[N+1][N+1]; // 추가 양분의 양
		
		for(int i = 1; i <=N; i++) {
			buf = br.readLine();
			for(int j = 1; j<=N; j++) {
				A[i][j] = Integer.parseInt(buf.split(" ")[j-1]);
			}
			Arrays.fill(Y[i], 5);
		}
		
		for(int i = 0; i<M; i++) {
			buf = br.readLine();
			int x = Integer.parseInt(buf.split(" ")[0]);
			int y = Integer.parseInt(buf.split(" ")[1]);
			int z = Integer.parseInt(buf.split(" ")[2]);
			trees.add(new pair(x,y,z));
		}
		
		
		simulate();
		
		System.out.println(trees.size());
		
	}
	
	static public void simulate() {
		
		for(int year = 1; year <= K; year++) {
			ArrayList<pair> deadTrees = new ArrayList<pair>();
			ArrayList<pair> breedTrees = new ArrayList<pair>();
			int t_size = trees.size();
			
			// 봄
			// 나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가한다.
			// 어린나무부터 양분을 먹는다.
			// 땅에 양분이 부족해 먹을 수 없으면 죽는다.
			PriorityQueue<pair> newTrees = new PriorityQueue<pair>();
			
			for(int i = 0; i<t_size;i++) {
				pair tree = trees.poll();
				if(Y[tree.x][tree.y] < tree.age) { // 죽음
					deadTrees.add(new pair(tree.x, tree.y, tree.age));
					continue;
				}
				
				Y[tree.x][tree.y] -= tree.age;
				newTrees.add(new pair(tree.x, tree.y, tree.age+1));
				
				if((tree.age+1) % 5 == 0) 
					breedTrees.add(new pair(tree.x, tree.y, 1));
			}
			trees = new PriorityQueue<>(newTrees);
			
			// 여름
			// 죽은 나무 나이의 반을 양분으로 전환
			for(pair tree : deadTrees) {
				Y[tree.x][tree.y] += (tree.age/2);
			}
			deadTrees.clear();
			
			// 가을
			// 나이가 5의 배수인 나무 번식
			for(pair tree : breedTrees) {
				for(int i = 0; i<8;i++) {
					int dx_ = dx[i] + tree.x;
					int dy_ = dy[i] + tree.y;
					if(dx_ < 1 || dy_ < 1 || dx_ >N || dy_ > N) continue;
					trees.add(new pair(dx_,dy_,tree.age));
				}
 			}
			breedTrees.clear();
			
			// 겨울
			// 양분 추가
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N;j++) {
					Y[i][j] += A[i][j];
				}
			}
			
		}
	}
	static class pair implements Comparable<pair> {
		int x;
		int y;
		int age;
		public pair(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	}
}
