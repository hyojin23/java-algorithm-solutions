package Section4_HashMap_and_TreeSet.Anagram;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main_6th {

    public String solution(String s1, String s2) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (map.getOrDefault(c, 0) == 0) {
                return "NO";
            }
            else {
                map.put(c, map.get(c) - 1);
            }
        }
        return "YES";
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(T.solution(s1, s2));
    }
}
