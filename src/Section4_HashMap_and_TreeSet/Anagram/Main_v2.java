package Section4_HashMap_and_TreeSet.Anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_v2 {

    public String solution(String a, String b) {

        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();

        String answer = "NO";

        for (char key : a.toCharArray()) {
            aMap.put(key, aMap.getOrDefault(key, 0) + 1);
        }

        for (char key: b.toCharArray()) {
            bMap.put(key, bMap.getOrDefault(key, 0) + 1);
        }

        if (aMap.equals(bMap)) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(T.solution(a, b));
    }
}
