package Section10_Dynamic_Programming.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Problem implements Comparable<Problem> {

    int s, t;

    Problem(int s, int t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Problem ob) {
        return this.t - ob.t;
    }
}
public class Main {

    public int solution(int n, int m, List<Problem> list) {

        Collections.sort(list);
        int[] dy = new int[m + 1];
        Arrays.fill(dy, 0);

        for (int i = 0; i < n; i++) {
            Problem p = list.get(i);
            for (int j = m; j >= p.t; j--) {
                if (dy[j] < dy[j - p.t] + p.s) {
                    dy[j] = dy[j - p.t] + p.s;
                }
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Problem> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();

            list.add(new Problem(s, t));
        }

        System.out.println(T.solution(n, m, list));
    }
}
