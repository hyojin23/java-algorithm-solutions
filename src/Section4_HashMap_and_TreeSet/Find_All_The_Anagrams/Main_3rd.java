package Section4_HashMap_and_TreeSet.Find_All_The_Anagrams;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main_3rd {

    public int solution(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        int lt = 0;
        int n = t.length() - 1;
        int answer = 0;

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int rt = n; rt < s.length(); rt++) {

            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0) + 1);

            if (map.equals(tMap)) {
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

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(T.solution(s, t));
    }
}
