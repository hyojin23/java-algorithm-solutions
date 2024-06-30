package Section4_HashMap_and_TreeSet.Class_President;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main_2nd {

    public char solution(int n, String str) {

        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

//        map.containsKey();
//        map.remove('C');
//        map.size();

        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                answer = key;
                max = map.get(key);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(n, str));
    }
}
