package BOJ.BOJ1774;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {

    int vex;
    double dis;

    Node(int vex, double dis) {
        this.vex = vex;
        this.dis = dis;
    }

    @Override
    public int compareTo(Node ob) {
        return Double.compare(this.dis, ob.dis);
    }
}

public class Main {

    public static double solution(List<List<Node>> graph, boolean[] visited) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        double sum = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.vex]) continue;

            visited[cur.vex] = true;
            sum += cur.dis;

            for (Node next : graph.get(cur.vex)) {
                if (!visited[next.vex]) {
                    pq.offer(next);
                }
            }
        }
        return Math.round(sum * 100) / 100.0;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> points = new ArrayList<>();
        List<List<Node>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        points.add(new int[2]); // 1-based index


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] point = new int[2];
            point[0] = Integer.parseInt(st.nextToken());
            point[1] = Integer.parseInt(st.nextToken());
            points.add(point);
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int xi = points.get(i)[0];
                int yi = points.get(i)[1];
                int xj = points.get(j)[0];
                int yj = points.get(j)[1];
                long dx = (xi - xj);
                long dy = (yi - yj);

                double dis = Math.sqrt(dx * dx + dy * dy);
                graph.get(i).add(new Node(j, dis));
                graph.get(j).add(new Node(i, dis));
            }
        }

        for (int i = 0; i < M; i++) {
            String[] nodes  = br.readLine().split(" ");
            int n1 = Integer.parseInt(nodes[0]);
            int n2 = Integer.parseInt(nodes[1]);

            graph.get(n1).add(new Node(n2, 0)); //이미 연결된 통로
            graph.get(n2).add(new Node(n1, 0));
        }

        System.out.printf("%.2f\n", solution(graph, visited));
    }
}
