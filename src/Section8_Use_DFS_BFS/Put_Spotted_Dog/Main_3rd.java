package Section8_Use_DFS_BFS.Put_Spotted_Dog;

import java.util.Scanner;

public class Main_3rd {

    static int[] arr;
    static int c, n;
    static int max = Integer.MIN_VALUE;
    public void DFS(int L, int sum) {

        if (L == n) {

            if (sum <= c && sum > max) {
                max = sum;
            }
        }
        else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.DFS(0, 0);
        System.out.println(max);
    }
}
