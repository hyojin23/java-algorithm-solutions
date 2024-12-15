package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_BFS;

import java.util.Queue;
import java.util.LinkedList;

class Node_6th {

    int data;
    Node_6th lt, rt;

    Node_6th(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main_6th {

    Node_6th root;

    public int BFS(Node_6th root) {

        Queue<Node_6th> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node_6th node = q.poll();
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

        Main_6th tree = new Main_6th();
        tree.root = new Node_6th(1);
        tree.root.lt = new Node_6th(2);
        tree.root.rt = new Node_6th(3);
        tree.root.lt.lt = new Node_6th(4);
        tree.root.lt.rt = new Node_6th(5);

        System.out.println(tree.BFS(tree.root));
    }
}
