package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Person {

    int priority;  // 위험도
    int id;        // 순서

    public Person(int priority, int id) {
        this.priority = priority;
        this.id = id;
    }
}
public class Main {

    public int solution(int n, int m, Queue<Person> q) {

        int answer = 0;

        while (!q.isEmpty()) {

            Person p = q.poll();
            boolean isContains = false;

            for (Person other : q) {
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

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Person> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int priority = sc.nextInt();
            q.offer(new Person(priority, i));
        }

        System.out.println(T.solution(n, m, q));
    }
}
