package Section9_Greedy_Algorithm.Wrestler;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Person_6th implements Comparable<Person_6th> {

    int h, w;

    Person_6th(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person_6th ob) {
        return ob.h - this.h;
    }
}

public class Main_6th {

    public int solution(List<Person_6th> list) {

        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (Person_6th p : list) {
            if (p.w > max) {
                answer++;
                max = p.w;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person_6th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Person_6th(h, w));
        }

        System.out.println(T.solution(list));
    }
}
