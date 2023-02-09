package ex08_linkedqueue;

interface Queue {
	boolean isEmpty();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
} // Stack 인터페이스의 끝

class NewNode {
	char data;
	NewNode link;
}

class LinkedQueue implements Queue { // ============================================================
	NewNode front;
	NewNode rear;

	public LinkedQueue() {
		front = null;
		rear = null;
	}

	@Override
	public boolean isEmpty() { // 빈 큐인지 체크
		return (front == null);
	}

//	public boolean isFull() { // 가득찬 큐인지 체크
//
//		return ( (rear + 1) % this.QueueSize == front);
//	}

	@Override
	public void enQueue(char item) { // 데이터 삽입
		NewNode newNode = new NewNode();
		newNode.data = item;
		newNode.link = null;
		
		if (isEmpty()) {
			rear = newNode;
			front = newNode;	
		} else {
			rear.link = newNode;
			rear = newNode;
		}
		
		System.out.println("Inserted Item : " + item);
	}

	@Override
	public char deQueue() { // 데이터 삭제(데이터 반환후)
		if (isEmpty()) {
			System.out.println("DeQueueing fail! Linked Queue is empty");
			return 0; // 리턴 타입때문에 0 줌
		} else {
			char itemdata = front.data;
			front = front.link;
			if (isEmpty()) {
				rear = null;
			}
			return itemdata;
		}
	}

	@Override
	public void delete() { // 데이터만 삭제(반환값 없음)

		if (isEmpty()) {
			System.out.println("Deleting fail! Linked Queue is empty");
		}
		else {
			front = front.link;
			if (isEmpty()) { // if (front == null)
				rear = null;
			}
		}
	}

	@Override
	public char peek() { // front 포인터 위치 데이터 값만 반환
		if (isEmpty()) {
			System.out.println("peeking fail! Linked Queue is empty");
			return 0;
		} else {
			return front.data;
		}
	}

	public void printQueue() { // 큐 내용을 순서대로 출력(배열의 내용을 순서대로 출력)

		if(isEmpty())
			System.out.println("Linked Queue is empty");
//		else {
//			NewNode temp = front;
//			System.out.printf("Linked Queue >> ");
//			
//			while(temp != rear) {
//				System.out.printf("%c  ", temp.data);
//				temp = temp.link;
//			}
//			
//			if (temp == rear)
//				System.out.printf("%c  ", temp.data);
//			System.out.println();
//		}
		else {
			NewNode temp = front;
			System.out.printf("Linked Queue >> ");
			while (temp != null) {
				System.out.printf("%c  ", temp.data);
				temp = temp.link;
			}
			System.out.println();System.out.println();
		}
		
	}
} // CircleQueue 클래스의 끝 =========================================================================

class Ex8_LinkedQueue {
	public static void main(String args[]) {

		char deletedItem;
		LinkedQueue LQ = new LinkedQueue();

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
