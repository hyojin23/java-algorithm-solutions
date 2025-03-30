package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_BFS;

import java.util.Queue;
import java.util.LinkedList;

class Node_7th {

    int data;
    Node_7th lt, rt;

    Node_7th(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main_7th {

    Node_7th root;

    public int BFS(Node_7th root) {

        Queue<Node_7th> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node_7th cur = q.poll();
                if (cur.lt == null && cur.rt == null) {
                    return L;
                }
                if (cur.lt != null) {
                    q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    q.offer(cur.rt);
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {

        Main_7th tree = new Main_7th();
        tree.root = new Node_7th(1);
        tree.root.lt = new Node_7th(2);
        tree.root.rt = new Node_7th(3);
        tree.root.lt.lt = new Node_7th(4);
        tree.root.lt.rt = new Node_7th(5);

        System.out.println(tree.BFS(tree.root));
    }
}
