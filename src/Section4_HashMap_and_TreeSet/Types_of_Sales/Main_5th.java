package Section4_HashMap_and_TreeSet.Types_of_Sales;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main_5th {

    public List<Integer> solution(int n, int k, int[] arr) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0;

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        list.add(map.size());

        for (int rt = k; rt < n; rt++) {
            if (map.get(arr[lt]) == 1) {
                map.remove(arr[lt]);
            }
            else {
                map.put(arr[lt], map.get(arr[lt]) - 1);
            }
            lt++;

            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

            list.add(map.size());
        }
        return list;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : T.solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }
}
