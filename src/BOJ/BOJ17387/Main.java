package BOJ.BOJ17387;

import java.util.Scanner;

class Point {
    long x, y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    // CCW 계산
    public static long ccw(Point A, Point B, Point C) {
        return (B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x);
    }

    // C가 AB 위에 있는지 확인
    public static boolean onSegment(Point A, Point B, Point C) {
        return Math.min(A.x, B.x) <= C.x && C.x <= Math.max(A.x, B.x) &&
                Math.min(A.y, B.y) <= C.y && C.y <= Math.max(A.y, B.y);
    }

    // 선분 교차 여부 확인
    public static boolean isIntersect(Point A, Point B, Point C, Point D) {
        long ccw1 = ccw(A, B, C);
        long ccw2 = ccw(A, B, D);
        long ccw3 = ccw(C, D, A);
        long ccw4 = ccw(C, D, B);

        // 일반 교차
        if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0) return true;

        // 한 점이 다른 선분 위에 있는 경우
        if (ccw1 == 0 && onSegment(A, B, C)) return true;
        if (ccw2 == 0 && onSegment(A, B, D)) return true;
        if (ccw3 == 0 && onSegment(C, D, A)) return true;
        if (ccw4 == 0 && onSegment(C, D, B)) return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();
        Point A = new Point(x1, y1);
        Point B = new Point(x2, y2);

        long x3 = sc.nextLong();
        long y3 = sc.nextLong();
        long x4 = sc.nextLong();
        long y4 = sc.nextLong();
        Point C = new Point(x3, y3);
        Point D = new Point(x4, y4);

        boolean result = isIntersect(A, B, C, D);

        System.out.println(result ? 1 : 0);
    }
}