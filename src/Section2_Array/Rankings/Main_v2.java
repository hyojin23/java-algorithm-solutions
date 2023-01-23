package Section2_Array.Rankings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_v2 {

    public List<Integer> solution(int[] arr) {

        List<Integer> answer = new ArrayList<>();
        int rank;

        for (int i : arr) {
            rank = 1;
            for (int j : arr) {
                if (i < j)
                    rank++;
            }
            answer.add(rank);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : T.solution(arr))
            System.out.print(i + " ");
    }
}
