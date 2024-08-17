package Section9_Greedy_Algorithm.Wrestler;

import java.util.*;

class Person implements Comparable<Person> {

    int h, w;

    Person(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person p) {
        return p.h - this.h;
    }
}

public class Main {

    public int solution(List<Person> list) {

        int answer = list.size();
        int max = Integer.MIN_VALUE;

        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            Person p1 = list.get(i);
            Person p2 = list.get(i - 1);
            max = Math.max(p2.w, max);
             if (p1.w < max) {
                 answer--;
             }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Person(h, w));
        }

        System.out.println(T.solution(list));
    }
}
