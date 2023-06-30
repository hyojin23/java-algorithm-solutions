package Section6_Sorting_and_Searching.Insertion_Sort;

import java.util.Scanner;

public class Main_v2 {

    public int[] solution(int n , int[] arr) {

        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j;
            for (j = i -1; j >= 0; j--) {
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                }
                else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : T.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
