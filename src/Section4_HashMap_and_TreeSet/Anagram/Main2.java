package Section4_HashMap_and_TreeSet.Anagram;

import java.util.HashMap;
import java.util.Scanner;
// My solution
public class Main2 {

    public String solution(String w1, String w2) {
        String answer = "";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char x : w1.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for (char x : w2.toCharArray()) {
            if (map1.containsKey(x)) {
                map1.put(x, map1.get(x) - 1);
            } else {
                answer = "NO";
            }
        }
        for (int x : map1.values()) {
            if (x != 0) {
                answer = "NO";
                break;
            } else {
                answer = "YES";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        String w1 = sc.nextLine();
        String w2 = sc.nextLine();
        System.out.println(T.solution(w1, w2));

    }
}
