package Section3_Two_Pointers_and_Sliding_Window.Finding_Common_Elements;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Main_5th {

    public List<Integer> solution(int n, int[] arr1, int m, int[] arr2) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        List<Integer> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {

            if (arr1[p1] < arr2[p2]) {
                p1++;
            }
            else if (arr1[p1] > arr2[p2]) {
                p2++;
            }
            else {
                list.add(arr1[p1++]);
                p2++;
            }
        }
        return list;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int x : T.solution(n, arr1, m, arr2)) {
            System.out.print(x + " ");
        }
    }
}
