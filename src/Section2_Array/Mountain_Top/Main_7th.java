package Section2_Array.Mountain_Top;

import java.util.Scanner;

public class Main_7th {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0 ,-1};

    public int solution(int n, int[][] arr) {

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean isMountain = true;
                for (int k = 0; k < 4; k++) {
                    if (arr[i + dx[k]][j + dy[k]] >= arr[i][j]) {
                        isMountain = false;
                    }
                }
                if (isMountain) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
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
