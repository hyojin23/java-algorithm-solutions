package Section4_HashMap_and_TreeSet.Find_All_The_Anagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_v2 {

    public int solution(String a, String b) {

        int answer = 0;
        int lt = 0, rt = b.length() - 1;
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();

        for (char c : b.toCharArray()) {
            bMap.put(c, bMap.getOrDefault(c, 0) + 1);
        }

        char[] aArr = a.toCharArray();

        for (int i = 0; i < b.length(); i++) {
            aMap.put(aArr[i], aMap.getOrDefault(aArr[i], 0) + 1);
        }

        while (rt < a.length()) {
            if (aMap.equals(bMap)) answer++;

            if (rt == a.length() - 1) break;

            aMap.put(aArr[++rt], aMap.getOrDefault(aArr[rt], 0) + 1);

            if (aMap.get(aArr[lt]) >= 2) {
                aMap.put(aArr[lt], aMap.get(aArr[lt]) - 1);
            }
            else {
                aMap.remove(aArr[lt]);
            }
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        System.out.println(T.solution(a, b));
    }
}
