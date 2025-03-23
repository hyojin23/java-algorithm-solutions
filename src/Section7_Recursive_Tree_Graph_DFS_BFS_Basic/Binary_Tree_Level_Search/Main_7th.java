package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Level_Search;

import java.util.Queue;
import java.util.LinkedList;

class Node_7th {

    int data;
    Node_7th lt, rt;

    Node_7th(int val) {
        data = val;
        lt = null;
        rt = null;
    }

    @Override
    public String toString() {
        return "" + data;
    }

}

public class Main_7th {

    Node_7th root;

    public void BFS(Node_7th root) {

        Queue<Node_7th> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node_7th cur = q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) {
                    q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    q.offer(cur.rt);
                }
            }
            System.out.println();
            L++;
        }
    }


    public static void main(String[] args) {

        Main_7th tree = new Main_7th();
        tree.root = new Node_7th(1);
        tree.root.lt = new Node_7th(2);
        tree.root.rt = new Node_7th(3);
        tree.root.lt.lt = new Node_7th(4);
        tree.root.lt.rt = new Node_7th(5);
        tree.root.rt.lt = new Node_7th(6);
        tree.root.rt.rt = new Node_7th(7);

        tree.BFS(tree.root);
    }
}
