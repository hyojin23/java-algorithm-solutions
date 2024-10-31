package Section9_Greedy_Algorithm.Wonderland_Kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge_3rd implements Comparable<Edge_3rd> {

    int v1, v2, cost;

    Edge_3rd(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_3rd ob) {
        return this.cost - ob.cost;
    }
}

public class Main_3rd {

    static int[] unf;
    public static int Find(int v) {

        if (unf[v] == v) {
            return v;
        }
        else {
            return unf[v] = Find(unf[v]);
        }
    }

    public static void Union(int a, int b) {

        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public int solution(List<Edge_3rd> list) {

        Collections.sort(list);

        int sum = 0;
        for (Edge_3rd e : list) {
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

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        List<Edge_3rd> list = new ArrayList<>();
        unf = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            list.add(new Edge_3rd(v1, v2, cost));
        }

        System.out.println(T.solution(list));
    }
}
