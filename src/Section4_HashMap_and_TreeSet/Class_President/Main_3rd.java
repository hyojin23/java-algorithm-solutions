package Section4_HashMap_and_TreeSet.Class_President;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main_3rd {

    public char solution(int n, String str) {

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        char answer = ' ';

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // System.out.println(map.containsKey('F'));
        // System.out.println(map.remove('A'));
        // System.out.println(map.size());

        for (char k : map.keySet()) {

            if (map.get(k) > max) {
                answer = k;
                max = map.get(k);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(n, str));
    }
}
