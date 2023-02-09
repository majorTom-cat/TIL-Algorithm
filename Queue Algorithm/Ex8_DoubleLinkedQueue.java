package ex08_doubleLinkedQueue;

interface Queue {
	boolean isEmpty();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
} // Stack 인터페이스의 끝

class NewNode {
	char data;
	NewNode llink;
	NewNode rlink;
}

class DoubleLinkedQueue implements Queue { // ============================================================
	NewNode front;
	NewNode rear;

	public DoubleLinkedQueue() {
		front = null;
		rear = null;
	}

	@Override
	public boolean isEmpty() { // 빈 큐인지 체크
		return (front == null);
	}

	@Override
	public void enQueue(char item) { // 데이터 삽입
		NewNode newNode = new NewNode();
		newNode.data = item;
		newNode.llink = null;
		newNode.rlink = null;
		
		if (isEmpty()) {
			rear = newNode;
			front = newNode;	
		} else {
			rear.rlink = newNode;
			rear.rlink.llink = rear;
			rear = newNode;
		}
		
		System.out.println("Inserted Item : " + item);
	}

	@Override
	public char deQueue() { // 데이터 삭제(데이터 반환후)
		if (isEmpty()) {
			System.out.println("DeQueueing fail! Double Linked Queue is empty");
			return 0; // 리턴 타입때문에 0 줌
		} else {
			char itemdata = front.data;
			
			if (front.rlink == null) {
				front = front.rlink;
			} else {
				front.rlink.llink = null;
				front = front.rlink;
			}
			if (isEmpty()) {
				rear = null;
			}
			return itemdata;
		}
	}

	@Override
	public void delete() { // 데이터만 삭제(반환값 없음)

		if (isEmpty()) {
			System.out.println("Deleting fail! Double Linked Queue is empty");
		}
		else {
			if (front.rlink == null) {
				front = front.rlink;
			} else {
				front.rlink.llink = null;
				front = front.rlink;
			}
			if (isEmpty()) { // if (front == null)
				rear = null;
			}
		}
	}

	@Override
	public char peek() { // front 포인터 위치 데이터 값만 반환
		if (isEmpty()) {
			System.out.println("peeking fail! Double Linked Queue is empty");
			return 0;
		} else {
			return front.data;
		}
	}

	public void printQueue() { // 큐 내용을 순서대로 출력(배열의 내용을 순서대로 출력)

		if(isEmpty())
			System.out.println("Double Linked Queue is empty");
		else {
			NewNode temp = front;
			System.out.printf("Double Linked Queue >> ");
			while (temp != null) {
				System.out.printf("%c  ", temp.data);
				temp = temp.rlink;
			}
			System.out.println();System.out.println();
		}
		
	}
} // CircleQueue 클래스의 끝 =========================================================================

class Ex8_DoubleLinkedQueue {
	public static void main(String args[]) {

		char deletedItem;
		DoubleLinkedQueue DLQ = new DoubleLinkedQueue();

		DLQ.enQueue('A');
		DLQ.printQueue();

		DLQ.enQueue('B');
		DLQ.printQueue();
		
		deletedItem = DLQ.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		DLQ.printQueue();

		DLQ.enQueue('C');
		DLQ.printQueue();

		System.out.println("peek : " + DLQ.peek());
		System.out.println("isEmpty : " + DLQ.isEmpty());
		System.out.println();
		
		DLQ.enQueue('D');
		DLQ.printQueue();
		
		deletedItem = DLQ.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		DLQ.printQueue();
		
		deletedItem = DLQ.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		DLQ.printQueue();
		
		deletedItem = DLQ.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		DLQ.printQueue();

		deletedItem = DLQ.deQueue();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		DLQ.printQueue();
		
	} // main 메소드의 끝
} // Ex8_CircleQueue 클래스의 끝
