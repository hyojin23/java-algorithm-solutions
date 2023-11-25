package Section2_Array.Mentoring;

import java.util.Scanner;

public class Main {

    public int solution(int[][] arr, int n, int m) {

        int[][] cnt = new int[n + 1][n + 1];
        int answer = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    int mento = arr[i][j];
                    int mentee = arr[i][k];
                    cnt[mento][mentee]++;
                }
            }
        }

        for (int[] x : cnt) {
            for (int a : x) {
                if (a == m) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr, n, m));
    }
}
