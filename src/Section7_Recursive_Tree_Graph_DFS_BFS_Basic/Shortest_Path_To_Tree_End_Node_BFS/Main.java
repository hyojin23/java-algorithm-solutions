package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_BFS;

import java.util.Queue;
import java.util.LinkedList;

class Node {

    int data;
    Node lt, rt;

    public Node(int val) {
        this.data = val;
        lt = rt = null;
    }
}
public class Main {

    Node root;

    public int BFS(Node node) {

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int L = 0;

        while (!q.isEmpty()) {

            int len = q.size();

            for (int i = 0; i < len; i++) {

                Node cur = q.poll();

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

        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.BFS(tree.root));
    }
}
