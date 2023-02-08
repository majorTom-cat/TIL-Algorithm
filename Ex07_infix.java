package ex07_infix;

import java.util.Scanner;

interface Stack {
	boolean isEmpty();
	void push(int item);
	int pop();
	void delete();
	int peek();
} // Stack 인터페이스의 끝

class StackNode {
	int data;
	StackNode link;
} // ============================================================================================

class LinkedStack implements Stack {

	private StackNode top;

	public LinkedStack() {
	}

	@Override
	public boolean isEmpty() { // 빈 스택인지 체크
		return (top == null);
	}

	@Override
	public void push(int item) { // 데이터 삽입
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
		System.out.println("Inserted Item : " + newNode.data);
	}

	@Override
	public int pop() { // 데이터 삭제(데이터 반환후)
		if (isEmpty()) {
			System.out.println("poping fail! Array Stack is empty");
			return 0;
		} else {
			int item = top.data;
			top = top.link;

			System.out.println("Poped Item : " + item);

			return item;
		}
	}

	@Override
	public void delete() { // 데이터만 삭제(반환값 없음)
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty");
		} else {
			top = top.link;
		}
	}

	@Override
	public int peek() { // 스택 포인터(top) 위치 데이터 값만 반환
		if (isEmpty()) {
			System.out.println("peeking fail! Array Stack is empty");
			return 0;
		} else {
			return top.data;
		}
	}

	public void printStack() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty");
		} else {
			StackNode printNode = top;
			System.out.println("Linked Stack>> ");
			while (printNode != null) {
				System.out.printf("%c ", printNode.data);
				printNode = printNode.link;
				System.out.println();
			}
		}
	}

} // LinkedStack 클래스의 끝 =======================================================================

class OptExp {
	private String exp;
	private int expSize;
	private char testCh, openPair;

	public int evalPostfix(String postfix) {
		LinkedStack S = new LinkedStack();
		StringBuilder val = new StringBuilder();
		exp = postfix;
		int opr1, opr2, value;
		char testCH;

		for (int i = 0; i < postfix.length(); i++) {
			testCH = exp.charAt(i);

			if (testCH != '+' && testCH != '-' && testCH != '*' && testCH != '/') {
				if (testCH >= '0' && testCH <= '9') // testCH의 값이 정수범위 일때 48('0'), 57('9')
				{
					val.append(testCH); // 수치문자를 val에 추가 저장
					continue;
				}
				if (val.length() != 0) // testCH값이 +-*/ 와 0~9가 아닌 경우(공백문자)
				{
					value = Integer.parseInt(val.toString()); // 수치문자열을 숫자로 변환
					S.push(value); // 수치문자열을 숫자로 변환한 값 스택에 저장
					val.delete(0, val.length()); // val 문자열 객체를 초기화 시킴
				}

			} else {
				opr2 = S.pop();
				opr1 = S.pop();
				switch (testCH) {
				case '+':
					S.push(opr1 + opr2);
					break;
				case '-':
					S.push(opr1 - opr2);
					break;
				case '*':
					S.push(opr1 * opr2);
					break;
				case '/':
					S.push(opr1 / opr2);
					break;
				} // switch 의 끝

			} // else 의 끝

		} // for 문의 끝

		return S.pop();
	} // ==================================================================================

	public String infixTopostfix(String infix) {
		char testCh;
		StringBuilder postfix = new StringBuilder();
		LinkedStack S = new LinkedStack();

		for (int i = 0; i < infix.length(); i++) {

			testCh = infix.charAt(i);

			switch (testCh) { // ((3*5)-(6/2))

			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				postfix.append(testCh);
				break;
			case '+':
			case '-':
			case '*':
			case '/':
				postfix.append(' '); // 각 오퍼랜드의 값을 구분하기 위한 구분자로 사용
				S.push(testCh);
				break;
			case ')':
				postfix.append(' '); // 각 오퍼랜드의 값을 구분하기 위한 구분자로 사용
				postfix.append((char) S.pop());
				break;

			default:
			}
		}

		return postfix.toString();
	} // ========================================================================================

	public boolean testPair(String exp) {

		this.exp = exp;
		LinkedStack S = new LinkedStack();
		expSize = this.exp.length();
		for (int i = 0; i < expSize; i++) {
			testCh = this.exp.charAt(i);
			switch (testCh) {
			case '(':
			case '{':
			case '[':
				S.push(testCh);
				break;
			case ')':
			case '}':
			case ']':
				if (S.isEmpty())
					return false;
				else {
					openPair = (char) S.pop();
					if ((openPair == '(' && testCh != ')') || (openPair == '{' && testCh != '}') || (openPair == '[' && testCh != ']'))
						return false;
					else
						break;
				}

			}

		}

		if (S.isEmpty())
			return true;
		else
			return false;

	} // testPair 메소드의 끝 ==================================================================

} // =============================================================================================

public class Ex07_infix {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		OptExp opt = new OptExp();
		String exp = null;
		String postfix = null;

		System.out.println("괄호를 포함한 수식을 입력하세요");
		exp = scan.next(); // "((3*5)-(6/2))";

		System.out.println(exp);
		System.out.println();

		if (opt.testPair(exp)) {
			System.out.println("괄호 맞음!");
		} else {
			System.out.println("괄호 틀림!!!");
			return; // main 메소드의 return은 실행종료를 의미
		}

		System.out.println("\n후위표기식 : " + opt.infixTopostfix(exp));
		postfix = opt.infixTopostfix(exp);
		System.out.println(postfix);
		System.out.println("\n연산결과 = " + opt.evalPostfix(postfix));
	}

} // StringTokenizer나 split으로도 코드 구현 가능
