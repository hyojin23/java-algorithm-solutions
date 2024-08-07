package Section3_Two_Pointers_and_Sliding_Window.Combine_Two_Arrays;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_3rd {

    public List<Integer> solution(int n, int m, int[] arr1, int[] arr2) {

        List<Integer> answer = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {

            if (arr1[p1] < arr2[p2]) {
                answer.add(arr1[p1++]);
            }
            else {
                answer.add(arr2[p2++]);
            }
        }

        while (p1 < n) {
            answer.add(arr1[p1++]);
        }

        while (p2 < m) {
            answer.add(arr2[p2++]);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
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
