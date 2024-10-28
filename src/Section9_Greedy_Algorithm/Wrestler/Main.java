package Section9_Greedy_Algorithm.Wrestler;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Person implements Comparable<Person> {

    int h, w;

    Person(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person ob) {
        return ob.h - this.h;
    }
}

public class Main {

    public int solution(int n, List<Person> list) {

        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (Person p : list) {
            if (p.w > max) {
                answer++;
                max = p.w;
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

        System.out.println(T.solution(n, list));
    }
}
