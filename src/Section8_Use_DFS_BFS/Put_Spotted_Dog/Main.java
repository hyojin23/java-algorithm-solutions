package Section8_Use_DFS_BFS.Put_Spotted_Dog;

import java.util.Scanner;

public class Main {

    static int c, n, answer = Integer.MIN_VALUE;
    static int[] arr;

    public void DFS(int sum, int L) {

        if (sum > c) {
            return;
        }

        if (L == n) {
            answer = Math.max(answer, sum);
        }
        else {
            DFS(sum + arr[L], L + 1);
            DFS(sum, L + 1);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
