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

class DoubleLinkedQueue implements Queue{ // ============================================
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

	public void insertFront (char item) {
		NewNode newNode = new NewNode();
		newNode.data = item;
		
		if (isEmpty()) {
			front = newNode;
			rear = newNode;	
			newNode.llink = null;
			newNode.rlink = null;
		} else {
			front.llink = newNode;
			newNode.rlink = front;
			newNode.llink = null;
			front = newNode;
		}
		
		System.out.println("Front Inserted Item : " + item);
	}
	
	public void insertRear (char item) {
		NewNode newNode = new NewNode();
		newNode.data = item;
		
		if (isEmpty()) {
			rear = newNode;
			front = newNode;	
			newNode.llink = null;
			newNode.rlink = null;
		} else {
			rear.rlink = newNode;
			newNode.rlink = null;
			newNode.llink = rear;
			rear = newNode;
		}
		
		System.out.println("Rear Inserted Item : " + item);
	}
	
	public char deleteFront() {
		if (isEmpty()) {
			System.out.println("Front Deleting fail! DQueue is empty!");
			return 0;
		}
		else {
			char item = front.data;
			if (front.rlink == null) {
				front = null;
				rear = null;
			}
			else {
				front = front.rlink;
				front.llink = null;
			}
			return item;
		}
	}
	
	public char deleteRear() {
		if (isEmpty()) {
			System.out.println("Rear Deleting fail! DQueue is empty!");
			return 0;
		}
		else {
			char item = rear.data;
			if (rear.llink == null) {
				rear = null;
				front = null;
			}
			else {
				rear = rear.llink;
				rear.rlink = null;
			}
			
			return item;
		}
	}
	
	public void removeFront() {
		if (isEmpty()) {
			System.out.println("Front Removing fail! DQueue is empty!");
		}
		else {
			if (front.rlink == null) {
				front = null;
				rear = null;
			}
			else {
				front = front.rlink;
				front.llink = null;
			}
		}
	}
	
	public void removeRear() {
		if (isEmpty()) {
			System.out.println("Rear Removing fail! DQueue is empty!");
		}
		else {
			if (rear.llink == null) {
				rear = null;
				front = null;
			}
			else {
				rear = rear.llink;
				rear.rlink = null;
			}
		}
	}
	
	public char peekFront() {
		if (isEmpty()) {
			System.out.println("Front Peeking fail! Double Linked Queue is empty");
			return 0;
		} else {
			return front.data;
		}
	}
	
	public char peekRear() {
		if (isEmpty()) {
			System.out.println("Rear Peeking fail! Double Linked Queue is empty");
			return 0;
		} else {
			return rear.data;
		}
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

class Ex8_DoubleLinkedQueue_Deque {
	public static void main(String args[]) {

		char deletedItem;
		DoubleLinkedQueue DLQ = new DoubleLinkedQueue();

//		DLQ.enQueue('A');
		DLQ.insertFront('A');
		DLQ.printQueue();

//		DLQ.enQueue('B');
		DLQ.insertFront('B');
		DLQ.printQueue();
		
		DLQ.insertRear('C');
		DLQ.printQueue();
		
		deletedItem = DLQ.deleteFront();
		if (deletedItem != 0)
			System.out.println("Front deleted Item : " + deletedItem);
		DLQ.printQueue();
		
		deletedItem = DLQ.deleteFront();
		if (deletedItem != 0)
			System.out.println("Front deleted Item : " + deletedItem);
		DLQ.printQueue();
		
		DLQ.insertRear('D');
		DLQ.printQueue();
		
		DLQ.insertFront('E');
		DLQ.printQueue();
		
		DLQ.insertFront('F');
		DLQ.printQueue();

		System.out.println("peek : " + DLQ.peek());
		System.out.println("isEmpty : " + DLQ.isEmpty());
		System.out.println();
		
	} // main 메소드의 끝
} // Ex8_CircleQueue 클래스의 끝
