package Section8_Use_DFS_BFS.Put_Spotted_Dog;

import java.util.Scanner;

public class Main_7th {

    static int c, n;
    static int answer = Integer.MIN_VALUE;

    public void DFS(int L, int sum, int[] arr) {

        if (sum > c) {
            return;
        }

        if (L == n) {
            answer = Math.max(answer, sum);
        }
        else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
