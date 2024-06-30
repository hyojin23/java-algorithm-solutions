package Section2_Array.Mountain_Top;

import java.util.Scanner;

public class Main_2nd {

    public int solution(int[][] arr, int n) {

        int[] dx = {-1 , 0, 1, 0};
        int[] dy = {0 , 1, 0, -1};
        boolean isMountain;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                isMountain = true;
                for (int k = 0; k < 4; k++) {
                    int around = arr[i + dx[k]][j + dy[k]];
                    if (arr[i][j] <= around) {
                        isMountain = false;
                        break;
                    }
                }
                if (isMountain) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr, n));
    }
}
