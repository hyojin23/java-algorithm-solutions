package Section4_HashMap_and_TreeSet.Anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_v2_lecture {

    public String solution(String a, String b) {

        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();

        for (char x : a.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : b.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                answer = "NO";
                break;
            }
            map.put(x, map.get(x) - 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_v2_lecture T = new Main_v2_lecture();
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(T.solution(a, b));
    }
}
