package BOJ.BOJ2467;

import java.util.Scanner;

public class Main {

    public void solution(int N, int[] arr) {

        int lt = 0;
        int rt = N - 1;
        int min = Integer.MAX_VALUE;
        int leftAns = 0;
        int rightAns = 0;
        while (lt < rt) {

            int sum = arr[lt] + arr[rt];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                leftAns = arr[lt];
                rightAns = arr[rt];
            }
            if (sum < 0) {
                lt++;
            }
            else {
                rt--;
            }
        }
        System.out.println(leftAns + " " + rightAns);
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
