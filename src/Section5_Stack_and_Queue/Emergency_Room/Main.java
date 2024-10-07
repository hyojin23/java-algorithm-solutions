package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Patient {

    int rank;
    int danger;

    Patient(int rank, int danger) {
        this.rank = rank;
        this.danger = danger;
    }
}

public class Main {

    public int solution(int n, int m, int[] arr) {

        Queue<Patient> q = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            q.offer(new Patient(i, arr[i]));
        }

        while (!q.isEmpty()) {
            Patient p = q.poll();
            for (Patient r : q) {
                if (r.danger > p.danger) {
                    q.offer(p);
                    break;
                }
            }
            if (!q.contains(p)) {
                answer++;
                if (p.rank == m) {
                    break;
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
