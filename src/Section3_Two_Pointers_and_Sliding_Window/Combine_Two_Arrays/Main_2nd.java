package Section3_Two_Pointers_and_Sliding_Window.Combine_Two_Arrays;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_2nd {

    public List<Integer> solution(int[] arr1, int[] arr2, int n, int m) {

        int p1 = 0, p2 = 0;
        List <Integer> answer = new ArrayList<>();

        while (p1 < n && p2 < m) {

            if (arr1[p1] < arr2[p2]) {
                answer.add(arr1[p1++]);
            }
            else {
                answer.add(arr2[p2++]);
            }
        }

        while (p1 < n) answer.add(arr1[p1++]);
        while (p2 < m) answer.add(arr2[p2++]);

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
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

        for (int x : T.solution(arr1, arr2, n, m)) {
            System.out.print(x + " ");
        }
    }
}
