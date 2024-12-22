package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_Graph_BFS;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main_6th {

    static List<List<Integer>> graph;
    static int[] ch, answer;

    public void BFS(int v) {

        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        q.offer(v);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                answer[cur] = L;
                for (int x : graph.get(cur)) {
                    if (ch[x] == 0) {
                        ch[x] = 1;
                        q.offer(x);
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<>();
        answer = new int[n + 1];
        ch = new int[n + 1];

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
            System.out.println(i + " : " + answer[i]);
        }
    }
}
