package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Point implements Comparable<Point> {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point ob) {
        if (this.x == ob.x) {
            return this.y - ob.y;
        }
        else {
            return this.x - ob.x;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y  = sc.nextInt();
            list.add(new Point(x, y));
        }

        Collections.sort(list);

        for (Point c : list) {
            System.out.println(c.x + " " + c.y);
        }
    }
}
