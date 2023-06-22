package Section4_HashMap_and_TreeSet.Types_of_Sales;

import java.util.*;

public class Main_v2 {

    public List<Integer> solution(int[] arr, int n, int k) {

        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int lt = 0;
        int rt = 0;

        while (rt < n) {
            map.put(arr[rt], map.getOrDefault(arr[rt++], 0) + 1);
            cnt++;

            if (cnt > k) {
                if (map.get(arr[lt]) >= 2) {
                    map.put(arr[lt], map.getOrDefault(arr[lt++], 0) - 1);
                }
                else {
                    map.remove(arr[lt++]);
                }
                cnt--;
            }

            if (cnt == k) {
                answer.add(map.size());
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : T.solution(arr, n, k)) {
            System.out.print(i + " ");
        }
    }
}
