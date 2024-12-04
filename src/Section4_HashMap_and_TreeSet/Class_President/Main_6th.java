package Section4_HashMap_and_TreeSet.Class_President;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main_6th {

    public Character solution(int n, String str) {

        Map<Character, Integer> map = new HashMap<>();
        char answer = ' ';
        int max = Integer.MIN_VALUE;

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

//        System.out.println(map.containsKey('A'));
//        System.out.println(map.size());
//        System.out.println(map.remove('C'));
//        System.out.println(map.size());

        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(n, str));
    }
}
