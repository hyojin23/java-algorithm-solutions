package BOJ.BOJ4386;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node> {

    int v1, v2;
    double weight;

    Node(int v1, int v2, double weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node ob) {
        return Double.compare(this.weight, ob.weight);
    }
}

public class Main {

    static double[][] points;
    static int[] combi, parent;
    static List<Node> list;

    public static double solution() {

        Collections.sort(list);
        double sum = 0;

        for (Node node : list) {
            int fv1 = find(node.v1);
            int fv2 = find(node.v2);
            if (fv1 != fv2) {
                parent[fv1] = fv2;
                sum += node.weight;
            }
        }
        return sum;
    }

    public static int find(int v) {

        if (parent[v] == v) {
            return v;
        }
        else {
            return parent[v] = find(parent[v]);
        }
    }

    public static void combination(int s, int L) {

        if (L == combi.length) {
            int idx1 = combi[0];
            int idx2 = combi[1];

            double[] p1 = points[idx1];
            double[] p2 = points[idx2];

            double x1 = p1[0];
            double y1 = p1[1];
            double x2 = p2[0];
            double y2 = p2[1];

            double dis = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            list.add(new Node(idx1 + 1, idx2 + 1, dis));
        }
        else {
            for (int i = s; i < points.length; i++) {
                combi[L] = i;
                combination(i + 1, L + 1);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        points = new double[N][2];
        combi = new int[2];
        parent = new int[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0 ; i < N; i++) {
            String[] input = br.readLine().split(" ");
            double x = Double.parseDouble(input[0]);
            double y = Double.parseDouble(input[1]);

            points[i][0] = x;
            points[i][1] = y;
        }
        combination(0, 0);
        System.out.println(solution());
    }
}
