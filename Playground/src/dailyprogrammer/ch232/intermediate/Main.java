package dailyprogrammer.ch232.intermediate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		long start, end;
		List<Point> points1 = read("points1.txt");//16 points
		List<Point> points2 = read("points2.txt");//100 points challenge
		List<Point> points3 = read("points3.txt");//5000 points challenge
		List<Point> points4 = read("points4.txt");//100,000 points challenge
		
		start = System.currentTimeMillis();
		System.out.println(brute(points1));
		end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
		
		start = System.currentTimeMillis();
		System.out.println(brute(points2));
		end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
		
		start = System.currentTimeMillis();
		System.out.println(brute(points3));
		end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
		
		start = System.currentTimeMillis();
		System.out.println(brute(points4));
		end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
	}
	
	public static List<Point> read(String file) throws FileNotFoundException {
		List<Point> points = new ArrayList<>();
		Scanner sc = new Scanner(new File(file));
		int lines = Integer.parseInt(sc.nextLine().trim());

		for (int i = 0; i < lines; i++) {
			String[] xy = sc.nextLine().replaceAll("[(),]", "").split(" ");
			double x = Double.parseDouble(xy[0]);
			double y = Double.parseDouble(xy[1]);
			points.add(new Point(x, y));
		}
		sc.close();
		return points;
	}

	public static Pair brute(List<Point> points) {
		Pair closest = null;
		double minDist = Double.POSITIVE_INFINITY;
		for (int i = 0; i < points.size() - 1; i++) {
			for (int j = i + 1; j < points.size(); j++) {
				Point p = points.get(i);
				Point q = points.get(j);
				double dist = Point.distance(p, q);
				if (dist < minDist) {
					minDist = dist;
					closest = new Pair(p, q);
				}
			}
		}

		return closest;
	}
}

class Point implements Comparable<Point>{
	public final double x;
	public final double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public static double distance(Point a, Point b) {
		double dist = 0;
		double hor = b.x - a.x;
		double ver = b.y - a.y;

		dist = hor * hor + ver * ver;

		return dist;
	}

	@Override
	public int compareTo(Point other) {
		return Double.compare(this.x, other.x);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}

class Pair {
	public final Point a;
	public final Point b;
	public final double distance;

	public Pair(Point a, Point b) {
		super();
		this.a = a;
		this.b = b;
		this.distance = Point.distance(a, b);
	}

	@Override
	public String toString() {
		return a + " " + b;
	}

}