package Section4_HashMap_and_TreeSet.Anagram;

import java.util.Scanner;
import java.util.HashMap;

public class Main_1st {

    public String solution(String w1, String w2) {
        String answer = "YES";
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char x : w1.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for (char x : w2.toCharArray()) {
            if (!map1.containsKey(x) || map1.get(x) == 0) {
                return "NO";
            } else {
                map1.put(x, map1.get(x)-1);
            }
    }
        return answer;
}

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        String w1 = sc.nextLine();
        String w2 = sc.nextLine();
        System.out.println(T.solution(w1, w2));
    }
}
