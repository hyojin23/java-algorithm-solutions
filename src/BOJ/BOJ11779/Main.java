package BOJ.BOJ11779;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Stack;

class Node implements Comparable<Node> {

    int vex, cost;

    Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node ob) {
        return this.cost - ob.cost;
    }
}

public class Main {

    static List<List<Node>> graph;
    static int[] cost, prev;

    public void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        prev[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int nowVex = cur.vex;
            int nowCost = cur.cost;

            if (nowCost > cost[nowVex]) {
                continue;
            }

            for (Node next : graph.get(nowVex)) {
                int newCost = nowCost + next.cost;
                if (newCost < cost[next.vex]) {
                    cost[next.vex] = newCost;
                    prev[next.vex] = nowVex;
                    pq.offer(new Node(next.vex, newCost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        cost = new int[n + 1];
        prev = new int[n + 1];
        graph = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, c));
        }

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        main.dijkstra(A);

        int cur = B;
        while (prev[cur] != 0) {
            stack.add(cur);
            cur = prev[cur];
        }
        stack.add(A);

        StringBuilder path = new StringBuilder();

        int cnt = stack.size();
        while (!stack.isEmpty()) {
            path.append(stack.pop()).append(" ");
        }

        System.out.println(cost[B]);
        System.out.println(cnt);
        System.out.println(path);
    }
}
