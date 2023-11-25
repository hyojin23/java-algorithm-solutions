package Section6_Sorting_and_Searching.Mischievous_Boy;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public List<Integer> solution(int n, int[] arr) {

        List<Integer> answer = new ArrayList<>();

        int[] arrCopy = Arrays.copyOfRange(arr, 0, n);
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] != arrCopy[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
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
