package Section2_Array.Print_Big_Number;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main_2nd {

    public List<Integer> solution(int[] arr, int n) {

        List<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
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

        for (int i : T.solution(arr, n)) {
            System.out.print(i + " ");
        }
    }
}
