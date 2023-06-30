package Section5_Stack_and_Queue.Emergency_Room;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person2 {
    int id;
    int priority;

    public Person2(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Main_v2 {

    public int solution(int n, int m, int[] arr) {

        int answer = 0;
        Queue<Person2> Q = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            Person2 person = new Person2(i, arr[i]);
            Q.offer(person);
        }

        while (!Q.isEmpty()) {
            boolean isTreated = true;
            Person2 x = Q.poll();
            for (Person2 person : Q) {
                if (x.priority < person.priority) {
                    Q.offer(x);
                    isTreated = false;
                    break;
                }
            }
            if (isTreated) {
                answer++;
                if (x.id == m)
                    return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
