package Section2_Array.Mountain_Top;

import java.util.Scanner;
// My solution
public class Main2 {

    public int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i=1; i<n+1; i++) {
            int wmax = 0, hmax = 0, tmax = 0;
            for (int j=1; j<n+1; j++) {
                wmax = Math.max(arr[i][j-1], arr[i][j+1]);
                hmax = Math.max(arr[i-1][j], arr[i+1][j]);
                tmax = Math.max(wmax, hmax);
                if (arr[i][j] > tmax) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+2][n+2];
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<n+1; j++) {
               arr[i][j]= sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
