package BOJ.BOJ1707;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static List<List<Integer>> graph;
    static int[] color;


    public boolean BFS(int start) {

        Queue<Integer> q =  new LinkedList<>();
        q.offer(start);
        color[start] = 1;
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : graph.get(current)) {
                if (color[next] == 0) {
                    color[next] = -color[current];
                    q.offer(next);
                }
                else if (color[next] == color[current]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            graph = new ArrayList<>();
            color = new int[V + 1];
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < E; j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            boolean isBipartite = true;
            for (int j = 1; j <= V; j++) {
                if (color[j] == 0) {
                    if (!T.BFS(j)) {
                        isBipartite = false;
                        break;
                    }
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }
}
