package BOJ.BOJ3190;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, d;

    Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Snake {

    Point head;
    Point tail;

    Snake(Point head, Point tail) {
        this.head = new Point(head.x ,head.y, head.d);
        this.tail = new Point(tail.x, tail.y, tail.d);
    }
}

public class Main {

    static int N, K;
    static int[][] board;
    static Map<Integer, Character> dirInfo;

    public int swichDirection(int now, char dir) {
        // dir --> 0:북, 1:동, 2:남, 3:서
        switch(now) {
            case 0 :
                return dir == 'L' ? 3 : 1;
            case 1 :
                return dir == 'L' ? 0 : 2;
            case 2 :
                return dir == 'L' ? 1 : 3;
            case 3 :
                return dir == 'L' ? 2 : 0;
            default:
                return 0;
        }
    }

    public int solution(int x, int y, int dir) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Snake> q = new LinkedList<>();
        q.offer(new Snake(new Point(x, y, dir), new Point(x, y, dir)));
        board[x][y] = 1;
        int time = 0;
        Queue<Point> dirQ = new LinkedList<>();
        while(!q.isEmpty()) {
            Snake sn = q.poll();
            int newHeadDir = sn.head.d;
            int newTailDir = sn.tail.d;
            if (dirInfo.containsKey(time)) {
                newHeadDir = swichDirection(sn.head.d, dirInfo.get(time));
                dirQ.offer(new Point(sn.head.x, sn.head.y, newHeadDir));
            }
            if (!dirQ.isEmpty() && dirQ.peek().x == sn.tail.x && dirQ.peek().y == sn.tail.y) {
                newTailDir = dirQ.poll().d;
            }
            int nhx = sn.head.x + dx[newHeadDir];
            int nhy = sn.head.y + dy[newHeadDir];
            int ntx = sn.tail.x + dx[newTailDir];
            int nty = sn.tail.y + dy[newTailDir];
            Point nHead;
            Point nTail;
            time++;
            if (nhx >= 0 && nhx < N && nhy >= 0 && nhy < N) {
                if (board[nhx][nhy] == 2) {   // 사과 존재
                    board[nhx][nhy] = 1;
                    nHead = new Point(nhx, nhy, newHeadDir);
                    nTail = new Point(sn.tail.x, sn.tail.y, newTailDir);
                }
                else if (board[nhx][nhy] == 0) {
                    board[nhx][nhy] = 1;
                    board[sn.tail.x][sn.tail.y] = 0;
                    nHead = new Point(nhx, nhy, newHeadDir);
                    nTail = new Point(ntx, nty, newTailDir);
                }
                else {  // 자기자신 몸과 부딪힘
                    return time;
                }
                Snake nSnake = new Snake(nHead, nTail);
                q.offer(nSnake);
            }
            else {  //벽에 부딪힘
                return time;
            }
        }
        return time;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];
        K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x - 1][y - 1] = 2;
        }
        int L = sc.nextInt();
        dirInfo = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            dirInfo.put(t, d);
        }
        System.out.println(T.solution(0, 0, 1));
    }
}
