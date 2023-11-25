package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

import java.util.*;

class Edge_1st implements Comparable<Edge_1st> {

    public int vex;
    public int cost;

    public Edge_1st(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_1st ob) {
        return this.cost - ob.cost;
    }
}
public class Main_1st {

    static int n, m;
    static List<ArrayList<Edge_1st>> graph;
    static int[] dis;

    public void solution(int v) {
        PriorityQueue<Edge_1st> pQ = new PriorityQueue<>();
        pQ.offer(new Edge_1st(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge_1st eg = pQ.poll();
            int now = eg.vex;
            int nowCost = eg.cost;

            if (nowCost > dis[now]) continue;

            for (Edge_1st ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge_1st(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<ArrayList<Edge_1st>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge_1st>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge_1st(b,c));
        }
        T.solution(1);
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            }
            else {
                System.out.println(i + " : " + "impossible");
            }
        }

    }
}
