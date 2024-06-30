package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_Graph_BFS;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main_2nd {

    static List<List<Integer>> graph;
    static int[] dis;
    static int[] ch;

    public void BFS() {

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        ch[1] = 1;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cv = q.poll();
                for (int nv : graph.get(cv)) {

                    if (ch[nv] == 0) {
                        ch[nv] = 1;
                        q.offer(nv);
                        dis[nv] = dis[cv] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
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

        T.BFS();

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
