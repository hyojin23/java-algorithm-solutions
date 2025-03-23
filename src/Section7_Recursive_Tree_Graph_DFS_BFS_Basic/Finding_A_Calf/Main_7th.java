package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Calf;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_7th {

    int[] ch = new int[10001];
    int[] jump = {1, -1, 5};

    public int BFS(int s, int e) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                for (int j = 0; j <jump.length; j++) {
                    int ns = cur + jump[j];
                    if (ns == e) {
                        return L + 1;
                    }
                    if (ns >= 1 && ns <= 10000 && ch[ns] == 0) {
                        q.offer(ns);
                        ch[ns] = 1;
                    }
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
