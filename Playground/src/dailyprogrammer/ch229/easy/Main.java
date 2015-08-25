package dailyprogrammer.ch229.easy;

import java.util.function.Function;

public class Main {
	public static double EPSILON = 0.0001;
	public static String format = "%8s with %1.1f = %f\n";
	public static String format2 = "%8s with %1.2f = ";

	public static void main(String[] args) {
		Function<Double, Double> cos = x -> Math.cos(x);
		Function<Double, Double> pi = x -> x - Math.tan(x);
		Function<Double, Double> fib = x -> 1 + 1 / x;
		Function<Double, Double> f4 = x -> 4 * x * (1 - x);

		System.out.printf(format, "cos(x)", 1.0, dottie(cos, 1));
		System.out.printf(format, "x-tan(x)", 2.0, dottie(pi, 2));
		System.out.printf(format, "1+1/x", 1.0, dottie(fib, 1));

		double j = 0;
		double step = 0.25;
		while (j <= 1) {
			System.out.printf(format2, "4x(1-x)", j);
			System.out.println(dottie(f4, j));
			j = (double) Math.round((j + step) * (1/step)) / (1/step);
		}
	}

	public static double dottie(Function<Double, Double> f, double x) {
		double y = f.apply(x);
		if (!dEquals(x, y)) {
			return dottie(f, y);
		}
		return x;
	}

	public static boolean dEquals(double x, double y) {
		return (Math.abs(x - y) < EPSILON);
	}
}
