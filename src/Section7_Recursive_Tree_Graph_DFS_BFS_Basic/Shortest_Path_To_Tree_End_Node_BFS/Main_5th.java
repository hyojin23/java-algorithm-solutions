package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_BFS;

import java.util.Queue;
import java.util.LinkedList;

class Node_5th {

    Node_5th lt, rt;
    int data;

    Node_5th(int val) {
        this.data = val;
        lt = null;
        rt = null;
    }
}

public class Main_5th {

    Node_5th root;

    public int BFS(Node_5th root) {

        Queue<Node_5th> q = new LinkedList<>();
        q.offer(root);

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node_5th cur = q.poll();
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
        return 0;
    }


    public static void main(String[] args) {

        Main_5th tree = new Main_5th();

        tree.root = new Node_5th(1);
        tree.root.lt = new Node_5th(2);
        tree.root.rt = new Node_5th(3);
        tree.root.lt.lt = new Node_5th(4);
        tree.root.lt.rt = new Node_5th(5);

        System.out.println(tree.BFS(tree.root));
    }
}
