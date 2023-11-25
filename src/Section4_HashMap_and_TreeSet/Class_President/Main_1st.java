package Section4_HashMap_and_TreeSet.Class_President;

import java.util.HashMap;
import java.util.Scanner;

public class Main_1st {

    public char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);

        }
//        System.out.println(map.containsKey('A'));
//        System.out.println(map.size());
//        System.out.println(map.remove('A'));
        int max = Integer.MIN_VALUE;
        for (char key: map.keySet()) {
//            System.out.println(key + " " + map.get(key));
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        System.out.println(T.solution(n, str));
    }
}
