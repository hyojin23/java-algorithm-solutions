package Section6_Sorting_and_Searching.Mischievous_Boy;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_4th {

    public List<Integer> solution(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();

        int[] orgArr = Arrays.copyOf(arr, n);

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (orgArr[i] != arr[i]) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
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
