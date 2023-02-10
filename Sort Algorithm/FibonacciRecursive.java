package sort;

import java.util.Scanner;

public class FibonacciRecursive {

	public static void main(String[] args) {
		int n, i = 0;
		Scanner scan = new Scanner(System.in);

		System.out.printf("정수를 입력하세요 => ");
		n = scan.nextInt();

		System.out.println();
		for (i = 0; i < n; i++)
			System.out.printf("%d  ", fibonacci(i));

	}

	static int fibonacci(int n) {
		if (n <= 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
