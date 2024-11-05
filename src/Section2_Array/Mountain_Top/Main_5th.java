package Section2_Array.Mountain_Top;

import java.util.Scanner;

public class Main_5th {

    public int solution(int n, int[][] arr) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean isTop = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (arr[i][j] <= arr[nx][ny]) {
                        isTop = false;
                        break;
                    }
                }
                if (isTop) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
