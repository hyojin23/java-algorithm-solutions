package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_Graph_BFS;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static List<List<Integer>> graph;
    static int[] dis, ch;

    public int[] BFS(int v) {

        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        q.offer(v);
        int L = 1;
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                for (int nv : graph.get(cur)) {
                    if (ch[nv] == 0) {
                        ch[nv] = 1;
                        q.offer(nv);
                        dis[nv] = L;
                    }
                }
            }
            L++;
        }
        return dis;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        dis = new int[n + 1];
        ch = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
