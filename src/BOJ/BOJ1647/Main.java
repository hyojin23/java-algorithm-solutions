package BOJ.BOJ1647;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
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

    static List<Edge> list;
    static int[] unf;

    public int find(int v) {

        if (unf[v] == v) {
            return v;
        }
        else {
            return unf[v] = find(unf[v]);
        }
    }

    public void union(int a, int b) {

        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public int solution() {

        Collections.sort(list);
        int sum = 0;
        int max = 0;
        for (Edge edge : list) {
            int fv1 = find(edge.v1);
            int fv2 = find(edge.v2);
            if (fv1 != fv2) {
                union(edge.v1, edge.v2);
                sum += edge.cost;
                max = Math.max(max, edge.cost);
            }
        }
        return sum - max;
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        unf = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.add(new Edge(A, B, C));
        }
        System.out.println(main.solution());
    }
}
