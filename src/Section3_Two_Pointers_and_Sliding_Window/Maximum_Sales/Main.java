package Section3_Two_Pointers_and_Sliding_Window.Maximum_Sales;

import java.util.Scanner;

public class Main {

    public int solution(int n, int k, int[] arr) {
        int answer = 0, sum = 0;
        for (int i=0; i<k; i++) {
            sum += arr[i];
        }
        answer = sum;
        for (int i=k; i<n; i++) {
            sum = sum + arr[i] - arr[i-k];
            if (sum > answer) {
                answer = sum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
