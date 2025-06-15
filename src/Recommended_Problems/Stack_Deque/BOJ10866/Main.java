package Recommended_Problems.Stack_Deque.BOJ10866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Deque {

    int[] deque = new int[20000];
    int front = 10000;
    int rear = 10000;

    public void pushFront(int x) {
        deque[--front] = x;
    }

    public void pushBack(int x) {
        deque[rear++] = x;
    }

    public int popFront() {
        return front == rear ? -1 : deque[front++];
    }

    public int popBack() {
        return front == rear ? -1 : deque[--rear];
    }

    public int size() {
        return rear - front;
    }

    public int empty() {
        return size() == 0 ? 1 : 0;
    }

    public int front() {
        return empty() == 1 ? -1 : deque[front];
    }

    public int back() {
        return empty() == 1 ? -1 : deque[rear - 1];
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(deque);
    }
}

public class Main {

    public void solution(int N, String[] arr) {

        Deque dq = new Deque();
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            String[] orders = s.split(" ");
            String order = orders[0];
            int number = 0;
            if (orders.length > 1) {
                number = Integer.parseInt(orders[1]);
            }
            switch (order) {
                case "push_front":
                    dq.pushFront(number);
                    break;

                case "push_back":
                    dq.pushBack(number);
                    break;

                case "pop_front":
                    sb.append(dq.popFront()).append('\n');
                    break;

                case "pop_back":
                    sb.append(dq.popBack()).append('\n');
                    break;

                case "size":
                    sb.append(dq.size()).append('\n');
                    break;

                case "empty":
                    sb.append(dq.empty()).append('\n');
                    break;

                case "front":
                    sb.append(dq.front()).append('\n');
                    break;

                case "back":
                    sb.append(dq.back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        T.solution(N, arr);
    }
}
