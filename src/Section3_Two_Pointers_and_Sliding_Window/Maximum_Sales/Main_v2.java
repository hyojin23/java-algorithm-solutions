package Section3_Two_Pointers_and_Sliding_Window.Maximum_Sales;

import java.util.Scanner;

public class Main_v2 {

    public int solution(int n, int m, int[] arr) {

        int sum = 0, max;

        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        max = sum;

        for (int i = m; i < n; i++) {
            sum += (arr[i] - arr[i - m]);
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
