package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_DFS;

class Node_3rd {

    int data;
    Node_3rd lt;
    Node_3rd rt;

    public Node_3rd(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}
public class Main_3rd {

    Node_3rd root;

    public int DFS(Node_3rd root, int L) {

        if (root.lt == null && root.rt == null) {
            return L;
        }
        else {
            return Math.min(DFS(root.lt, L + 1), DFS(root.rt, L + 1));
        }
    }

    public static void main(String[] args) {

        Main_3rd tree = new Main_3rd();
        tree.root = new Node_3rd(1);
        tree.root.lt = new Node_3rd(2);
        tree.root.rt = new Node_3rd(3);
        tree.root.lt.lt = new Node_3rd(4);
        tree.root.lt.rt = new Node_3rd(5);

        System.out.println(tree.DFS(tree.root, 0));
    }
}
