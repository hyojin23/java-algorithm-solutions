package Section3_Two_Pointers_and_Sliding_Window.Maximum_Sales;

import java.util.Scanner;

public class Main_5th {

    public int solution(int n, int k, int[] arr) {

        int lt = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;
        for (int rt = k; rt < n; rt++) {
            sum += arr[rt];
            sum -= arr[lt++];
            max = Math.max(sum, max);
        }
        return max;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
