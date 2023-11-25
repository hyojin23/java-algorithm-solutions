package Section10_Dynamic_Programming.Get_The_Maximum_Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Problem_1st {

    int s, t;

    public Problem_1st(int s, int t) {
        this.s = s;
        this.t = t;
    }
}
public class Main_1st {

    public int solution(int m, List<Problem_1st> list) {

        int[] dy = new int[m + 1];

        for (Problem_1st p : list) {
            for (int i = m; i >= p.t; i--) {
                dy[i] = Math.max(dy[i], dy[i - p.t] + p.s);
            }
        }
        return dy[m];
    }
    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Problem_1st> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Problem_1st(a, b));
        }

        System.out.println(T.solution(m, list));
    }
}
