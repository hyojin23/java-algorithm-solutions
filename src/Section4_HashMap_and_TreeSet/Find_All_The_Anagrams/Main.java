package Section4_HashMap_and_TreeSet.Find_All_The_Anagrams;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public int solution(String s, String t) {

        int answer = 0;
        int len = t.length();
        int lt = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < len - 1; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int rt = len - 1; rt < s.length(); rt++) {

            sMap.put(s.charAt(rt), sMap.getOrDefault(s.charAt(rt), 0) + 1);

            if (sMap.equals(tMap)) {
                answer++;
            }

            sMap.put(s.charAt(lt), sMap.get(s.charAt(lt)) - 1);

            if (sMap.get(s.charAt(lt)) == 0) {
                sMap.remove(s.charAt(lt));
            }

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
