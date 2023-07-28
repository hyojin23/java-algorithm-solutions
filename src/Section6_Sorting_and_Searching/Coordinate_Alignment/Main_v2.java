package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point2 implements Comparable<Point2> {

    int x;
    int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point2 o) {

        if (this.x == o.x)
            return this.y - o.y;
        else
            return this.x - o.x;
    }
}

public class Main_v2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Point2> list = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Point2 point = new Point2(x, y);
            list.add(point);
        }
        Collections.sort(list);

        for (Point2 p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
