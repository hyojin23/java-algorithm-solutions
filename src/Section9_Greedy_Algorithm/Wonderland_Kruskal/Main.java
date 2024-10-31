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

    static List<Edge> list;

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static int Find(int v) {
        if (unf[v] == v) {
            return v;
        }
        else {
            return unf[v] = Find(unf[v]);
        }
    }

    public int solution(int v, int e) {

        Collections.sort(list);

        int sum = 0;
        for (Edge edge : list) {
            int fa = Find(edge.v1);
            int fb = Find(edge.v2);
            if (fa != fb) {
                Union(edge.v1, edge.v2);
                sum += edge.cost;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        list = new ArrayList<>();
        unf = new int[v + 1];

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.add(new Edge(a, b, c));
        }

        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }

        System.out.println(T.solution(v, e));
    }
}
