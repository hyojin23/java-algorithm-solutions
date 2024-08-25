package Section9_Greedy_Algorithm.Wonderland_Prim;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

    int vex, cost;

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Main {

    static int[] ch;

    public int solution(List<List<Edge>> list) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        int answer = 0;

        while (!pq.isEmpty()) {

            Edge e1 = pq.poll();

            if (ch[e1.vex] == 0) {
                answer += e1.cost;
                ch[e1.vex] = 1;

                for (Edge e2 : list.get(e1.vex)) {
                    if (ch[e2.vex] == 0) {
                        pq.offer(e2);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        List<List<Edge>> list = new ArrayList<>();
        ch = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            list.get(v1).add(new Edge(v2, cost));
            list.get(v2).add(new Edge(v1, cost));
        }

        System.out.println(T.solution(list));
    }
}
