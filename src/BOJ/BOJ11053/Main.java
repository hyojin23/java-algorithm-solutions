package BOJ.BOJ11053;

import java.util.Scanner;

public class Main {

    public int solution(int N, int[] arr) {

        int answer = 0;
        int[] seqLength = new int[N];
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, seqLength[j]);
                }
            }
            seqLength[i] = max + 1;
            answer = Math.max(answer, seqLength[i]);
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
