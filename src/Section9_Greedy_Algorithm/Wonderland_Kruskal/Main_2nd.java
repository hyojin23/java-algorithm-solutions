package Section9_Greedy_Algorithm.Wonderland_Kruskal;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Edge_2nd implements Comparable<Edge_2nd> {

    int v1, v2, cost;

    Edge_2nd(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_2nd ob) {
        return this.cost - ob.cost;
    }
}

public class Main_2nd {

    public static int[] unf;

    public int Find(int v) {
        if (v == unf[v]) {
            return v;
        }
        else {
            return unf[v] = Find(unf[v]);
        }
    }

    public void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public int solution(int v, int e, List<Edge_2nd> list) {

        int answer = 0;
        Collections.sort(list);

        for (Edge_2nd edge : list) {
            int fa = Find(edge.v1);
            int fb = Find(edge.v2);

            if (fa != fb) {
                Union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        List<Edge_2nd> list = new ArrayList<>();
        unf = new int[v + 1];   

        for (int i = 1; i < v + 1; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge_2nd(a, b, c));
        }

        System.out.println(T.solution(v, e, list));
    }
}
