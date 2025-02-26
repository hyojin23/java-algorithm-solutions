package Section3_Two_Pointers_and_Sliding_Window.Maximum_Sales;

import java.util.Scanner;

public class Main {

    public int solution(int n, int k, int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            sum += arr[rt];
            max = Math.max(sum, max);
            sum -= arr[lt++];
        }
        return max;
    }


    public static void main(String[] args) {

        Main T = new Main();
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
