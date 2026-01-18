package BOJ.BOJ1939;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Node {

    int vex, weight;

    Node (int vex, int weight) {
        this.vex = vex;
        this.weight = weight;
    }
}

public class Main {

    static List<List<Node>> graph;
    static int start, end, answer;
    static boolean isSuccess;
    static boolean[] visited;

    public static void dfs(int vex, int mid) {

        if (isSuccess) {
            return;
        }

        visited[vex] = true;

        if (vex == end) {
            answer = mid;
            isSuccess = true;
        }
        else {
            for (Node node : graph.get(vex)) {
                if (visited[node.vex]) {
                    continue;
                }
                if (node.weight >= mid) {
                    dfs(node.vex, mid);
                }
            }
        }
    }

    public static int solution(int max) {

        int lt = 1;
        int rt = max;
        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            isSuccess = false;
            Arrays.fill(visited, false);

            dfs(start, mid);

            if (isSuccess) {
                lt = mid + 1;
            }
            else {
                rt = mid - 1;
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            max = Math.max(max, c);

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(solution(max));
    }
}
