package Section2_Array.Rankings;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_5th {

    public List<Integer> solution(int[] arr) {

        List<Integer> list = new ArrayList<>();

        for (int x : arr) {
            int rank = 1;
            for (int y : arr) {
                if (x < y) {
                    rank++;
                }
            }
            list.add(rank);
        }

        return list;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : T.solution(arr)) {
            System.out.print(x + " ");
        }
    }
}
