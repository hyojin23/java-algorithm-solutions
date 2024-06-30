package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Tour;

class Node_2nd {

    int data;
    Node_2nd lt, rt;

    public Node_2nd(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main_2nd {

    Node_2nd root;

    public void DFS(Node_2nd root) {

        if (root == null) {
            return;
        }
        else {
            // 전위순회
            // System.out.print(root.data + " ");
            DFS(root.lt);
            // 중위순회
            // System.out.print(root.data + " ");
            DFS(root.rt);
            // 후위순회
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {

        Main_2nd tree = new Main_2nd();
        tree.root = new Node_2nd(1);
        tree.root.lt = new Node_2nd(2);
        tree.root.rt = new Node_2nd(3);
        tree.root.lt.lt = new Node_2nd(4);
        tree.root.lt.rt = new Node_2nd(5);
        tree.root.rt.lt = new Node_2nd(6);
        tree.root.rt.rt = new Node_2nd(7);

        tree.DFS(tree.root);
    }
}
