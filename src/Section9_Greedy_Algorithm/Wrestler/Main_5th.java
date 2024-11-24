package Section9_Greedy_Algorithm.Wrestler;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Person_5th implements Comparable<Person_5th> {

    int h, w;

    Person_5th(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person_5th ob) {
        return ob.h - this.h;
    }
}

public class Main_5th {

    public int solution(int n, List<Person_5th> list) {

        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (Person_5th p : list) {
            if (p.w > max) {
                answer++;
                max = p.w;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person_5th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Person_5th(h, w));
        }

        System.out.println(T.solution(n, list));
    }
}
