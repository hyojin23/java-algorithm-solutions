package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Patient {

    int d, o;

    Patient(int d, int o) {
        this.d = d;
        this.o = o;
    }
}

public class Main {

    public int solution(int n, int m, int[] arr) {

        Queue<Patient> q = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            q.offer(new Patient(arr[i], i));
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            Patient a = q.poll();
            for (Patient b : q) {
                if (a.d < b.d) {
                    q.offer(a);
                    break;
                }
            }
            if (!q.contains(a)) {
                cnt++;
                if (a.o == m) {
                    answer = cnt;
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
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
