package Section4_HashMap_and_TreeSet.Anagram;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main_7th {

    public String solution(String word1, String word2) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : word1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
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

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        String word1 = sc.next();
        String word2 = sc.next();

        System.out.println(T.solution(word1, word2));
    }
}
