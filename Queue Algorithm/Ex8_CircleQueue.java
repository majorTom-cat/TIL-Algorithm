package ex08_circleQueue;

interface Queue {
	boolean isEmpty();
	boolean isFull();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
} // Stack 인터페이스의 끝

class LinkedQueue implements Queue { // ============================================================
	private int front; // 포인터
	private int rear;
	private int QueueSize;
	private char itemArray[]; // 큐로 사용될 배열

	public LinkedQueue(int QueueSize) {
		front = 0;
		rear = 0;
		this.QueueSize = QueueSize;
		itemArray = new char[this.QueueSize];
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
//		if (this.rear - 1 == QueueSize)
//			return true;
//		else 
//			return false;
		return ( (rear + 1) % this.QueueSize == front);
	}

	@Override
	public void enQueue(char item) { // 데이터 삽입
		if (isFull()) {
			System.out.println("Inserting fail! Array Queue is full!");
		} else {
			this.rear = (this.rear + 1) % this.QueueSize;
			itemArray[rear] = item;
			System.out.println("Inserted Item : " + item);
		}
	}

	@Override
	public char deQueue() { // 데이터 삭제(데이터 반환후)
		if (isEmpty()) {
			System.out.println("DeQueueing fail! Array Queue is empty");
			return 0; // 리턴 타입때문에 0 줌
		} else {
			this.front = (this.front + 1) % this.QueueSize;
			return itemArray[front];
		}
	
	}

	@Override
	public void delete() { // 데이터만 삭제(반환값 없음)
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty");
		}
		else {
			this.front = (this.front + 1) % this.QueueSize; // 혹은 ++front 도 상관 없음
		}
	}

	@Override
	public char peek() { // front 포인터 위치 데이터 값만 반환
		if (isEmpty()) {
			System.out.println("peeking fail! Array Queue is empty");
			return 0;
		} else {
//			return itemArray[front+1]; // 난 이걸 왜 이렇게 했지
			return itemArray[ (front + 1) % this.QueueSize];
		}
	}

	public void printQueue() { // 큐 내용을 순서대로 출력(배열의 내용을 순서대로 출력)

//		if (isEmpty()) {
//			System.out.println("Printing fail! Array Queue is empty");
//			return;
//		} else {
//			System.out.print("  Array Queue >> ");
//			
//			if (this.front < this.rear) {
//				for (int i = this.front + 1; i <= rear % this.QueueSize; i++) {
//					System.out.printf("%c    ",itemArray[i]);
//				}
//				System.out.println();
//				System.out.println();
//			} else {
//				for (int i = this.front + 1; i < this.QueueSize; i++) {
//					System.out.printf("%c    ",itemArray[i]);
//				}
//				for (int j = 0; j <= this.rear; j++) {
//					System.out.printf("%c    ",itemArray[j]);
//				}
//				System.out.println();
//				System.out.println();
//			}
//		}
		
		int num;
		num = rear - front;
		if (num < 0)
			num += this.QueueSize;
		
		if(isEmpty())
			System.out.println("Array circular Queue is empty");
		else {
			System.out.printf("Array Circular Queue >> ");
			for (int i = (front + 1) % this.QueueSize; i !=(rear + 1) % this.QueueSize; i=++i % this.QueueSize)
				System.out.printf("%c  ", itemArray[i]);
			System.out.println("\n데이터 수 = " + num);
			System.out.println();
		}
	}
} // CircleQueue 클래스의 끝 =========================================================================

class Ex8_CircleQueue {
	public static void main(String args[]) {
		int QueueSize = 3;
		char deletedItem;
		LinkedQueue LQ = new LinkedQueue(QueueSize);

		LQ.enQueue('A');
		LQ.printQueue();

		LQ.enQueue('B');
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();

		LQ.enQueue('C');
		LQ.printQueue();

		System.out.println("peek : " + LQ.peek());
		System.out.println("isEmpty : " + LQ.isEmpty());
		System.out.println("isFull : " + LQ.isFull());
		System.out.println();
		
		LQ.enQueue('D');
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();

		
	} // main 메소드의 끝
} // Ex8_CircleQueue 클래스의 끝
