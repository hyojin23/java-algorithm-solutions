package Section2_Array.Mountain_Top;

import java.util.Scanner;

public class Main_v2 {

    public int solution(int n, int[][] arr) {

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};
        int cnt = 0;
        boolean mountain;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                mountain = true;
                for (int k = 0; k < 4; k++) {
                    if (arr[i][j] <= arr[i + r[k]][j + c[k]]) {
                        mountain = false;
                        break;
                    }
                }
                if (mountain)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n + 2][n + 2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
