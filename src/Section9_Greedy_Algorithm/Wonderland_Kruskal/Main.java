package Section9_Greedy_Algorithm.Wonderland_Kruskal;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {

    int v1, v2, cost;

    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Main {

    static int[] unf;
    public static int Find(int v) {
        if (v == unf[v]) {
            return v;
        }
        else {
            return unf[v] =Find(unf[v]);
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public int solution(List<Edge> graph) {

        Collections.sort(graph);
        int sum = 0;
        for (Edge e : graph) {
            int fv1 = Find(e.v1);
            int fv2 = Find(e.v2);
            if (fv1 != fv2) {
                Union(e.v1, e.v2);
                sum += e.cost;
            }
        }
        return sum;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        List<Edge> graph = new ArrayList<>();
        int v = sc.nextInt();
        int e = sc.nextInt();
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph.add(new Edge(v1, v2, cost));
        }
        System.out.println(T.solution(graph));
    }
}
