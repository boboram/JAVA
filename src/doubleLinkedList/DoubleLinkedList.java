package doubleLinkedList;

/**
 * @author boram
 * 더블연결리스트 구현하기(자료구조)
 **/
public class DoubleLinkedList  {
   
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
      }else {
         Node beforeNode = getNodeAt(getNodeCount()-1); //이전에 생성된 노드를 가져온다
         
         beforeNode.nextNode = newNode; //이전 노드의 연결링크를 새 노드로 해준다.
         newNode.prevNode = beforeNode;
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
    * 헤드 노드 추가
    * @param newHeadNode
    * */
   public void insertNewHead(Node newHeadNode) {
      if(headNode == null) { //head노드가 없는 경우 새로 생성
         headNode = newHeadNode;
      }else {
         /*
          headNode -> Node -> tailNode순으로 노드가 존재했다고 가정하면
          newHeadNode -> headNode -> Node -> tailNode가 되야 함
         */
                  
         newHeadNode.nextNode = headNode; //newHeadNode의 다음 노드는 headNode가 되고
         //head라는 값은 이미 뒤에 노드들을 연결한 상태임
         
         headNode = newHeadNode; //기존 headNode는 더이상 헤드 노드가 아니므로 헤드 노드를 newHeadNode로 수정한다
         headNode.nextNode.prevNode = headNode;
      }
      
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
	  
	  Node list = headNode;
	  
	  while(list != null) {
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
           headNode = removeNode.nextNode; //헤드노드는 지우고자 하는 노드의 다음 노드를 바라보도록 한다.
           
           if(headNode != null && headNode.prevNode != null) { 
              headNode.prevNode = null;
           }
           
           removeNode.prevNode = null;
           removeNode.prevNode = null;
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