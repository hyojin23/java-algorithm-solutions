package Section2_Array.Mentoring;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_v2 {

    public int solution(int n, int m, int[][] arr) {

        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k <= n - 1; k++) {
                    sb.setLength(0);
                    sb.append(arr[i][j]);
                    sb.append("_");
                    sb.append(arr[i][k]);
                    String key = sb.toString();

                    if (map.containsKey(key))
                        map.put(key, map.get(key) + 1);
                    else
                        map.put(key, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == m)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, m, arr));
    }
}
