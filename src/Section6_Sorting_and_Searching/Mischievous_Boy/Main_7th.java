package Section6_Sorting_and_Searching.Mischievous_Boy;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_7th {

    public List<Integer> solution(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();
        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);

        for (int i = 0; i < n; i++) {
            if (arr[i] != sortArr[i]) {
                list.add(i + 1);
            }
        }
        return list;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
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
