package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_DFS;

class Node {

    int data;
    Node lt, rt;

    Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main {

    Node root;

    public int DFS(Node root, int L) {

        if (root.lt == null && root.rt == null) {
            return L;
        }
        else {
            return Math.min(DFS(root.lt, L + 1), DFS(root.rt, L + 1));
        }
    }


    public static void main(String[] args) {

        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.DFS(tree.root, 0));
    }
}
