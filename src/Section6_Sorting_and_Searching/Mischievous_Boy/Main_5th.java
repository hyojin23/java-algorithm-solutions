package Section6_Sorting_and_Searching.Mischievous_Boy;

import java.util.Scanner;
import java.util.Arrays;

public class Main_5th {

    public void solution(int n, int[] arr) {

        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);

        for (int i = 0 ; i < n; i++) {
            if (arr[i] != sortArr[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.solution(n, arr);
    }
}
