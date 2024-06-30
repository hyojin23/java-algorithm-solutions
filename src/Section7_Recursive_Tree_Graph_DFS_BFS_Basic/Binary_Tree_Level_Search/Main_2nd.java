package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Level_Search;

import java.util.Queue;
import java.util.LinkedList;

class Node_2nd {

    Node_2nd lt, rt;
    int data;

    public Node_2nd(int val) {
        this.data = val;
        this.lt = null;
        this.rt = null;
    }
}
public class Main_2nd {

    Node_2nd root;

    public void BFS(Node_2nd root) {
        Queue<Node_2nd> q = new LinkedList<>();
        q.offer(root);

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(L + ": ");
            for (int i = 0; i < len; i++) {
                Node_2nd cur = q.poll();
                System.out.print(cur.data + " ");

                if (cur.lt != null) q.offer(cur.lt);
                if (cur.rt != null) q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Main_2nd tree = new Main_2nd();

        tree.root = new Node_2nd(1);
        tree.root.lt = new Node_2nd(2);
        tree.root.rt = new Node_2nd(3);
        tree.root.lt.lt = new Node_2nd(4);
        tree.root.lt.rt = new Node_2nd(5);
        tree.root.rt.lt = new Node_2nd(6);
        tree.root.rt.rt = new Node_2nd(7);

       tree.BFS(tree.root);
    }
}
