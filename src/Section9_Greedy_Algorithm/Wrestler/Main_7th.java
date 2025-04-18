package Section9_Greedy_Algorithm.Wrestler;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Person_7th implements Comparable<Person_7th> {

    int h, w;

    Person_7th(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person_7th ob) {
        return ob.h - this.h;
    }
}

public class Main_7th {

    public int solution(List<Person_7th> list) {

        int max = Integer.MIN_VALUE;
        int answer = 0;
        Collections.sort(list);

        for (Person_7th p : list) {
            if (p.w > max) {
                answer++;
                max = p.w;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);
        List<Person_7th> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Person_7th(h, w));
        }

        System.out.println(T.solution(list));
    }
}
