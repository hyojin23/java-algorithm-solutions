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
    static int answer = Integer.MAX_VALUE;
    public void DFS(int L, Node node) {

        if (node.lt == null && node.rt == null) {
            answer = Math.min(answer, L);
        }
        else if (node.lt != null && node.rt != null) {
            DFS(L + 1, node.lt);
            DFS(L + 1, node.rt);
        }
    }


    public static void main(String[] args) {

        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.DFS(0, tree.root);
        System.out.println(answer);
    }
}
