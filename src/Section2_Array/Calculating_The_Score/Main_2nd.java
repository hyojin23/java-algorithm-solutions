package Section2_Array.Calculating_The_Score;

import java.util.Scanner;

public class Main_2nd {

    public int solution(int[] arr) {

        int cnt = 0;
        int sum = 0;

        for (int x : arr) {
            if (x == 1) {
                cnt++;
                sum += cnt;
            }
            else {
                cnt = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
