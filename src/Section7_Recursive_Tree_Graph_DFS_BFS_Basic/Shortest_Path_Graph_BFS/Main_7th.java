package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_Graph_BFS;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main_7th {

    static int n, m;
    static int[] ch, dis;
    static List<List<Integer>> graph;

    public void BFS(int v) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()) {
            int len = q.size();
            for  (int i = 0; i < len; i++) {
                int cur = q.poll();
                for (int x : graph.get(cur)) {
                    if (ch[x] == 0) {
                        ch[x] = 1;
                        dis[x] = dis[cur] + 1;
                        q.offer(x);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
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

        ch[1] = 1;
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
