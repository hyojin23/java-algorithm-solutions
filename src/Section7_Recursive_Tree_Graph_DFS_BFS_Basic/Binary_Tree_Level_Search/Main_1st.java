package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Level_Search;

import java.util.LinkedList;
import java.util.Queue;

class Node_1st {

    int data;
    Node_1st lt, rt;

    public Node_1st(int val) {
        data = val;
        lt = rt = null;
    }
}
public class Main_1st {

    Node_1st root;

    public void BFS(Node_1st root) {

        Queue<Node_1st> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while (!Q.isEmpty()) {

            int len = Q.size();
            System.out.print(L + " : ");

            for (int i = 0; i < len; i++) {
                Node_1st cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null)
                    Q.offer(cur.lt);
                if (cur.rt != null)
                    Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Main_1st tree = new Main_1st();
        tree.root = new Node_1st(1);
        tree.root.lt = new Node_1st(2);
        tree.root.rt = new Node_1st(3);
        tree.root.lt.lt = new Node_1st(4);
        tree.root.lt.rt = new Node_1st(5);
        tree.root.rt.lt = new Node_1st(6);
        tree.root.rt.rt = new Node_1st(7);
        tree.BFS(tree.root);
    }
}
