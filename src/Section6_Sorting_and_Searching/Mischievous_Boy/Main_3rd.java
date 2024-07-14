package Section6_Sorting_and_Searching.Mischievous_Boy;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main_3rd {

    public List<Integer> solution(int n, int[] arr) {

        int[] orgArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        List<Integer> answer = new ArrayList<>();

        for (int i = 0 ; i < n; i++) {
            if (orgArr[i] != arr[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : T.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
