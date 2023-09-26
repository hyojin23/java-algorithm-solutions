package Section2_Array.Maximum_Sum_Of_Grid;

import java.util.Scanner;

public class Main_1st {

    public int solution(int n, int[][] grid) {
        int answer = Integer.MIN_VALUE;
        // width, height
        for (int i=0; i<n; i++) {
            int wsum = 0, hsum = 0;
            for (int j=0; j<n; j++) {
                wsum += grid[i][j];
                hsum += grid[j][i];
            }
            answer = Math.max(answer, wsum);
            answer = Math.max(answer, hsum);
        }
        // diagonal
        int tdsum = 0, bdsum = 0;
        for (int i=0; i<n; i++) {
            tdsum += grid[i][i];
            bdsum += grid[n-i-1][i];
        }
        // final comparison
        answer = Math.max(answer, tdsum);
        answer = Math.max(answer, bdsum);
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, grid));
    }
}
