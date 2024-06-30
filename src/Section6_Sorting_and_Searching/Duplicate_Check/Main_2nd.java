package Section6_Sorting_and_Searching.Duplicate_Check;

import java.util.Scanner;
import java.util.Arrays;

public class Main_2nd {

    public Character solution(int n, int[] arr) {

        char answer = 'U';

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return 'D';
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
