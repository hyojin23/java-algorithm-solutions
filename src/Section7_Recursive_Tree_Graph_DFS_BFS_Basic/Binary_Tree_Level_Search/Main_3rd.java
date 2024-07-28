package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Level_Search;

import java.util.Queue;
import java.util.LinkedList;

class Node_3rd {

    int data;
    Node_3rd lt, rt;

    public Node_3rd(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}

public class Main_3rd {

    Node_3rd root;

    public void BFS(Node_3rd root) {

        Queue<Node_3rd> q = new LinkedList<>();
        q.offer(root);
        int L = 0;

        while (!q.isEmpty()) {

            int len = q.size();

            for (int i = 0 ; i < len; i++) {
                Node_3rd node = q.poll();

                if (node.lt != null) {
                    q.offer(node.lt);
                }

                if (node.rt != null) {
                    q.offer(node.rt);
                }

                System.out.print(node.data + " ");
            }
        }
    }

    public static void main(String[] args) {

        Main_3rd tree = new Main_3rd();

        tree.root = new Node_3rd(1);
        tree.root.lt = new Node_3rd(2);
        tree.root.rt = new Node_3rd(3);
        tree.root.lt.lt = new Node_3rd(4);
        tree.root.lt.rt = new Node_3rd(5);
        tree.root.rt.lt = new Node_3rd(6);
        tree.root.rt.rt = new Node_3rd(7);

        tree.BFS(tree.root);
    }
}
