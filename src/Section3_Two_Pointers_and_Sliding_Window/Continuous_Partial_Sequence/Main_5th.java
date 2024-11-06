package Section3_Two_Pointers_and_Sliding_Window.Continuous_Partial_Sequence;

import java.util.Scanner;

public class Main_5th {

    public int solution(int n, int m, int[] arr) {

        int lt = 0;
        int rt = 0;
        int sum = arr[0];
        int answer = 0;

        while (lt < n && rt < n) {
            if (sum < m) {
                rt++;
                if (rt >= n) {
                    break;
                }
                sum += arr[rt];
            }
            else if (sum > m) {
                sum -= arr[lt++];
            }
            else {
                answer++;
                rt++;
                if (rt >= n) {
                    break;
                }
                sum += arr[rt];
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
