package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Person_3rd {

    int priority;  // 위험도
    int id;        // 순서

    public Person_3rd(int priority, int id) {
        this.priority = priority;
        this.id = id;
    }
}
public class Main_3rd {

    public int solution(int n, int m, Queue<Person_3rd> q) {

        int answer = 0;

        while (!q.isEmpty()) {

            Person_3rd p = q.poll();
            boolean isContains = false;

            for (Person_3rd other : q) {
                if (p.priority < other.priority) {
                    q.offer(p);
                    isContains = true;
                    break;
                }
            }

            if (!isContains) {
                answer++;

                if (p.id == m) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Person_3rd> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int priority = sc.nextInt();
            q.offer(new Person_3rd(priority, i));
        }

        System.out.println(T.solution(n, m, q));
    }
}
