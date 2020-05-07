package Problem_5052;

import java.util.Scanner;

public class Main {
	static class Trie {
		Node[] root;
		
		Trie() {
			root = new Node[10];
		}
		
		boolean add(String key) {
			int first = key.charAt(0) - 48; // 0~9
			if(root[first] == null) root[first] = new Node();
			Node now = root[first];
			for(int i = 0; i<key.length(); i++) {
				int next = key.charAt(i) - 48;
				
				if(now.child[next] == null) now.child[next] = new Node();
				
				now = now.child[next];
				
				if(now.finish) return false;
			}
			now.finish = true;
			return true;
		}
		
	}
	
	static class Node {
		Node[] child;
		boolean finish;
		Node() {
			child = new Node[10];
			finish = false;
		}
	}
	
	static void quickSort(String[] a, int left, int right){
        int l = left;
        int r = right;
        String pivot = a[(left+right)/2];
        while(left<=right){
            while(a[left].compareTo(pivot)<0) ++left;
            while(a[right].compareTo(pivot)>0) --right;
            if(left<=right){
                String temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                ++left; --right;
            }
        }
        if(l<right) quickSort(a, l, right);
        if(left<r) quickSort(a, left, r);
    }


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0; tc<t; tc++) {
			boolean possible = true;
			
			Trie trie = new Trie();
			int n = sc.nextInt();
			
			String[] a = new String[n];
			for(int i = 0; i<n;i++) a[i] = sc.next();
			quickSort(a, 0, a.length-1);
			
			for(int i = 0; i <n; i++) {
				if(trie.add(a[i])) continue;
				possible = false;
				break;
			}
			System.out.println(possible ? "YES" : "NO");
			
			
		}
	}
}
