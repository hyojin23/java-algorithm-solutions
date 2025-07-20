package BOJ.BOJ1068;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static int root, deleteNode, leafNodeCnt;
    static List<List<Integer>> graph;


    public void makeTree(int N, int[] arr) {

        for (int i = 0; i < N; i++) {
            if (arr[i] == -1) {
                root = i;
            }
            else {
                graph.get(arr[i]).add(i);
            }
        }
    }

    public void DFS(int root) {

        if (root == deleteNode) {
            return;
        }
        int childCount = 0;
        for (int child : graph.get(root)) {
            if (child != deleteNode) {
                childCount++;
                DFS(child);
            }
        }
        if (childCount == 0) {
            leafNodeCnt++;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        deleteNode = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        T.makeTree(N, arr);
        T.DFS(root);
        System.out.println(leafNodeCnt);
    }
}
