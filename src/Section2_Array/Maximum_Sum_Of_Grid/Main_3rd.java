package Section2_Array.Maximum_Sum_Of_Grid;

import java.util.Scanner;

public class Main_3rd {

    public int solution(int n, int[][] arr) {

        int rsum;
        int csum;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            rsum = 0;
            csum = 0;
            for (int j = 0; j < n; j++) {
                rsum += arr[i][j];
                csum += arr[j][i];
            }
            answer = Math.max(answer, rsum);
            answer = Math.max(answer, csum);
        }

        int dsum = 0;
        int usum = 0;

        for (int i = 0; i < n; i++) {
            dsum += arr[i][i];
            usum += arr[i][n - i - 1];
        }
        answer = Math.max(answer, dsum);
        answer = Math.max(answer, usum);

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));

    }
}
