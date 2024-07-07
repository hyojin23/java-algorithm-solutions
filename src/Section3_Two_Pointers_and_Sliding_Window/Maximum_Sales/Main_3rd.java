package Section3_Two_Pointers_and_Sliding_Window.Maximum_Sales;

import java.util.Scanner;

public class Main_3rd {

    public int solution(int n, int k, int[] arr) {

        int sum = 0;

        for (int i = 0 ; i < k; i++) {
            sum += arr[i];
        }

        int answer = sum;

        for (int i = k; i < n; i++) {

            sum += arr[i];
            sum -= arr[i - k];

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
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
