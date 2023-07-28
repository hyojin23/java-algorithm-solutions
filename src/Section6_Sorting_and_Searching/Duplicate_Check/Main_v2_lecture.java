package Section6_Sorting_and_Searching.Duplicate_Check;

import java.util.Arrays;
import java.util.Scanner;

public class Main_v2_lecture {

    public char solution(int[] arr) {

        char answer = 'U';

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                answer = 'D';
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2_lecture T = new Main_v2_lecture();
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
