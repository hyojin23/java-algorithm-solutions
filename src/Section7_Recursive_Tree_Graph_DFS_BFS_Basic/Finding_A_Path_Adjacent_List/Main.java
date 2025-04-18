package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Path_Adjacent_List;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static List<List<Integer>> graph;
    static int n, m, answer;
    static int[] ch;
    List<Integer> list = new ArrayList<>();

    public void DFS(int v) {
        if (v == n) {
            answer++;
        }
        else {
            for (int toV : graph.get(v)) {
                if (ch[toV] == 0) {
                    ch[toV] = 1;
                    DFS(toV);
                    ch[toV] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
