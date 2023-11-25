package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Level_Search;

import java.util.Queue;
import java.util.LinkedList;

class Node {

    Node lt, rt;
    int data;

    public Node(int val) {
        this.data = val;
        this.lt = null;
        this.rt = null;
    }
}
public class Main {

    Node root;

    public void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(L + ": ");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.data + " ");

                if (cur.lt != null) q.offer(cur.lt);
                if (cur.rt != null) q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

       tree.BFS(tree.root);
    }
}
