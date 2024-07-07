package Section2_Array.Maximum_Sum_Of_Grid;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr) {

        int answer = 0;

        int downCrsSum = 0;
        int upCrsSum = 0;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            answer = Math.max(answer, rowSum);
            answer = Math.max(answer, colSum);

            downCrsSum += arr[i][i];
            upCrsSum += arr[i][n - 1 - i];
        }

        answer = Math.max(answer, downCrsSum);
        answer = Math.max(answer, upCrsSum);

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
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
