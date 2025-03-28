package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_BFS;

import java.util.Queue;
import java.util.LinkedList;

class Node_4th {

    int data;
    Node_4th lt, rt;

    Node_4th(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main_4th {

    Node_4th root;

    public int BFS(Node_4th root) {

        Queue<Node_4th> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {

                Node_4th cur = q.poll();

                if (cur.lt != null) {
                    q.offer(cur.lt);
                }

                if (cur.rt != null) {
                    q.offer(cur.rt);
                }

                if (cur.lt == null && cur.rt == null) {
                    return L;
                }
            }
            L++;
        }

        return 0;
    }

    public static void main(String[] args) {

        Main_4th tree = new Main_4th();
        tree.root = new Node_4th(1);
        tree.root.lt = new Node_4th(2);
        tree.root.rt = new Node_4th(3);
        tree.root.lt.lt = new Node_4th(4);
        tree.root.lt.rt = new Node_4th(5);

        System.out.println(tree.BFS(tree.root));
    }
}
