package BOJ.BOJ14002;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public String solution(int N, int[] arr) {

        int[] dp = new int[N];
        int[] parent = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
        }

        int maxLen = 0;
        int lastIndex = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        LinkedList<Integer> lis = new LinkedList<>();
        while(lastIndex != -1) {
            lis.addFirst(arr[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLen).append('\n');
        for (int x : lis) {
            sb.append(x).append(" ");
        }
        return sb.toString().trim();
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
