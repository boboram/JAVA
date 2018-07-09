package linkedListStack;


public class linkedListStack {
	
	public class Node {	
	    String data;
        Node nextNode = null; //���� ���
    }
	
	public class LinkedListStack {
		//int capacity; //���� �뷮 ==> �迭�� �ƴϱ� ������ �ʿ����
	    //int top; //��� �迭 �ֻ��� �ε���
	    Node headNode;
        Node topNode;
    }
   
    /**
      * ���� ���� 
     **/
	public LinkedListStack createStack(LinkedListStack stack) {
		stack = new LinkedListStack(); //���� �޸� ����
        stack.headNode = null;
        stack.topNode = null;
        return stack;
    }
   
    /**
      * ��� ����
      * @param newData 
     **/
	public Node createNode(String newData) {
		Node newNode = new Node();
        newNode.data = newData;
        newNode.nextNode = null; //���� ��� �ʱ�ȭ 
        
        return newNode;
    }
   
    /**
      * ���� ������ ����
     **/
	public void Push(LinkedListStack stack, Node newNode) {
		if(stack.headNode == null) { //ù ����� ������ newNode��.
			stack.headNode = newNode;
		}else {
			stack.topNode.nextNode = newNode; //������ �ֻ�� ����� ������嵵 newNode
        }
		
		stack.topNode = newNode; //������ �ֻ�� ���� newNode�� �ȴ�.
		
	}
	
	/**
	  * ���� �ֱٿ� ���� �����ͺ��� ��ȯ(LIFO)
	 **/
	public Node Pop(LinkedListStack stack) {
		//���� �ֱٿ� ���� ��尡 ��ȯ�ȴ�.  
		Node currentNode = stack.headNode;
		Node oldTopNode = stack.topNode;
		
		if(currentNode == oldTopNode) { //������ �ֻ�� ��尡 ���ٸ�
			stack.headNode = null;
			stack.topNode = null;
			return oldTopNode;
		}
		
		while(currentNode.nextNode != oldTopNode) { //��ȯ�� ����� �� ��带 ã�´�.
			currentNode = currentNode.nextNode;
		}
		
		stack.topNode = currentNode; //������ �ֻ�� ���� ��ȯ�Ǵ� ����� ����尡 �ȴ�.
		currentNode.nextNode = null;
		
		return oldTopNode;
		
	}
	
	/**
      * ���� �޸� ���� ��ȯ 
     **/
	public int getSize(LinkedListStack stack) {
		int count = 0;
		
		Node currentNode = stack.headNode;
		
		while(currentNode != null) { 
			count++;
			currentNode = currentNode.nextNode; //���� ���� �̵�	
		}
		
		return count;
		
	}
   
   /**
     * ���� ������ִ��� ���� ��ȯ 
    **/
   public boolean isEmpty(LinkedListStack stack) {
      return stack.headNode == null;
   }
   
   /**
     * ���� ���� ��� 
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