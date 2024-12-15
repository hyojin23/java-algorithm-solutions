package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Level_Search;

import java.util.Queue;
import java.util.LinkedList;

class Node_6th {

    int data;
    Node_6th lt, rt;

    Node_6th(int val) {
        data = val;
        this.lt = null;
        this.rt = null;
    }
}

public class Main_6th {

    Node_6th root;

    public void BFS(Node_6th root) {

        Queue<Node_6th> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            //System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node_6th node = q.poll();
                System.out.print(node.data + " ");
                if (node.lt != null) {
                    q.offer(node.lt);
                }
                if (node.rt != null) {
                    q.offer(node.rt);
                }
            }
            //System.out.println();
            L++;
        }
    }

    public static void main(String[] args) {

        Main_6th tree = new Main_6th();
        tree.root = new Node_6th(1);
        tree.root.lt = new Node_6th(2);
        tree.root.rt = new Node_6th(3);
        tree.root.lt.lt = new Node_6th(4);
        tree.root.lt.rt = new Node_6th(5);
        tree.root.rt.lt = new Node_6th(6);
        tree.root.rt.rt = new Node_6th(7);

        tree.BFS(tree.root);
    }
}
