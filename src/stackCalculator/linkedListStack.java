package stackCalculator;


public class linkedListStack {
	
	public class Node {	
	    String data;
        Node nextNode = null; //다음 노드
    }
	
	public class LinkedListStack {
		//int capacity; //스택 용량 ==> 배열이 아니기 때문에 필요없음
	    //int top; //노드 배열 최상위 인덱스
	    Node headNode;
        Node topNode;
    }
   
    /**
      * 스택 생성 
     **/
	public LinkedListStack createStack(LinkedListStack stack) {
		stack = new LinkedListStack(); //스택 메모리 생성
        stack.headNode = null;
        stack.topNode = null;
        return stack;
    }
   
    /**
      * 노드 생성
      * @param newData 
     **/
	public Node createNode(String newData) {
		Node newNode = new Node();
        newNode.data = newData;
        newNode.nextNode = null; //다음 노드 초기화 
        
        return newNode;
    }
   
    /**
      * 스택 데이터 저장
     **/
	public void Push(LinkedListStack stack, Node newNode) {
		if(stack.headNode == null) { //첫 노드라면 헤드노드는 newNode다.
			stack.headNode = newNode;
		}else {
			stack.topNode.nextNode = newNode; //스택의 최상단 노드의 다음노드도 newNode
        }
		
		stack.topNode = newNode; //스택의 최상단 노드는 newNode가 된다.
		
	}
	
	/**
	  * 가장 최근에 넣은 데이터부터 반환(LIFO)
	 **/
	public Node Pop(LinkedListStack stack) {
		//가장 최근에 들어온 노드가 반환된다.  
		Node currentNode = stack.headNode;
		Node oldTopNode = stack.topNode;
		
		if(currentNode == oldTopNode) { //헤드노드와 최상단 노드가 같다면
			stack.headNode = null;
			stack.topNode = null;
			return oldTopNode;
		}
		
		while(currentNode.nextNode != oldTopNode) { //반환할 노드의 전 노드를 찾는다.
			currentNode = currentNode.nextNode;
		}
		
		stack.topNode = currentNode; //스택의 최상단 노드는 반환되는 노드의 전노드가 된다.
		currentNode.nextNode = null;
		
		return oldTopNode;
		
	}
	
	/**
      * 스택 메모리 갯수 반환 
     **/
	public int getSize(LinkedListStack stack) {
		int count = 0;
		
		Node currentNode = stack.headNode;
		
		while(currentNode != null) { 
			count++;
			currentNode = currentNode.nextNode; //다음 노드로 이동	
		}
		
		return count;
		
	}
   
   /**
     * 스택 비어져있는지 여부 반환 
    **/
   public boolean isEmpty(LinkedListStack stack) {
      return stack.headNode == null;
   }
   
   /**
     * 스택 상태 출력 
    **/
   public void printStackStatus(LinkedListStack stack) {
      System.out.println("print stack status...\n");
      System.out.println("stack size : " + getSize(stack));
      System.out.println("stack is empty? : " + isEmpty(stack));
      
      if(!isEmpty(stack)) {
    	  System.out.println("stack first data : " + stack.headNode.data);
    	  System.out.println("stack last data : " + stack.topNode.data);
      }
      
   }
}