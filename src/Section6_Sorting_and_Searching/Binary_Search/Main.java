package Section6_Sorting_and_Searching.Binary_Search;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int solution(int n, int m, int[] arr) {

        int lt = 0;
        int rt = n - 1;

        Arrays.sort(arr);

        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            if (m < arr[mid]) {
                rt = mid - 1;
            }
            else if (m > arr[mid]) {
                lt = mid + 1;
            }
            else {
                return mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
