package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Level_Search;

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

    public void BFS(Node_4th root) {

        Queue<Node_4th> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node_4th node = q.poll();
                System.out.print(node.data + " ");

                if (node.lt != null) {
                    q.offer(node.lt);
                }

                if (node.rt != null) {
                    q.offer(node.rt);
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_4th tree = new Main_4th();

        tree.root = new Node_4th(1);
        tree.root.lt = new Node_4th(2);
        tree.root.rt = new Node_4th(3);
        tree.root.lt.lt = new Node_4th(4);
        tree.root.lt.rt = new Node_4th(5);
        tree.root.rt.lt = new Node_4th(6);
        tree.root.rt.rt = new Node_4th(7);

        tree.BFS(tree.root);
    }
}
