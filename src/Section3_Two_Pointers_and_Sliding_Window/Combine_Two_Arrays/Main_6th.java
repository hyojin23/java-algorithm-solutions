package Section3_Two_Pointers_and_Sliding_Window.Combine_Two_Arrays;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_6th {

    public List<Integer> solution(int n, int m, int[] arr1, int[] arr2) {

        int p1 = 0;
        int p2 = 0;
        List<Integer> list = new ArrayList<>();

        while (p1 < n && p2 < m) {
            if (arr1[p1] <= arr2[p2]) {
                list.add(arr1[p1++]);
            }
            else if (arr1[p1] > arr2[p2]) {
                list.add(arr2[p2++]);
            }
        }
        while (p1 < n) {
            list.add(arr1[p1++]);
        }
        while (p2 < m) {
            list.add(arr2[p2++]);
        }
        return list;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int x : T.solution(n, m, arr1, arr2)) {
            System.out.print(x + " ");
        }
    }
}
