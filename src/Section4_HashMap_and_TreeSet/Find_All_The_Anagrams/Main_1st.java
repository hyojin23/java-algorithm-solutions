package Section4_HashMap_and_TreeSet.Find_All_The_Anagrams;

import java.util.Scanner;
import java.util.HashMap;

public class Main_1st {

    public int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        int slen = s.length(), tlen = t.length();
        int lt = 0;
        // smap setting
        for(int i=0; i<tlen-1; i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0)+1);
        }
        // tmap setting
        for (char x : t.toCharArray()) {
            tmap.put(x, tmap.getOrDefault(x, 0)+1);
        }
        for (int rt=tlen-1; rt<slen; rt++) {
            smap.put(s.charAt(rt), smap.getOrDefault(s.charAt(rt), 0)+1);
            if (smap.equals(tmap)) {
                answer++;
            }
            smap.put(s.charAt(lt), smap.getOrDefault(s.charAt(lt), 0)-1);
            if (smap.get(s.charAt(lt)) == 0) {
                smap.remove(s.charAt(lt));
            }
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(T.solution(s, t));
    }
}
