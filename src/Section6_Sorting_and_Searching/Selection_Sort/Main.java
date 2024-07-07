package Section6_Sorting_and_Searching.Selection_Sort;

import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {

        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }

        return arr;
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

