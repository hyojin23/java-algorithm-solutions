package BOJ.BOJ2470;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public void solution(int N, int[] arr) {

        Arrays.sort(arr);
        int lt = 0;
        int rt = N - 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (lt < rt) {
            int mid = arr[lt] + arr[rt];
            if (Math.abs(mid) < min) {
                min = Math.abs(mid);
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }
            if (mid > 0) {
                rt--;
            }
            else {
                lt++;
            }
        }
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        T.solution(N, arr);
    }
}
