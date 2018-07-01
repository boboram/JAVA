package linkedList;

/**
 * @author boram
 * ���Ḯ��Ʈ �����ϱ�(�ڷᱸ��)
 **/
public class LinkedList {
   
   public Node headNode; //��� ���
   private int count = 0; //��� ����
   
   public class Node{ //C�� ����ü ��ſ� Ŭ���� ���
      public int data; //�Է� ������
      public Node nextNode; //���� ����� ���
      
      Node(int data){ //��� �����ʹ� ��� ��ü ������ ���� �־��ֵ��� �Ѵ�.
         this.data = data;
      }
      
   }
   
   /**
    * ��� ����(ó��)
    * @param newData
    * */
   public Node createNode(int newData) {
      Node newNode = new Node(newData); //���ο� ��� ������ ������ �ֱ�
      
      newNode.nextNode = null; //���� ���� ���� null�� �ʱ�ȭ
      
      return newNode;
      
   }
   
   
   /**
    * ��� �߰�
    * */
   public void appendNode(Node newNode) {
      if(headNode == null) { //��� ��尡 ����� �ִ°��
         headNode = newNode;
      }else {
         Node beforeNode = getNodeAt(count-1); //������ ������ ��带 �����´�
         
         beforeNode.nextNode = newNode; //���� ����� ���ḵũ�� �� ���� ���ش�.
      }
      
      count++;
      
   }
   
   /**
    * Ư�� ����� ���� ��� �߰�
    * */
   public void insertAfter(Node currentNode, Node newNode)
   {
      /*
         headNode -> currentNode -> tailNode ������ ��尡 �����ߴٰ� �����ϸ�
         ���� newNode�� currentNode ���Ŀ� �߰��Ǿ��ϹǷ� �Ʒ��� ����
         headNode -> currentNode -> newNode -> tailNode
         ���� newNode�� ���� ���� tailNode�� �ٶ���� �ϸ�
         currentNode�� ���� ���� tailNode���� newNode�� �ٲ��
      */
      
      newNode.nextNode = currentNode.nextNode;
      currentNode.nextNode = newNode;
      
      count++;
   }
   
   /**
    * ��� ��� �߰�
    * @param newHeadNode
    * */
   public void insertNewHead(Node newHeadNode) {
      if(headNode == null) { //head��尡 ���� ��� ���� ����
         headNode = newHeadNode;
      }else {
         /*
          headNode -> Node -> tailNode������ ��尡 �����ߴٰ� �����ϸ�
          newHeadNode -> headNode -> Node -> tailNode�� �Ǿ� ��
         */
                  
         newHeadNode.nextNode = headNode; //newHeadNode�� ���� ���� headNode�� �ǰ�
         //head��� ���� �̹� �ڿ� ������ ������ ������
         
         headNode = newHeadNode; //���� headNode�� ���̻� ��� ��尡 �ƴϹǷ� ��� ��带 newHeadNode�� �����Ѵ�
      }
      
      count++;
   }
   
   /**
    * Ư�� ��ġ�� ��� ã��
    * @param index
    * */
   public Node getNodeAt(int index) {	  
      Node x = headNode;
      
      for(int i=0; i<index; i++) { //ã���� �ϴ� Node�� �������� �����带 �����´�. head->node(1)->--->node(index)~~~
         x = x.nextNode;
      }
      
      return x; //ã���� �� ��� ����
      
   }
   
   /**
    * ��� ���� ���
    * */
   public int getNodeCount() {
      return count;
      
   }
   
   /**
    * ��� ����
    * @param removeNode
    * */
   public void removeNode(Node removeNode) {
      
       if(headNode == removeNode) { //������� �ϴ� ��尡 �������
           headNode = removeNode.nextNode; //������ ������� �ϴ� ����� ���� ��带 �ٶ󺸵��� �Ѵ�.
       } else {
           Node removeBeforeNode = headNode; //������� �ϴ� ��带 �����ϰ� �ִ� ���
           
           while(removeBeforeNode!=null && removeBeforeNode.nextNode != removeNode) { 
        	  //������� �ϴ� ����� �� ��� ��, ������� �ϴ� ��带 �ٶ󺸴� ��带 ã�´�.
              removeBeforeNode = removeBeforeNode.nextNode;
           }
           
           if(removeBeforeNode != null) {              
              removeBeforeNode.nextNode = removeNode.nextNode; 
              //������� �ϴ� ��带 �ٶ󺸴� ����� ������尡 ��������ϴ� ����� ���� ��带 �ٶ󺸵��� �Ѵ�.
              //before : beforeNode -> removeNode -> nextNode
              //after : beforeNode -> nextNode
           }
           
       }
       
       count--; //��� �ϳ� �����߱⶧���� ������ �ϳ� ����   
       
   }
   
   /**
    * ���� ��� ���
    * @param node
    * */
   public void printNodeOne(Node node) {
	   System.out.println("current node data >> " + node.data);
   }
   
   /**
    * ��ü ��� ���
    * */
   public void printfNodeList() {
	   Node currentNode = null;
	   int count = getNodeCount(); //list�� ��� ��� ����
	
	   for (int i = 0; i < count; i++) {
		   currentNode = getNodeAt(i); //i��°�� ��ġ�� ��带 �����´�
		   System.out.println("list["+i+"] : " + currentNode.data);
	   }
   }
   
}