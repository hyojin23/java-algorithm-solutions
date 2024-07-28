package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_BFS;

import java.util.Queue;
import java.util.LinkedList;

class Node_3rd {

    int data;
    Node_3rd lt;
    Node_3rd rt;

    public Node_3rd(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}
public class Main_3rd {

    Node_3rd root;

    public int BFS(Node_3rd root) {

        Queue<Node_3rd> q = new LinkedList<>();
        q.offer(root);
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node_3rd cur = q.poll();

                if (cur.lt == null && cur.rt == null) {
                    return L;
                }
                else {
                    if (cur.lt != null) {
                        q.offer(cur.lt);
                    }

                    if (cur.rt != null) {
                        q.offer(cur.rt);
                    }
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {

        Main_3rd tree = new Main_3rd();
        tree.root = new Node_3rd(1);
        tree.root.lt = new Node_3rd(2);
        tree.root.rt = new Node_3rd(3);
        tree.root.lt.lt = new Node_3rd(4);
        tree.root.lt.rt = new Node_3rd(5);

        System.out.println(tree.BFS(tree.root));
    }
}
