package Section3_Two_Pointers_and_Sliding_Window.Maximum_Sales;

import java.util.Scanner;

public class Main_7th {

    public int solution(int n, int k, int[] arr) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int answer = sum;
        int lt = 0;
        for (int rt = k; rt < n; rt++) {
            sum += arr[rt];
            sum -= arr[lt++];
            answer = Math.max(answer, sum);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
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
