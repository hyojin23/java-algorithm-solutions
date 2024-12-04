package Section4_HashMap_and_TreeSet.Find_All_The_Anagrams;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main_6th {

    public int solution(String s, String t) {

        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        int len = t.length();
        int answer = 0;

        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < len - 1; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = len - 1; rt < s.length(); rt++) {

            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0) + 1);

            if (map.equals(targetMap)) {
                answer++;
            }

            map.put(s.charAt(lt), map.get(s.charAt(lt)) - 1);
            if (map.get(s.charAt(lt)) == 0) {
                map.remove(s.charAt(lt));
            }
            lt++;
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(T.solution(s, t));
    }
}
