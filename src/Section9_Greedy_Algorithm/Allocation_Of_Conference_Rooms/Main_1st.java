package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Time_2nd implements Comparable<Time_2nd> {

    int s, e;

    public Time_2nd(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time_2nd t) {
        if (this.e == t.e) {
            return this.s - t.s;
        }
        else {
            return this.e - t.e;
        }
    }
}

public class Main_1st {

    public int solution(List<Time_2nd> list, int n) {

        int answer = 0;
        int endTime = 0;

        for (int i = 0; i < n; i++) {

            if (list.get(i).s >= endTime) {
                answer++;
                endTime = list.get(i).e;
            }
        }
        return answer;
    }
    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time_2nd> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Time_2nd(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);

        System.out.println(T.solution(list, n));
    }
}
