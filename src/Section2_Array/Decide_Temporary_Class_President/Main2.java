package Section2_Array.Decide_Temporary_Class_President;

import java.util.Scanner;
// My solution
public class Main2 {

    public int solution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            int count = 0;
            boolean[] isChecked = new boolean[n];
            for (int j=0; j<5; j++) {
                for (int k=-i; k<n-i; k++) {
                    // The number of a friend who was in the same class once.
                    if (arr[i][j] == arr[i+k][j] && i != i+k && !isChecked[i+k]) {
                        count++;
                        isChecked[i+k] = true;
                    }
                }
            }
            if (count > max) {
                max = count;
                answer = i+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
