package BOJ.BOJ1167;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Node {

    int vex, cost;

    Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
}

public class Main {

    static int V;
    static List<List<Node>> tree;
    static int endNode, max = Integer.MIN_VALUE;
    static boolean[] visited;

    public void DFS(int v, int sum) {
        visited[v] = true;
        if (sum > max) {
            max = sum;
            endNode = v;
        }
        for (Node to : tree.get(v)) {
            if (!visited[to.vex]) {
                DFS(to.vex, sum + to.cost);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        tree = new ArrayList<>();
        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i <= V; i++) {
            int from = sc.nextInt();
            while (true) {
                int to = sc.nextInt();
                if (to == -1) {
                    break;
                }
                int cost = sc.nextInt();
                tree.get(from).add(new Node(to, cost));
            }
        }
        T.DFS(1, 0);
        max = Integer.MIN_VALUE;
        visited = new boolean[V + 1];
        T.DFS(endNode, 0);
        System.out.println(max);
    }
}
