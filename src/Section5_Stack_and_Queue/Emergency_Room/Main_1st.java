package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Person_1st {
    int id;
    int priority;

    public Person_1st(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Main_1st {

    public Integer solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person_2nd> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Person_2nd(i, arr[i]));
        }
        while (!q.isEmpty()) {
            Person_2nd tmp = q.poll();
            for (Person_2nd x : q) {
                if (x.priority > tmp.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main_2nd T = new Main_2nd();
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
