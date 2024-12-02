package Section2_Array.Print_Big_Number;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_6th {

    public List<Integer> solution(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                list.add(arr[i]);
            }
        }
        return list;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
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
