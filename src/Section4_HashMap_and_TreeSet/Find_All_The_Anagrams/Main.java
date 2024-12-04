package Section4_HashMap_and_TreeSet.Find_All_The_Anagrams;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public int solution(String s, String t) {

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        char[] sArr = s.toCharArray();
        int answer = 0;

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int len = t.length();
        for (int i = 0; i < len; i++) {
            sMap.put(sArr[i], sMap.getOrDefault(sArr[i], 0) + 1);
        }
        if (sMap.equals(tMap)) {
            answer++;
        }

        for (int i = len; i < sArr.length; i++) {
            sMap.put(sArr[i], sMap.getOrDefault(sArr[i], 0) + 1);
            sMap.put(sArr[i - len], sMap.get(sArr[i - len]) - 1);
            if (sMap.get(sArr[i - len]) == 0) {
                sMap.remove(sArr[i - len]);
            }
            if (sMap.equals(tMap)) {
                answer++;
            }
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
