package Section4_HashMap_and_TreeSet.Anagram;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public String solution(String str1, String str2) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c: str2.toCharArray()) {

            if (map.getOrDefault(c, 0) == 0) {
                return "NO";
            }

            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        return "YES";
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(T.solution(str1, str2));
    }
}

