package circularLinkedList;

/**
 * @author boram
 *  환형 연결리스트 구현하기(자료구조)
 **/
public class CircularLinkedList  {
   
   public Node headNode; //헤드 노드
   
   public class Node{ //C의 구조체 대신에 클래스 사용
      public int data; //입력 데이터
      public Node prevNode; //이전 연결 노드
      public Node nextNode; //다음 연결될 노드
      
      Node(int data){ //노드 데이터는 노드 객체 생성시 같이 넣어주도록 한다.
         this.data = data;
      }
      
   }
   
   /**
    * 노드 생성(처음)
    * @param newData
    * */
   public Node createNode(int newData) {
      Node newNode = new Node(newData); //새로운 노드 생성후 데이터 넣기
      
      newNode.prevNode = null; //이전 연결 노드 null로 초기화
      newNode.nextNode = null; //다음 연결 노드는 null로 초기화
      
      return newNode;
      
   }
   
   
   /**
    * 노드 추가
    * */
   public void appendNode(Node newNode) {
      
      if(headNode == null) { //헤드 노드가 비어져 있는경우
         headNode = newNode;
         headNode.nextNode = newNode;
         headNode.prevNode = newNode;
         
      } else {
        //테일 노드와 헤드 노드 사이에 새로운 노드를 추가한다
        Node tailNode = headNode.prevNode;
        
        tailNode.nextNode.prevNode = newNode;
        tailNode.nextNode = newNode;
        
        newNode.nextNode = headNode;
        newNode.prevNode = tailNode;
      }
      
   }
   
   /**
    * 특정 노드의 다음 노드 추가
    * */
   public void insertAfter(Node currentNode, Node newNode) {
     /*
      headNode <-> currentNode <-> tailNode 순으로 노드가 존재했다고 가정하면
      현재 newNode는 currentNode 이후에 추가되야하므로 아래와 같다
      headNode <-> currentNode <-> newNode <-> tailNode
      따라서 newNode의 이전 노드는 currentNode가 되고 다음 노드는 tailNode가 되고
      currentNode의 다음 노드인 tailNode의 이전 노드는 newNode를 바라보고
      currentNode의 다음 노드는 newNode를 바라본다
     */
      
      newNode.prevNode = currentNode;
      newNode.nextNode = currentNode.nextNode;
      
      if(currentNode.nextNode != null) { //특정노드의 다음 연결 노드가 있는 경우
         currentNode.nextNode.prevNode = newNode; //특정노드의 다음 연결노드의 이전노드를 새로운노드로 바꾼다.
      }
      
      currentNode.nextNode = newNode;
      
   }
   

   /**
    * 특정 위치의 노드 찾기
    * @param index
    * */
   public Node getNodeAt(int index) {     
      Node x = headNode;
      
      for(int i=0; i<index; i++) { //찾고자 하는 Node의 순서까지 연결노드를 가져온다. head->node(1)->--->node(index)~~~
         x = x.nextNode;
      }
      
      return x; //찾고자 한 노드 리턴
      
   }
   
   /**
    * 노드 갯수 얻기
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
    * 노드 제거
    * @param removeNode
    * */
   public void removeNode(Node removeNode) {
      
       if(headNode == removeNode) { //지우고자 하는 노드가 헤드노드라면
    	   removeNode.prevNode.nextNode = removeNode.nextNode;
    	   removeNode.nextNode.prevNode = removeNode.prevNode;
    	   
           headNode = removeNode.nextNode; //헤드노드는 지우고자 하는 노드의 다음 노드를 바라보도록 한다.
           
           removeNode.prevNode = null;
           removeNode.nextNode = null; 
       } else {
           //지우려하는 노드의 이전, 다음 노드가 있기 때문에 반복문으로 전단계 노드를 찾지 않아도 됩니다.!
           if(removeNode.prevNode!=null) {
              removeNode.prevNode.nextNode = removeNode.nextNode;
           }
           
           if(removeNode.nextNode!=null) {
              removeNode.nextNode.prevNode = removeNode.prevNode;
           }
                      
       }
       
   }
   
   /**
    * 단일 노드 출력
    * @param node
    * */
   public void printNodeOne(Node node) {
      System.out.println("current node data >> " + node.data);
   }
   
   /**
    * 전체 노드 출력
    * */
   public void printfNodeList() {
      Node currentNode = null;
      int count = getNodeCount(); //list에 담긴 노드 개수
      
      for (int i = 0; i < count; i++) {
         currentNode = getNodeAt(i); //i번째에 위치한 노드를 가져온다
         System.out.println("list["+i+"] : " + currentNode.data);
      }
   }
   
}