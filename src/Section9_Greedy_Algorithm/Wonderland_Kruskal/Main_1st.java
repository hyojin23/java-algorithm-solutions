package Section9_Greedy_Algorithm.Wonderland_Kruskal;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Edge_1st implements Comparable<Edge_1st> {

    int v1, v2, cost;

    public Edge_1st(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_1st ob) {
        return this.cost - ob.cost;
    }
}
public class Main_1st {

    static int[] unf;

    static int Find(int v) {

        if (v == unf[v]) {
            return v;
        }
        else {
            return unf[v] = Find(unf[v]);
        }
    }

    static void Union(int a, int b) {
        int s1 = Find(a);
        int s2 = Find(b);

        if (s1 != s2) {
            unf[s1] = s2;
        }
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        unf = new int[v + 1];

        List<Edge_1st> list = new ArrayList<>();
        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < e; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.add(new Edge_1st(a, b, c));
        }

        int answer = 0;

        Collections.sort(list);

        for (Edge_1st edge : list) {
            int s1 = Find(edge.v1);
            int s2 = Find(edge.v2);

            if (s1 != s2) {
                Union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }

        System.out.println(answer);
    }
}

