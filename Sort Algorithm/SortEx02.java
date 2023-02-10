package sort;

import java.util.Scanner;

public class SortEx02 {

	public static void main(String[] args) { // Fibonacci
//		ArrayList<Integer> list = new ArrayList<Integer>();
//
//		int first = 1;
//		int second = 1;
//
//		list.add(first);
//		list.add(second);

		Scanner scan = new Scanner(System.in);

		System.out.print("숫자 입력 => ");
		int input = scan.nextInt();

		int result = fibonacci(input);
		
		System.out.println();
		System.out.println("resunt = " + result);
//		int temp = 0;
//		for (int i = 2; i <= input; i++) {
//			temp = list.get(i - 1) + list.get(i - 2);
//			list.add(temp); // list.get(i) 하면 temp 가 나올것
//		}
//
//		for (int i = 0; i < input; i++) {
//			System.out.print(list.get(i) + " ");
//		}

		//		int n, i=0;
		//		int num1=0,num2=1,sum=1;
		//		System.out.printf("정수를 입력하세요 => ");
		//		n = scan.nextInt();
		//		
		//		System.out.println();
		//		for (i = 0; i<n; i++) {
		//			System.out.printf("%d  ", sum);
		//			sum=num1 +num2;
		//			num1=num2;
		//			num2=sum;
		//		}



	} // main 메소드의 끝

	static int fibonacci(int input) {
		int num1=0,num2=1,sum=1;
		int value;
		if (input == 1) {
			System.out.print(1 + " ");
			return 1;
		} 
		else if (input == 2) {
			System.out.print(1 + " ");
			return 1;
		}
		else {
//			System.out.printf("\n fact(%d)함수 호출!", input);
			value = (fibonacci(input-1));
			System.out.print(value + " ");
			return value;
		}
	}

}
