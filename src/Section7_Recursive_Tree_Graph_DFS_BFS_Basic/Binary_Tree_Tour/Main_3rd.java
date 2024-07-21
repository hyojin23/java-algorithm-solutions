package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Binary_Tree_Tour;

class Node_3rd {

    int data;
    Node_3rd lt, rt;

    public Node_3rd(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main_3rd {

    Node_3rd root;

    public void DFS(Node_3rd root) {

        if (root == null) {
            return;
        }
        else {
            // 전위순회
//            System.out.print(root.data + " ");
//            DFS(root.lt);
//            DFS(root.rt);

            // 중위순회
//            DFS(root.lt);
//            System.out.print(root.data + " ");
//            DFS(root.rt);

            // 후위순회
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {

        Main_3rd tree = new Main_3rd();

        tree.root = new Node_3rd(1);
        tree.root.lt = new Node_3rd(2);
        tree.root.rt = new Node_3rd(3);
        tree.root.lt.lt = new Node_3rd(4);
        tree.root.lt.rt = new Node_3rd(5);
        tree.root.rt.lt = new Node_3rd(6);
        tree.root.rt.rt = new Node_3rd(7);
        tree.DFS(tree.root);
    }
}