package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Tour;

class Node_4th {

    int data;
    Node_4th lt, rt;

    public Node_4th(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main_4th {

    public void DFS(Node_4th root) {

        if (root == null) {
            return;
        }
        else {
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();

        Node_4th root = new Node_4th(1);

        root.lt = new Node_4th(2);
        root.rt = new Node_4th(3);
        root.lt.lt = new Node_4th(4);
        root.lt.rt = new Node_4th(5);
        root.rt.lt = new Node_4th(6);
        root.rt.rt = new Node_4th(7);

        T.DFS(root);
    }
}
