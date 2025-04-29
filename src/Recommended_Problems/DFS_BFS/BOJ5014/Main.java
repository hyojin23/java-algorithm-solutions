package Recommended_Problems.DFS_BFS.BOJ5014;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public int BFS(int F, int S, int G, int U, int D) {

        int[] ch = new int[F + 1];
        int[] dis = new int[F + 1];
        int[] go = {U, -D};
        Queue<Integer> q = new LinkedList<>();
        ch[S] = 1;
        q.offer(S);
        while (!q.isEmpty()) {
            int s = q.poll();
            if (s == G) {
                return dis[s];
            }
            for (int i = 0; i < 2; i++) {
                int ns = s + go[i];
                if (ns >= 1 && ns <= F && ch[ns] == 0) {
                    dis[ns] = dis[s] + 1;
                    ch[ns] = 1;
                    q.offer(ns);
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();
        int cnt = T.BFS(F, S, G, U, D);
        if (cnt >= 0) {
            System.out.println(cnt);
        }
        else {
            System.out.println("use the stairs");
        }
    }
}
