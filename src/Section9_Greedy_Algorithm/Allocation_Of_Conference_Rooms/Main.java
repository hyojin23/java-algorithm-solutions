package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Meeting implements Comparable<Meeting> {

    int s, e;

    Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meeting ob) {
        if (this.e == ob.e) {
            return this.s - ob.s;
        }
        else {
            return this.e- ob.e;
        }
    }
}

public class Main {

    public int solution(int n, List<Meeting> list) {

        Collections.sort(list);
        int endTime = Integer.MIN_VALUE;
        int answer = 0;
        for (Meeting m : list) {
            if (m.s >= endTime) {
                endTime = m.e;
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Meeting(s, e));
        }
        System.out.println(T.solution(n, list));
    }
}
