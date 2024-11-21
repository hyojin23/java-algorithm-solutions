package Section8_Use_DFS_BFS.Put_Spotted_Dog;

import java.util.Scanner;

public class Main_5th {

    static int c, n;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;

    public void DFS(int L, int sum) {

        if (sum > c) {
            return;
        }

        if (L == n) {
            answer = Math.max(sum, answer);
        }
        else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
