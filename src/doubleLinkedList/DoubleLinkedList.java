package doubleLinkedList;

/**
 * @author boram
 * �����Ḯ��Ʈ �����ϱ�(�ڷᱸ��)
 **/
public class DoubleLinkedList  {
   
   public Node headNode; //��� ���
   
   public class Node{ //C�� ����ü ��ſ� Ŭ���� ���
      public int data; //�Է� ������
      public Node prevNode; //���� ���� ���
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
      
      newNode.prevNode = null; //���� ���� ��� null�� �ʱ�ȭ
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
         Node beforeNode = getNodeAt(getNodeCount()-1); //������ ������ ��带 �����´�
         
         beforeNode.nextNode = newNode; //���� ����� ���ḵũ�� �� ���� ���ش�.
         newNode.prevNode = beforeNode;
      }
      
   }
   
   /**
    * Ư�� ����� ���� ��� �߰�
    * */
   public void insertAfter(Node currentNode, Node newNode) {
     /*
      headNode <-> currentNode <-> tailNode ������ ��尡 �����ߴٰ� �����ϸ�
      ���� newNode�� currentNode ���Ŀ� �߰��Ǿ��ϹǷ� �Ʒ��� ����
      headNode <-> currentNode <-> newNode <-> tailNode
      ���� newNode�� ���� ���� currentNode�� �ǰ� ���� ���� tailNode�� �ǰ�
      currentNode�� ���� ����� tailNode�� ���� ���� newNode�� �ٶ󺸰�
      currentNode�� ���� ���� newNode�� �ٶ󺻴�
     */
      
      newNode.prevNode = currentNode;
      newNode.nextNode = currentNode.nextNode;
      
      if(currentNode.nextNode != null) { //Ư������� ���� ���� ��尡 �ִ� ���
         currentNode.nextNode.prevNode = newNode; //Ư������� ���� �������� ������带 ���ο���� �ٲ۴�.
      }
      
      currentNode.nextNode = newNode;
      
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
         headNode.nextNode.prevNode = headNode;
      }
      
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
	  int count = 0;
	  
	  Node list = headNode;
	  
	  while(list != null) {
		  list = list.nextNode;
		  count++;
	  }
	  
      return count;
      
   }
   
   /**
    * ��� ����
    * @param removeNode
    * */
   public void removeNode(Node removeNode) {
      
       if(headNode == removeNode) { //������� �ϴ� ��尡 �������
           headNode = removeNode.nextNode; //������ ������� �ϴ� ����� ���� ��带 �ٶ󺸵��� �Ѵ�.
           
           if(headNode != null && headNode.prevNode != null) { 
              headNode.prevNode = null;
           }
           
           removeNode.prevNode = null;
           removeNode.prevNode = null;
       } else {
           //������ϴ� ����� ����, ���� ��尡 �ֱ� ������ �ݺ������� ���ܰ� ��带 ã�� �ʾƵ� �˴ϴ�.!
           if(removeNode.prevNode!=null) {
              removeNode.prevNode.nextNode = removeNode.nextNode;
           }
           
           if(removeNode.nextNode!=null) {
              removeNode.nextNode.prevNode = removeNode.prevNode;
           }
                      
       }
       
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