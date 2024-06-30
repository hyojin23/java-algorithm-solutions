package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_DFS;

class Node_2nd {

    int data;
    Node_2nd lt, rt;

    public Node_2nd(int val) {
        this.data = val;
        lt = rt = null;
    }
}
public class Main_2nd {

    Node_2nd root;
    public int DFS(int L, Node_2nd node) {

        if (node.lt == null && node.rt == null) {
            return L;
        }
        else {
            return Math.min(DFS(L + 1, node.lt), DFS(L + 1, node.rt));
        }
    }

    public static void main(String[] args) {

        Main_2nd tree = new Main_2nd();
        tree.root = new Node_2nd(1);
        tree.root.lt = new Node_2nd(2);
        tree.root.rt = new Node_2nd(3);
        tree.root.lt.lt = new Node_2nd(4);
        tree.root.lt.rt = new Node_2nd(5);

        System.out.println(tree.DFS(0, tree.root));
    }
}
