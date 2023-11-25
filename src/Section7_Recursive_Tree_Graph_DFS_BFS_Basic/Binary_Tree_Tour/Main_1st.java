package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Tour;

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
    public void DFS(Node_1st root) {
        if (root == null) {
            return;
        }
        else {
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
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
        tree.DFS(tree.root);
    }
}


