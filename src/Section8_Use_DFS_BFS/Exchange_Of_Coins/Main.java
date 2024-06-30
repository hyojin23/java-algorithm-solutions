package Section8_Use_DFS_BFS.Exchange_Of_Coins;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int n, m;
    static Integer[] arr;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum) {

        if (sum > m) return;
        if (L >= answer) return;

        if (sum == m) {
            answer = Math.min(answer, L);
        }
        else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        m = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
