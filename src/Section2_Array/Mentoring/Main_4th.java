package Section2_Array.Mentoring;

import java.util.Scanner;

public class Main_4th {

    public int solution(int n, int m, int[][] arr) {

        int[][] ch = new int[n + 1][n + 1];
        int answer = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (j < k) {
                        int me = arr[i][j];
                        int you = arr[i][k];
                        ch[me][you]++;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (ch[i][j] == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, m ,arr));
    }
}
