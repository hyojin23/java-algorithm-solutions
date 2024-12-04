package Section3_Two_Pointers_and_Sliding_Window.Maximum_Sales;

import java.util.Scanner;

public class Main_6th {

    public int solution(int n, int k, int[] arr) {

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }

        int lt = 0;
        for (int i = k - 1; i < n; i++) {
            sum += arr[i];
            answer = Math.max(sum, answer);
            sum -= arr[lt++];
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
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
