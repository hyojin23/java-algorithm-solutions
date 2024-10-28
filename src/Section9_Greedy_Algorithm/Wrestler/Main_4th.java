package Section9_Greedy_Algorithm.Wrestler;

import java.util.*;

class Person_4th implements Comparable<Person_4th> {

    int h, w;

    Person_4th(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person_4th p) {
        return p.h - this.h;
    }
}

public class Main_4th {

    public int solution(List<Person_4th> list) {

        int answer = list.size();
        int max = Integer.MIN_VALUE;

        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            Person_4th p1 = list.get(i);
            Person_4th p2 = list.get(i - 1);
            max = Math.max(p2.w, max);
             if (p1.w < max) {
                 answer--;
             }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person_4th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Person_4th(h, w));
        }

        System.out.println(T.solution(list));
    }
}
