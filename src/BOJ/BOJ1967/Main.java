package BOJ.BOJ1967;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Edge {

    int vex, weight;

    Edge(int from, int weight) {
        this.vex = from;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return vex + " " + weight;
    }
}

public class Main {

    static List<List<Edge>> tree;
    static boolean[] visited;
    static int node, max = Integer.MIN_VALUE;

    public void DFS(int v, int sum) {
        if (sum > max) {
            max = sum;
            node = v;
        }
        for (Edge to : tree.get(v)) {
            if (!visited[to.vex]) {
                visited[to.vex] = true;
                DFS(to.vex, sum + to.weight);
                visited[to.vex] = false;
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        tree = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            tree.get(a).add(new Edge(b, c));
            tree.get(b).add(new Edge(a, c));
        }
        visited[1] = true;
        T.DFS(1, 0);

        Arrays.fill(visited, false);
        visited[node] = true;
        T.DFS(node, 0);
        System.out.println(max);
    }
}
