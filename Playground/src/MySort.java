import java.util.Scanner;
import java.util.Random;

public class MySort {
	public static void sort(int[] arr, int sortToIndex) {
		if (arr.length < 2) {
			System.out.println("Not enough values to sort!");
		} else if (sortToIndex == 1) {
			if (arr[0] > arr[1]) {
				int temp = arr[0];
				arr[0] = arr[1];
				arr[1] = temp;
			}
		} else {
			sort(arr, (sortToIndex - 1));
			int current = arr[sortToIndex];
			for (int i = (sortToIndex - 1); i >= 0; i--) {
				if (current > arr[i]) {
					i = -1;
				} else {
					arr[i + 1] = arr[i];
					arr[i] = current;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("MySort Test\n");

		Random rand = new Random();
		int[] arr = new int[7000];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = rand.nextInt();
		}

		long startTime = System.nanoTime();
		sort(arr, (arr.length - 1));
		long endTime = System.nanoTime();

		System.out.println("Execution time: " + (endTime - startTime) + " ns");
	}

}