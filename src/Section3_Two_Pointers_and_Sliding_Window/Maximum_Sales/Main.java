package Section3_Two_Pointers_and_Sliding_Window.Maximum_Sales;

import java.util.Scanner;

public class Main {

    public int solution(int n, int k, int[] arr) {

        int answer = 0;
        int lt = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        answer = Math.max(sum, answer);

        for (int rt = k; rt < n; rt++) {

            sum -= arr[lt++];
            sum += arr[rt];

            answer = Math.max(sum, answer);
        }

        return answer;
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
