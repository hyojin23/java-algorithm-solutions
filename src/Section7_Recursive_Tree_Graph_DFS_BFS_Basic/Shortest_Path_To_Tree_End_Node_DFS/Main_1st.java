package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_DFS;

class Node_1st {

    int data;
    Node_1st lt, rt;

    public Node_1st(int val) {
        this.data = val;
        lt = rt = null;
    }
}
public class Main_1st {

    Node_1st root;
    public int DFS(int L, Node_1st root) {
        if (root.lt == null && root.rt == null)
            return L;
        else
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
    }

    public static void main(String[] args) {

        Main_1st tree = new Main_1st();
        tree.root = new Node_1st(1);
        tree.root.lt = new Node_1st(2);
        tree.root.rt = new Node_1st(3);
        tree.root.lt.lt = new Node_1st(4);
        tree.root.lt.rt = new Node_1st(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
