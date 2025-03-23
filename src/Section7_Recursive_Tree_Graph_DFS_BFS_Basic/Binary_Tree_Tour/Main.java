package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Tour;

class Node {

    Node lt, rt;
    int data;

    Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main {

    Node root;

    public void DFS(Node node) {
        if (node == null) {
            return;
        }
        else {
            System.out.print(node.data + " ");
            DFS(node.lt);
            DFS(node.rt);
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
        tree.DFS(tree.root);
    }
}
