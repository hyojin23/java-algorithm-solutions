package Section10_Dynamic_Programming.Exchange_Of_Coins;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int solution(int n, int m, int[] coin) {

        int[] dy = new int[m + 1];

        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
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

        System.out.println(T.solution(n, m, coin));
    }
}
