package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_DFS;

class Node_6th {

    int data;
    Node_6th lt, rt;

    Node_6th(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main_6th {

    Node_6th root;

    public int DFS(Node_6th root, int L) {

        if (root.lt == null && root.rt == null) {
            return L;
        }
        else {
            return Math.min(DFS(root.lt, L + 1), DFS(root.rt, L + 1));
        }
    }


    public static void main(String[] args) {

        Main_6th tree = new Main_6th();
        tree.root = new Node_6th(1);
        tree.root.lt = new Node_6th(2);
        tree.root.rt = new Node_6th(3);
        tree.root.lt.lt = new Node_6th(4);
        tree.root.lt.rt = new Node_6th(5);

        System.out.println(tree.DFS(tree.root, 0));
    }
}
