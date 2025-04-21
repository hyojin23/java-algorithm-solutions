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

    public static void Union(int v1, int v2) {
        int fv1 = Find(v1);
        int fv2 = Find(v2);
        if (fv1 != fv2) {
            unf[fv1] = fv2;
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

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge(a, b, c));
        }
        Collections.sort(list);
        int answer = 0;
        for (Edge edge : list) {
            int fv1 = Find(edge.v1);
            int fv2 = Find(edge.v2);
            if (fv1 != fv2) {
                Union(fv1, fv2);
                answer += edge.cost;
            }
        }
        System.out.println(answer);
    }
}
