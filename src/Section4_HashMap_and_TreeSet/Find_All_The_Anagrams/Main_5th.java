package Section4_HashMap_and_TreeSet.Find_All_The_Anagrams;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main_5th {

    public int solution(String s, String t) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int len = t.length();
        int lt = 0;
        int answer = 0;

        for (char c : t.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < len - 1; i++) {
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int rt = len - 1; rt < s.length(); rt++) {
            map2.put(s.charAt(rt), map2.getOrDefault(s.charAt(rt), 0) + 1);
            if (map1.equals(map2)) {
                answer++;
            }
            map2.put(s.charAt(lt), map2.get(s.charAt(lt)) - 1);
            if (map2.get(s.charAt(lt)) == 0) {
                map2.remove(s.charAt(lt));
            }
            lt++;
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(T.solution(s, t));
    }
}
