package Section4_HashMap_and_TreeSet.Class_President;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public char solution(int n, String str) {

        Map<Character, Integer> map = new HashMap<>();
        char answer = ' ';
        int max = Integer.MIN_VALUE;

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 1) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                answer = c;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(n, str));
    }
}
