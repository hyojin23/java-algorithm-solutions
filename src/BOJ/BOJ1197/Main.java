package BOJ.BOJ1197;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

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

    static int V, E;
    static List<List<Node>> graph;
    static boolean[] visited;

    public int solution(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int sum = 0;
        int edgeCount = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visited[cur.vex]) {
                visited[cur.vex] = true;
                sum += cur.cost;
                if (cur.vex != start) {
                    edgeCount++;
                }
                if (edgeCount == V - 1) {
                    break;
                }
                for (Node to : graph.get(cur.vex)) {
                    if (!visited[to.vex]) {
                        pq.offer(new Node(to.vex, to.cost));
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        visited = new boolean[V + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        System.out.println(T.solution(1));
    }
}
