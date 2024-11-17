package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_DFS;

class Node_5th {

    int data;
    Node_5th lt, rt;

    Node_5th(int val) {
        this.data = val;
        this.lt = null;
        this.rt = null;
    }
}

public class Main_5th {

    Node_5th root;
    static int answer = Integer.MAX_VALUE;

    public int DFS(Node_5th root, int L) {

        if (root.lt == null && root.rt == null) {
            return L;
        }
        else {
            return Math.min(DFS(root.lt, L + 1), DFS(root.rt, L + 1));
        }
    }

    public static void main(String[] args) {

        Main_5th tree = new Main_5th();
        tree.root = new Node_5th(1);
        tree.root.lt = new Node_5th(2);
        tree.root.rt = new Node_5th(3);
        tree.root.lt.lt = new Node_5th(4);
        tree.root.lt.rt = new Node_5th(5);

        System.out.println(tree.DFS(tree.root, 0));;
    }
}
