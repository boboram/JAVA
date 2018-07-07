package circularLinkedList;

/**
 * @author boram
 *  ȯ�� ���Ḯ��Ʈ �����ϱ�(�ڷᱸ��)
 **/
public class CircularLinkedList  {
   
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
         headNode.nextNode = newNode;
         headNode.prevNode = newNode;
         
      } else {
        //���� ���� ��� ��� ���̿� ���ο� ��带 �߰��Ѵ�
        Node tailNode = headNode.prevNode;
        
        tailNode.nextNode.prevNode = newNode;
        tailNode.nextNode = newNode;
        
        newNode.nextNode = headNode;
        newNode.prevNode = tailNode;
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
     
     Node currentNode = headNode;
     
     Node list = headNode;
     
     while(list != null) {
    	
    	if(currentNode == list && count>0) 
    		break;
    	
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
    	   removeNode.prevNode.nextNode = removeNode.nextNode;
    	   removeNode.nextNode.prevNode = removeNode.prevNode;
    	   
           headNode = removeNode.nextNode; //������ ������� �ϴ� ����� ���� ��带 �ٶ󺸵��� �Ѵ�.
           
           removeNode.prevNode = null;
           removeNode.nextNode = null; 
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