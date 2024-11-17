package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Level_Search;

import java.util.Queue;
import java.util.LinkedList;

class Node_5th {

    int data;
    Node_5th lt, rt;

    Node_5th(int val) {
        this.data = val;
        this.lt = null;
        this.rt = null;
    }
}
public class Main_5th {

    Node_5th root;

    public void BFS(Node_5th root) {

        Queue<Node_5th> q = new LinkedList<>();
        q.offer(root);

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node_5th node = q.poll();
                System.out.print(node.data + " ");

                if (node.lt != null) {
                    q.offer(node.lt);
                }

                if (node.rt != null) {
                    q.offer(node.rt);
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_5th tree = new Main_5th();

        tree.root = new Node_5th(1);
        tree.root.lt = new Node_5th(2);
        tree.root.rt = new Node_5th(3);
        tree.root.lt.lt = new Node_5th(4);
        tree.root.lt.rt = new Node_5th(5);
        tree.root.rt.lt = new Node_5th(6);
        tree.root.rt.rt = new Node_5th(7);

        tree.BFS(tree.root);
    }
}
