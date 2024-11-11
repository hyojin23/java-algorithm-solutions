package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Tour;

class Node_5th {

    int data;
    Node_5th lt, rt;

    Node_5th(int val) {
        this.data = val;
        lt = null;
        rt = null;
    }
}

public class Main_5th {

    Node_5th root;
    public void DFS(Node_5th root) {

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

        Main_5th tree = new Main_5th();

        tree.root = new Node_5th(1);
        tree.root.lt = new Node_5th(2);
        tree.root.rt = new Node_5th(3);
        tree.root.lt.lt = new Node_5th(4);
        tree.root.lt.rt = new Node_5th(5);
        tree.root.rt.lt = new Node_5th(6);
        tree.root.rt.rt = new Node_5th(7) ;

        tree.DFS(tree.root);
    }
}
