package Section10_Dynamic_Programming.Get_The_Maximum_Score;

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

    static int n;
    static int m;

    public int solution(List<Problem> list) {

        int[] dy = new int[m + 1];

        for (Problem p : list) {
            for (int i = m; i >= p.t; i--) {
                dy[i] = Math.max(dy[i], dy[i - p.t] + p.s);
            }
        }

        return dy[m];
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        List<Problem> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int s = sc.nextInt();
            int t = sc.nextInt();

            list.add(new Problem(s, t));
        }

        System.out.println(T.solution(list));
    }
}
