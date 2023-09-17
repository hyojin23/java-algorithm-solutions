package Section10_Dynamic_Programming.Exchange_Of_Coins;

import java.util.Scanner;

public class Main {
    public int solution(int n, int[] coin, int m) {

        int[] dy = new int[m + 1];
        dy[0] = 0;

        for (int i = 1; i <=m; i++) {
            dy[i] = Integer.MAX_VALUE;
        }

        for (int c : coin) {
            for (int i = c; i <= m; i++) {
                dy[i] = Math.min(dy[i], dy[i - c] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        System.out.println(T.solution(n, coin, m));
    }
}
