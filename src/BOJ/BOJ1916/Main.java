package BOJ.BOJ1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {

    int vex, cost;

    Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node ob) {
        return Integer.compare(this.cost, ob.cost);
    }
}

public class Main {

    static int N, M;

    public static int solution(List<List<Node>> graph, int s, int e) {

        int[] minCost = new int[N + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(s, 0));
        minCost[s] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int nowVex = cur.vex;
            int nowCost = cur.cost;

            if (nowCost > minCost[nowVex]) {
                continue;
            }

            for (Node next : graph.get(nowVex)) {
                int nextCost = nowCost + next.cost;
                if (nextCost < minCost[next.vex]) {
                    minCost[next.vex] = nextCost;
                    q.offer(new Node(next.vex, nextCost));
                }
            }
        }
        return minCost[e];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0 ; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(solution(graph, s, e));
    }
}
