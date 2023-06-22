package Section4_HashMap_and_TreeSet.Class_President;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_v2 {

    public char solution(char[] arr, int n) {

        Map<Character, Integer> map = new HashMap<>();
        char answer = 'Q';
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                answer = entry.getKey();
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        System.out.println(T.solution(arr, n));
    }
}
