package BOJ.BOJ18352;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {

    static int N, M, K, X;
    static int[] dis;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public String BFS(int start) {

        Queue<Integer> q = new LinkedList<>();
        visited[X] = true;
        dis[X] = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dis[next] = dis[current] + 1;
                    q.offer(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dis[i] == K) {
                sb.append(i).append('\n');
            }
        }
        if (sb.length() == 0) {
            sb.append(-1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        dis = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph.get(A).add(B);
        }
        System.out.println(T.BFS(X));
    }
}
