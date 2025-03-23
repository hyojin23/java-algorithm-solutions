package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Tour;

class Node_7th {

    int data;
    Node_7th lt, rt;

    Node_7th(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main_7th {

    Node_7th root;

    public void DFS(Node_7th root) {

        if (root == null) {
            return;
        }
        else {
            //System.out.print(root.data + " ");    전위순회
            DFS(root.lt);
            //System.out.print(root.data + " ");    중위순회
            DFS(root.rt);
            System.out.print(root.data + " ");      //후위순회
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

        tree.DFS(tree.root);
    }
}
