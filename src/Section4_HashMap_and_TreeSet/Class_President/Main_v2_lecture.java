package Section4_HashMap_and_TreeSet.Class_President;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_v2_lecture {

    public char solution(String str) {

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        char answer = ' ';

        for (char key : str.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2_lecture T = new Main_v2_lecture();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
