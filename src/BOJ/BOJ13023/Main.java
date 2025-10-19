package BOJ.BOJ13023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int answer = 0;

    public void DFS(int L, int node) {

        if (answer == 1) {
            return;
        }

        if (L == 4) {
            answer = 1;
        }
        else {
            for (int to : graph.get(node)) {
                if (!visited[to]) {
                    visited[to] = true;
                    DFS(L + 1, to);
                    visited[to] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        answer = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            T.DFS(0, i);
            visited[i] = false;
            if (answer == 1) {
                break;
            }
        }
        System.out.println(answer);
    }
}
