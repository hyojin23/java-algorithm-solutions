package BOJ.BOJ1253;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int solution(int N, int[] arr) {

        int answer = 0;
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int lt = 0;
            int rt = N - 1;
            while (lt < rt) {
                if (lt == i) {
                    lt++;
                    continue;
                }
                if (rt == i) {
                    rt--;
                    continue;
                }
                int sum = arr[lt] + arr[rt];
                if (sum > arr[i]) {
                    rt--;
                }
                else if (sum < arr[i]) {
                    lt++;
                }
                else {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N, arr));
    }
}
