package Section6_Sorting_and_Searching.Duplicate_Check;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_v2 {

    public char solution(int[] arr) {

        char answer = 'U';
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.values()) {
            if (i >= 2) {
                answer = 'D';
                break;
            }
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

        System.out.println(T.solution(arr));
    }
}
