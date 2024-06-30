package Section2_Array.Rankings;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int[] solution(int n, int[] arr) {

        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    rank[i]++;
                }
            }
        }

        return rank;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
