package Section4_HashMap_and_TreeSet.Find_All_The_Anagrams;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public int solution(String s, String t) {

        int answer = 0;
        int lt = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < t.length() - 1; i++) {
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int rt = t.length() - 1; rt < s.length(); rt++) {

            map2.put(s.charAt(rt), map2.getOrDefault(s.charAt(rt), 0) + 1);

            if (map.equals(map2)) {
                answer++;
            }

            map2.put(s.charAt(lt), map2.get(s.charAt(lt)) - 1);
            if (map2.get(s.charAt(lt)) == 0) map2.remove(s.charAt(lt));/**/
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(T.solution(s, t));
    }
}
