package BOJ.BOJ1027;

import java.util.Scanner;

public class Main {

    public int solution(int N, int[] arr) {

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            double min = 0;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (arr[i] - arr[j]) / (i - j);
                if (j == i - 1 || slope < min) {
                    cnt++;
                    min = slope;
                }
            }
            for (int j = i + 1; j < N; j++) {
                double slope = (double) (arr[i] - arr[j]) / (i - j);
                if (j == i + 1 || slope > min) {
                    cnt++;
                    min = slope;
                }
            }
            answer = Math.max(answer, cnt);
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
