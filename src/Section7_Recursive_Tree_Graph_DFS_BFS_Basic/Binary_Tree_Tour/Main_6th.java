package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Tour;

class Node_6th {

    int data;
    Node_6th lt, rt;

    Node_6th(int val) {
        this.data = val;
        lt = null;
        rt = null;
    }
}

public class Main_6th {

    Node_6th root;

    public void DFS(Node_6th root) {

        if (root == null) {
            return;
        }
        else {
            System.out.print(root.data + " ");
            DFS(root.lt);
//            System.out.print(root.data + " ");
            DFS(root.rt);
//            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Main_6th tree = new Main_6th();
        tree.root = new Node_6th(1);
        tree.root.lt = new Node_6th(2);
        tree.root.rt = new Node_6th(3);
        tree.root.lt.lt = new Node_6th(4);
        tree.root.lt.rt = new Node_6th(5);
        tree.root.rt.lt = new Node_6th(6);
        tree.root.rt.rt = new Node_6th(7);

        tree.DFS(tree.root);
    }
}
