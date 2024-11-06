package Section4_HashMap_and_TreeSet.Anagram;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main_5th {

    public String solution(String s1, String s2) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (char key : map.keySet()) {
            if (map.get(key) != 0) {
                return "NO";
            }
        }
        return "YES";
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(T.solution(s1, s2));
    }
}
