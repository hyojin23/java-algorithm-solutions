package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_Graph_BFS;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main_4th {

    static int n;
    static List<List<Integer>> graph;
    static int[] dis;

    public int[] BFS(int v) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                for (int x : graph.get(cur)) {
                    if (dis[x] == 0) {
                        q.offer(x);
                        dis[x] = dis[cur] + 1;
                    }
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<>();
        dis = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

        dis[1] = 0;
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
