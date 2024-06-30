package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Shortest_Path_Graph_BFS;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static List<List<Integer>> graph;
    static int[] ch;
    static int[] answer;

    public int[] BFS(int n) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int L = 0;
        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {
                int fromNode = q.poll();
                for (int toNode : graph.get(fromNode)) {
                    if (ch[toNode] == 0) {
                        ch[toNode] = 1;
                        q.offer(toNode);
                    }
                }
                answer[fromNode] = L;
            }
            L++;
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<>();
        ch = new int[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        ch[1] = 1;
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }
}
