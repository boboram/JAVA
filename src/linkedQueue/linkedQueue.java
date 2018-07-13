package linkedQueue;

public class linkedQueue {
	
	class Node {
		int data;
		Node nextNode;
	}
	
	class LinkedQueue {
		Node headNode; //전단 노드
		Node rearNode; //후단 노드
		int count = 0; //큐 데이터 갯수
	}

	public static void main(String[] args) {
		linkedQueue lq = new linkedQueue();
		LinkedQueue linkedQueue = null;
		
		//링크드 큐 생성
		System.out.println("create Linked Queue...");
		linkedQueue = lq.createLinkedQueue(linkedQueue);
		
		//데이터 삽입 
		System.out.println("\ninsert data...");
		for(int i=0; i<10; i++) {
			System.out.println("enqueue : " + i);
			lq.enQueue(linkedQueue, i);
		}
		
		//데이터 제거
		System.out.println("\ndelete data...");
		for(int i=0; i<10; i++) {
			System.out.println("dequeue : " + lq.deQueue(linkedQueue));
		}
		
		//데이터 삽입
		System.out.println("\ninsert data...");
		System.out.println("enqueue : 10");
		lq.enQueue(linkedQueue, 10);
		System.out.println("enqueue : 11");
		lq.enQueue(linkedQueue, 11);
		
		//링크드 큐 소멸
		linkedQueue = null;
	}
	
	LinkedQueue createLinkedQueue(LinkedQueue linkedQueue) {
		linkedQueue = new LinkedQueue();
		linkedQueue.headNode = null;
		linkedQueue.rearNode = null;
		linkedQueue.count = 0;
		
		return linkedQueue;
		
	}
	
	Node createNode(int newData) {
		Node newNode = new Node();
		newNode.data = newData;
		newNode.nextNode = null;
		
		return newNode;
		
	}
	
	boolean isEmpty(LinkedQueue linkedQueue) {
		return linkedQueue.count == 0;
		
	}
	
	void enQueue(LinkedQueue linkedQueue, int newData) {
		Node newNode = createNode(newData);
		
		if(linkedQueue.headNode == null) {
			linkedQueue.headNode = newNode;
			linkedQueue.rearNode = newNode;
		}else {
			linkedQueue.rearNode.nextNode = newNode; //전노드의 다음 연결노드를 newNode로 합니다. 
			//위 코드의 rearNode는 전노드
			
			linkedQueue.rearNode = newNode; //후단 노드를 newNode로 수정합니다.
			//위 코드의 rearNode는 newNode
		}
		
		linkedQueue.count++;
	}
	
	int deQueue(LinkedQueue linkedQueue) {
		if(isEmpty(linkedQueue)) {
			System.out.println("Queue is empty.....");
			return 0;
		}else {
			Node deQueue = linkedQueue.headNode;
			linkedQueue.headNode = deQueue.nextNode; //큐의 전단노드는 제거되는 노드의 다음 노드가 됩니다.
			deQueue.nextNode = null; 
			linkedQueue.count--; //큐의 카운트를 하나 감소시킵니다.
			
			return deQueue.data;
		}
		
	}

}
