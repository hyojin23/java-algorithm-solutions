package Section6_Sorting_and_Searching.Binary_Search;

import java.util.Scanner;
import java.util.Arrays;

public class Main_2nd {

    public int solution(int n, int m, int[] arr) {

        int lt = 0, rt = n - 1;
        int answer = 0;

        Arrays.sort(arr);

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] == m) {
                answer =  mid + 1;
                break;
            }
            else if (arr[mid] > m) {
                rt = mid - 1;
            }
            else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
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
