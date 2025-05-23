package Section10_Dynamic_Programming.Exchange_Of_Coins;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int solution(int n, int m, int[] arr) {

        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int x : arr) {
            for (int i = x; i <= m; i++) {
                dy[i] = Math.min(dy[i], dy[i - x] + 1);
            }
        }
        return dy[m];
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(T.solution(n, m, arr));
    }
}
