package BOJ.BOJ14501;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Counseling {

    int d, t, p;

    Counseling(int d, int t, int p) {
        this.d = d;
        this.t = t;
        this.p = p;
    }
}

public class Main {

    static int N, answer;
    static List<Counseling> list;
    static boolean[] visited;

    public void DFS(int day, int sum) {

        if (day >= N) {
            answer = Math.max(answer, sum);
            return;
        }
        if (day + list.get(day).t <= N) {
           DFS(day + list.get(day).t, sum + list.get(day).p);
        }
        DFS(day + 1, sum);
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList<>();
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            int p = sc.nextInt();
            int day = i + 1;
            list.add(new Counseling(day, t, p));
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
