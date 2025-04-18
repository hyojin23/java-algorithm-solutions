package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Level_Search;

import java.util.Queue;
import java.util.LinkedList;

class Node {

    Node lt, rt;
    int data;

    Node(int val) {
        data = val;
    }
}

public class Main {

    Node root;

    public void BFS(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
//            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                System.out.print(node.data + " ");
                if (node.lt != null) {
                    q.offer(node.lt);
                }
                if (node.rt != null) {
                    q.offer(node.rt);
                }
            }
//            System.out.println();
            L++;
        }
    }

    public static void main(String[] args) {

        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
