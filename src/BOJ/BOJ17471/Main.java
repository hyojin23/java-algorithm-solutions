package BOJ.BOJ17471;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph;
    static int N;

    public static int solution(int[] ppl) {

        int result = Integer.MAX_VALUE;

        for (int mask = 1; mask < (1 << N) - 1; mask++) {
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    A.add(i);
                }
                else {
                    B.add(i);
                }
            }

            if (isConnected(A) && isConnected(B)) {
                int sumA = 0;
                int sumB = 0;
                for (int a : A) {
                    sumA += ppl[a];
                }
                for (int b : B) {
                    sumB += ppl[b];
                }
                result = Math.min(result, Math.abs(sumA - sumB));
            }
        }
        return result;
    }

    public static boolean isConnected(List<Integer> group) {

        boolean[] isGroup = new boolean[N];
        for (int g : group) {
            isGroup[g] = true;
        }

        boolean[] visited = new boolean[N];
        dfs(group.get(0), visited, isGroup);

        for (int area : group) {
            if (!visited[area]) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int cur, boolean[] visited, boolean[] isGroup) {

        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (!visited[next] && isGroup[next]) {
                dfs(next, visited, isGroup);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] ppl = new int[N];
        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ppl[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int other = Integer.parseInt(st.nextToken()) - 1;   //0-based
                graph.get(i).add(other);
            }
        }

        int answer = solution(ppl);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }
    }
}
