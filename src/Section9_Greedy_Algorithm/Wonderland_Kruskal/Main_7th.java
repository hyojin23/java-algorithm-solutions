package Section9_Greedy_Algorithm.Wonderland_Kruskal;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Edge_7th implements Comparable<Edge_7th> {

    int v1, v2, cost;

    Edge_7th(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_7th ob) {
        return this.cost - ob.cost;
    }
}

public class Main_7th {

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

    public int solution(List<Edge_7th> graph) {

        Collections.sort(graph);
        int sum = 0;
        for (Edge_7th e : graph) {
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

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);
        List<Edge_7th> graph = new ArrayList<>();
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
            graph.add(new Edge_7th(v1, v2, cost));
        }
        System.out.println(T.solution(graph));
    }
}
