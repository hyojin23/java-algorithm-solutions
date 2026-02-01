package BOJ.BOJ1516;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static int[] solution(int N, List<List<Integer>> graph, int[] times, int[] indegree) {

        int[] dp = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int bd = 1; bd <= N; bd++) {
            if (indegree[bd] == 0) {
                q.offer(bd);
                dp[bd] = times[bd];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[cur] + times[next]);
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }

        }

        return dp;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        int[] times = new int[N + 1];
        int[] indegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int bd = 1; bd <= N; bd++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[bd] = Integer.parseInt(st.nextToken());;
            int req;
            while ((req = Integer.parseInt(st.nextToken())) != -1) {
                graph.get(req).add(bd);
                indegree[bd]++;
            }
        }

        int[] answer = solution(N, graph, times, indegree);

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
}
