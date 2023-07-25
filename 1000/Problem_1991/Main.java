package Problem_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    String data;
    Node left;
    Node right;

    Node(String data_) {
        this.data = data_;
    }

    public void setData(String parent, String data_, boolean isLeft) {
        Node head;
        Queue<Node> q = new LinkedList<>();
        q.add(this);
        
        while(!q.isEmpty()) {
            head = q.poll();

            if(head.data.equals(parent)) {
                if(isLeft) {
                    head.left = new Node(data_);
                    q.clear();
                } else {
                    head.right = new Node(data_);
                    q.clear();
                }
            } else {
                if(head.left != null) { q.add(head.left); }
                if(head.right != null) { q.add(head.right); }
            }
        }
    }
    
    @Override
    public String toString() {
        return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
    }

    public void printData() {
        Node head;
        Queue<Node> q = new LinkedList<>();
        q.add(this);

        while(!q.isEmpty()) {
            head = q.poll();
            if(head.left != null) { q.add(head.left); }
            if(head.right != null) { q.add(head.right); }
            System.out.println(head.data);
        }
    }
}

public class Main {

    public static void preOrder(Node root, StringBuilder s) {
        s.append(root.data);
        if(root.left != null) preOrder(root.left, s);
        if(root.right != null) preOrder(root.right, s);
    }

    public static void inOrder(Node root, StringBuilder s) {
        if(root.left != null) inOrder(root.left, s);
        s.append(root.data);
        if(root.right != null) inOrder(root.right, s);
    }

    public static void postOrder(Node root, StringBuilder s) {
        if(root.left != null) postOrder(root.left, s);
        if(root.right != null) postOrder(root.right, s);
        s.append(root.data);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node("A");
        String buf;
        for(int i = 0; i<N; i++) {
            buf = br.readLine();
            if(!buf.split(" ")[1].equals("."))
                root.setData(buf.split(" ")[0], buf.split(" ")[1], true);
            if(!buf.split(" ")[2].equals("."))
                root.setData(buf.split(" ")[0], buf.split(" ")[2], false);
        }
        
        StringBuilder sb = new StringBuilder();

        preOrder(root, sb);
        sb.append("\n");
        inOrder(root, sb);
        sb.append("\n");
        postOrder(root, sb);
        sb.append("\n");

        System.out.print(sb.toString());
    }
}
