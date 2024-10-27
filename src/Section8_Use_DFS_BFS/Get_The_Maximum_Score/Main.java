package Section8_Use_DFS_BFS.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Problem {

    int s, t;

    Problem(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main {

    static int n, m;
    static List<Problem> list;
    static int answer = Integer.MIN_VALUE;

     public void DFS(int L, int score, int time) {

         if (time > m) {
             return;
         }

         if (L == n) {
             answer = Math.max(answer, score);
         }
         else {
             DFS(L + 1, score + list.get(L).s, time + list.get(L).t);
             DFS(L + 1, score, time);
         }
     }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();

            list.add(new Problem(s, t));
        }

        T.DFS(0, 0, 0);
        System.out.println(answer);
    }
}
