package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_DFS;

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
    static int answer = Integer.MAX_VALUE;

    public void DFS(Node_7th root, int L) {

        if (root.lt == null && root.rt == null) {
            answer = Math.min(answer, L);
        }
        else {
            DFS(root.lt, L + 1);
            DFS(root.rt, L + 1);
        }
    }

    public static void main(String[] args) {

        Main_7th tree = new Main_7th();
        tree.root = new Node_7th(1);
        tree.root.lt = new Node_7th(2);
        tree.root.rt = new Node_7th(3);
        tree.root.lt.lt = new Node_7th(4);
        tree.root.lt.rt = new Node_7th(5);

        tree.DFS(tree.root, 0);
        System.out.println(answer);
    }
}
