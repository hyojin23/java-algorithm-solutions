package BOJ.BOJ2623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public void solution(int N, List<List<Integer>> graph, int[] indegree) {

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append("\n");
            count++;
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (count == N) {
            System.out.println(sb);
        }
        else {
            System.out.println(0);
        }
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt == 0) {
                continue;
            }
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt - 1; j++) {
                int cur = Integer.parseInt(st.nextToken());
                graph.get(prev).add(cur);
                indegree[cur]++;
                prev = cur;
            }
        }
        main.solution(N, graph, indegree);
    }
}
