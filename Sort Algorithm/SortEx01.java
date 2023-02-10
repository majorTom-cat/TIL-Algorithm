package sort;

import java.util.Scanner;

public class SortEx01 { // Factorial

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 입력 => ");
		int input = scan.nextInt();
		
		System.out.println();
		int res = 1;
		
//		System.out.print(input + "! = ");
//		for (int i = input; i >= 1; i--) {
//			res *= i;
//			System.out.print(i);
//			if ( i != 1)
//				System.out.print(" * ");
//		}
//		
//		System.out.println();
//		System.out.println(input + "!" + " = " + res);
		
		res = fact(input);
		System.out.printf("\n\n%d의 factorial 값은 %d입니다. \n", input, res);
		
	}
	
	static int fact(int input) {
		int value;
		if (input <= 1) {
			System.out.printf("\nfact(1)함수 호출!");
			System.out.printf("\nfact(1)값 1 반환!!");
			return 1;
		}
		else {
			System.out.printf("\n fact(%d)함수 호출!", input);
			value = (input * fact(input-1));
			System.out.printf("\n fact(%d)값 %d 반환!!", input, value);
			return value;
		}
		
	}

}
