package Section2_Array.Mountain_Top;

import java.util.Scanner;

public class Main_4th {

    public int solution(int n, int[][] arr) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean isTop = false;
                for (int k = 0; k < 4; k++) {
                    if (arr[i][j] <= arr[i + dx[k]][j + dy[k]]) {
                        isTop = false;
                        break;
                    }
                    isTop = true;
                }
                if (isTop) {
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
        int[][] arr = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}
