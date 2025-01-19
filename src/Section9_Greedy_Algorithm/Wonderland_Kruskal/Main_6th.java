package Section9_Greedy_Algorithm.Wonderland_Kruskal;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Edge_6th implements Comparable<Edge_6th> {

    int v1, v2, cost;

    Edge_6th(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_6th ob) {
        return this.cost - ob.cost;
    }
}

public class Main_6th {

    static int[] unf;

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static int Find(int v) {
        if (v == unf[v]) {
            return v;
        }
        else {
            return unf[v] = Find(unf[v]);
        }
    }

    public int solution(List<Edge_6th> graph) {

        Collections.sort(graph);

        int sum = 0;
        for (Edge_6th edge : graph) {
            int fv1 = Find(edge.v1);
            int fv2 = Find(edge.v2);

            if (fv1 != fv2) {
                Union(edge.v1, edge.v2);
                sum += edge.cost;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        List<Edge_6th> graph = new ArrayList<>();
        unf = new int[v + 1];

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.add(new Edge_6th(a, b, c));
        }

        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }

        System.out.println(T.solution(graph));
    }
}
