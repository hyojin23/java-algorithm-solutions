package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_BFS;

import java.util.Queue;
import java.util.LinkedList;

class Node {

    int data;
    Node lt, rt;

    Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main {

    Node root;

    public int BFS(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                if (node.lt == null && node.rt == null) {
                    return L;
                }
                if (node.lt != null) {
                    q.offer(node.lt);
                }
                if (node.rt != null) {
                    q.offer(node.rt);
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
