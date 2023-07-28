package Section6_Sorting_and_Searching.Mischievous_Boy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_v2 {

    public List<Integer> solution(int[] arr) {

        List<Integer> answerList = new ArrayList<>();

        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != tmp[i]) {
                answerList.add(i + 1);
            }
        }
        return answerList;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : T.solution(arr)) {
            System.out.print(i + " ");
        }
    }
}
