package Section3_Two_Pointers_and_Sliding_Window.Sum_of_Continuous_Natural_Numbers;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[] arr) {

        int answer = 0;
        int lt = 0;
        int sum = 0;

        for (int rt = 0; rt < n; rt++) {

            sum += arr[rt];

            if (sum == n) {
                answer++;
            }

            while (sum > n) {
                sum -= arr[lt++];

                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        System.out.println(T.solution(n, arr));
    }
}