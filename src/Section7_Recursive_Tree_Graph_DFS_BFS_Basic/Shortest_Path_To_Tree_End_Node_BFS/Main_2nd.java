package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_BFS;

import java.util.Queue;
import java.util.LinkedList;

class Node_2nd {

    int data;
    Node_2nd lt, rt;

    public Node_2nd(int val) {
        this.data = val;
        lt = rt = null;
    }
}
public class Main_2nd {

    Node_2nd root;

    public int BFS(Node_2nd node) {

        Queue<Node_2nd> q = new LinkedList<>();
        q.offer(node);
        int L = 0;

        while (!q.isEmpty()) {

            int len = q.size();

            for (int i = 0; i < len; i++) {

                Node_2nd cur = q.poll();

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
        return L;
    }

    public static void main(String[] args) {

        Main_2nd tree = new Main_2nd();
        tree.root = new Node_2nd(1);
        tree.root.lt = new Node_2nd(2);
        tree.root.rt = new Node_2nd(3);
        tree.root.lt.lt = new Node_2nd(4);
        tree.root.lt.rt = new Node_2nd(5);

        System.out.println(tree.BFS(tree.root));
    }
}
