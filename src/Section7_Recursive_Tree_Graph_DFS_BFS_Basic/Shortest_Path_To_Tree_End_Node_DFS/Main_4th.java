package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_To_Tree_End_Node_DFS;



class Node_4th {

    int data;
    Node_4th lt, rt;

    Node_4th(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main_4th {

    Node_4th root;
    static int answer = Integer.MAX_VALUE;
    public void DFS(int L, Node_4th node) {

        if (node.lt == null && node.rt == null) {
            answer = Math.min(answer, L);
        }
        else if (node.lt != null && node.rt != null) {
            DFS(L + 1, node.lt);
            DFS(L + 1, node.rt);
        }
    }


    public static void main(String[] args) {

        Main_4th tree = new Main_4th();
        tree.root = new Node_4th(1);
        tree.root.lt = new Node_4th(2);
        tree.root.rt = new Node_4th(3);
        tree.root.lt.lt = new Node_4th(4);
        tree.root.lt.rt = new Node_4th(5);

        tree.DFS(0, tree.root);
        System.out.println(answer);
    }
}
