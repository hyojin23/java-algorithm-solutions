package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_DFS;

class Node {

    int data;
    Node lt, rt;

    public Node(int val) {
        this.data = val;
        lt = rt = null;
    }
}
public class Main {

    Node root;
    public int DFS(int L, Node node) {

        if (node.lt == null && node.rt == null) {
            return L;
        }
        else {
            return Math.min(DFS(L + 1, node.lt), DFS(L + 1, node.rt));
        }
    }

    public static void main(String[] args) {

        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.DFS(0, tree.root));
    }
}
