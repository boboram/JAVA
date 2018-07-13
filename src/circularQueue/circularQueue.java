package circularQueue;

//순환큐(FIFO) : First In First Out
public class circularQueue {
	
	class CircularQueue {
		int capacity; //큐(배열) 크기
		int firstIndex; //전단 인덱스
		int rearIndex; //후단 인덱스
		int count; //현재 순환큐에 저장된 데이터 개수
		Node Nodes[]; //노드 배열
	}
	
	class Node {
		int data = 0;
	}

	public static void main(String[] args) {
		circularQueue cq = new circularQueue();
		CircularQueue circularQueue = null;
		
		//순환큐 생성
		System.out.println("create circularQueue...");
		circularQueue = cq.createCircularQueue(10); //10개의 데이터를 넣을 수 있는 순환큐 생성

		//데이터 삽입
		System.out.println("\ninsert data.....");
		for(int i=0; i<circularQueue.capacity; i++) {
			cq.enQueue(circularQueue, i);
		}
		
		cq.printQueueStatus(circularQueue);
		
		cq.enQueue(circularQueue, 100); //Queue is full!!
		
		//데이터 제거
		System.out.println("\ndelete data.....");
		for(int i=0; i<circularQueue.capacity; i++) {
			System.out.println("dequeue : " + cq.deQueue(circularQueue));
		}
		
		cq.printQueueStatus(circularQueue);
		
		//데이터 삽입
		System.out.println("\ninsert data.....");
		cq.enQueue(circularQueue, 10);
		System.out.println("enqueue : 10");
		cq.enQueue(circularQueue, 11);
		System.out.println("enqueue : 11");
		
		
		//데이터 제거
		System.out.println("\ndelete data.....");
		System.out.println("dequeue : " + cq.deQueue(circularQueue)); //10 delete
		System.out.println("dequeue : " + cq.deQueue(circularQueue)); //11 delete
		System.out.println("dequeue : " + cq.deQueue(circularQueue)); //Queue is empty!!
		System.out.println(circularQueue.count);
	}
	
	/**
	 * 순환 큐 생성
	 * @param capacity : 순환큐 갯수
	 * return circularQueue
	 **/
	CircularQueue createCircularQueue(int capacity) {
		CircularQueue circularQueue = new CircularQueue();
		circularQueue.Nodes = new Node[capacity+1]; //노드 배열 메모리 생성
		//circularQueue.Nodes[0] = null; 과 같은 형태로 되어져 있음
		
		circularQueue.capacity = capacity;
		circularQueue.firstIndex = 0;
		circularQueue.rearIndex = 0;
		circularQueue.count = 0;
		
		return circularQueue;
		
	}
	
	/**
	 * 순환큐 비어져 있는지 유무 판별
	 * @param circularQueue
	 * @return [boolean]
	 **/
	boolean isEmpty(CircularQueue circularQueue) {
		return circularQueue.firstIndex == circularQueue.rearIndex;
		//return circularQueue.count == 0; 으로 해도 될듯
		
	}
	
	/**
	 * 순환큐가 꽉 찼는지 유무 판별
	 * @param circularQueue
	 * @return [boolean]
	 **/
	boolean isFull(CircularQueue circularQueue) {
		return circularQueue.count == circularQueue.capacity;
		
	}
	
	/**
	 * 순환큐 데이터 삽입 
	 * @param circularQueue 
	 * @param newData : 새로 삽입할 데이터
	 **/
	void enQueue(CircularQueue circularQueue, int newData) {
		if(isFull(circularQueue)) {
			System.out.println("\nQueue is full!");
			
		}
		else {
			int position = circularQueue.rearIndex++; //circularQueue.rearIndex의 값만 넣어지고 circularQueue.rearIndex값은 ++됩니다
			
			if(circularQueue.rearIndex > circularQueue.capacity) //후단인덱스가 사용자가 설정한 크기보다 커지면 
				circularQueue.rearIndex = 0;
			
			circularQueue.Nodes[position] = new Node();
			circularQueue.Nodes[position].data = newData; //데이터 삽입
			circularQueue.count++; //순환큐 갯수 증가
			
		}
		
	}
	
	/**
	 * 순환큐 데이터 삭제 
	 * 처음에 넣은 값부터 삭제됩니다(FIFO : First In First Out) 
	 * @param circularQueue
	 * @return 삭제된 데이터
	 **/
	int deQueue(CircularQueue circularQueue) {
		if(isEmpty(circularQueue)) {
			System.out.println("Queue is Empty... there is no data for return...");
			return 0;
		}
		
		int position = circularQueue.firstIndex++;
		int data = 0;
		
		if(circularQueue.firstIndex > circularQueue.capacity)
			circularQueue.firstIndex = 0;
		
		circularQueue.count--;
		
		data = circularQueue.Nodes[position].data;
		circularQueue.Nodes[position] = null;
		
		return data;//circularQueue.Nodes[position].data;
		
	}
	
	void printQueueStatus(CircularQueue circularQueue) {
		System.out.println("\nprint queue status...\n");
		System.out.println("capacity : " + circularQueue.capacity);
		System.out.println("firstIndex : " + circularQueue.firstIndex);
		System.out.println("rearIndex : " + circularQueue.rearIndex);
		System.out.println("queue size : " + circularQueue.count);
		System.out.println("queue is empty? : " + isEmpty(circularQueue));
		System.out.println("queue is full? : " + isFull(circularQueue));
	}
	
}
