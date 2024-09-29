package Section3_Two_Pointers_and_Sliding_Window.Combine_Two_Arrays;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_4th {

    public List<Integer> solution(int n, int m, int[] arr1, int[] arr2) {

        List<Integer> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {

            if (arr1[p1] < arr2[p2]) {

                list.add(arr1[p1]);
                p1++;
            }
            else if (arr2[p2] < arr1[p1]) {
                list.add(arr2[p2]);
                p2++;
            }
            else {
                list.add(arr1[p1]);
                list.add(arr2[p2]);
                p1++;
                p2++;
            }
        }

        if (p1 == n) {
            while (p2 < m) {
                list.add(arr2[p2]);
                p2++;
            }
        }

        if (p2 == m) {
            while (p1 < n) {
                list.add(arr1[p1]);
                p1++;
            }
        }

        return list;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
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

        for (int i : T.solution(n, m, arr1, arr2)) {
            System.out.print(i + " ");
        }
    }
}
