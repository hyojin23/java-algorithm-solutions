package Section6_Sorting_and_Searching.Insertion_Sort;

import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {

        for (int i = 1; i < n; i++) {
            int target = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > target) {
                    arr[j + 1] = arr[j];
                }
                else {
                    break;
                }
            }
            arr[j + 1] = target;
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
