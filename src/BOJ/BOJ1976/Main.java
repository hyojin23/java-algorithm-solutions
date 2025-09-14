package BOJ.BOJ1976;

import java.util.Scanner;

public class Main {

    static int[] unf;

    public static void Union(int a, int b) {

        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static int Find(int v) {

        if (unf[v] == v) {
            return v;
        }
        else {
            return unf[v] = Find(unf[v]);
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int connection = sc.nextInt();
                if (connection == 1) {
                    Union(i, j);
                }
            }
        }
        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = sc.nextInt();
        }
        String answer = "YES";
        int mainCity = Find(plan[0]);
        for (int city : plan) {
            if (Find(city) != mainCity) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }
}
