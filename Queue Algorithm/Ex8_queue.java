package ex08;

interface Queue {
	boolean isEmpty();
	boolean isFull();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
} // Stack 인터페이스의 끝

class ArrayQueue implements Queue { // ============================================================
	private int front; // 포인터
	private int rear;
	private int queueSize;
	private char itemArray[]; // 큐로 사용될 배열

	public ArrayQueue(int queueSize) {
		front = -1;
		rear = -1;
		this.queueSize = queueSize;
		itemArray = new char[this.queueSize];
	}

	@Override
	public boolean isEmpty() { // 빈 큐인지 체크
//		if (this.front == this.rear)
//			return true;
//		else 
//			return false;
		return (front == rear);
	}

	@Override
	public boolean isFull() { // 가득찬 큐인지 체크
//		if (this.rear - 1 == queueSize)
//			return true;
//		else 
//			return false;
		return (rear == this.queueSize-1);
	}

	@Override
	public void enQueue(char item) { // 데이터 삽입
		if (isFull()) {
			System.out.println("Insertinf fail! Array Queue is full!");
		} else {
			itemArray[++rear] = item;
			System.out.println("Inserted Item : " + item);
		}
	}

	@Override
	public char deQueue() { // 데이터 삭제(데이터 반환후)
//		char returenedItem = this.itemArray[top];
////		this.itemArray[top] = null;
//		this.top -= 1;
//		return returenedItem;
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty");
			return 0; // 리턴 타입때문에 0 줌
		} else {
			return itemArray[++front];
		}
	
	}

	@Override
	public void delete() { // 데이터만 삭제(반환값 없음)
//		char returenedItem = this.itemArray[top];
//		this.top -= 1;
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty");
		}
		else {
			front++; // 혹은 ++front 도 상관 없음
		}
	}

	@Override
	public char peek() { // front 포인터 위치 데이터 값만 반환
//		char returenedItem = itemArray[top];
//		return returenedItem;
		if (isEmpty()) {
			System.out.println("peeking fail! Array Queue is empty");
			return 0;
		} else {
			return itemArray[front+1];
		}
	}

	public void printQueue() { // 큐 내용을 순서대로 출력(배열의 내용을 순서대로 출력)

		if (isEmpty()) {
			System.out.println("Printing fail! Array Queue is empty");
			return;
		} else {
			System.out.print("  Array Queue >> ");
			for (int i = front + 1; i <= rear; i++) {
				System.out.printf("%c    ",itemArray[i]);
			}
			System.out.println("\n    queueSize = " + (this.rear - this.front));
			System.out.println();
		}
	}
} // ArrayQueue 클래스의 끝 =========================================================================

class Ex8_queue {
	public static void main(String args[]) {
		int queueSize = 3;
		char deletedItem;
		ArrayQueue Q = new ArrayQueue(queueSize);

		Q.enQueue('A');
		Q.printQueue();

		Q.enQueue('B');
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		Q.printQueue();

		Q.enQueue('C');
		Q.printQueue();

		System.out.println("peek : " + Q.peek());

		System.out.println("isEmpty : " + Q.isEmpty());

		System.out.println("isFull : " + Q.isFull());
		
		deletedItem = Q.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		Q.printQueue();

		
	} // main 메소드의 끝
} // Ex8_queue 클래스의 끝
