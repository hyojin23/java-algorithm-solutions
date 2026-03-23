package BOJ.BOJ1916;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Node_1st implements Comparable<Node_1st> {

    int vex, cost;

    Node_1st(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node_1st ob) {
        return this.cost - ob.cost;
    }
}

public class Main_1st {

    static int N, M, S, E;
    static List<List<Node_1st>> graph;
    static int[] cost;

    public int solution(int startVex) {

        PriorityQueue<Node_1st> pq = new PriorityQueue<>();
        Arrays.fill(cost, Integer.MAX_VALUE);
        pq.offer(new Node_1st(startVex, 0));
        while (!pq.isEmpty()) {
            Node_1st cur = pq.poll();
            int nowVex = cur.vex;
            int nowCost = cur.cost;
            if (nowCost > cost[nowVex]) {
                continue;
            }
            for (Node_1st node : graph.get(nowVex)) {
                int newCost = nowCost + node.cost;
                if (newCost < cost[node.vex]) {
                    cost[node.vex] = newCost;
                    pq.offer(new Node_1st(node.vex, newCost));
                }
            }
        }
        return cost[E];
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        cost = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node_1st(b, c));
        }
        S = sc.nextInt();
        E = sc.nextInt();
        System.out.println(T.solution(S));
    }
}
