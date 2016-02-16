package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ksama on 1/25/16.
 */
public class Point {
  public int x;
  public int y;

  Point() { x = 0; y = 0; }
  Point(int a, int b) { x = a; y = b; }

  public static void addPoint(List<Point> points){
    points.add(new Point(4,5));
  }

  public static void main(String args[]){
    List<Point> p = new ArrayList<Point>();
    addPoint(p);
    System.out.println(p.get(0));
  }

  @Override
  public String toString() {
    return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }
}
