package linkedList;

/**
 * @author boram
 * 연결리스트 구현하기(자료구조)
 **/
public class LinkedList {
   
   public Node headNode; //헤드 노드
   private int count = 0; //노드 갯수
   
   public class Node{ //C의 구조체 대신에 클래스 사용
      public int data; //입력 데이터
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
         Node beforeNode = getNodeAt(count-1); //이전에 생성된 노드를 가져온다
         
         beforeNode.nextNode = newNode; //이전 노드의 연결링크를 새 노드로 해준다.
      }
      
      count++;
      
   }
   
   /**
    * 특정 노드의 다음 노드 추가
    * */
   public void insertAfter(Node currentNode, Node newNode)
   {
      /*
         headNode -> currentNode -> tailNode 순으로 노드가 존재했다고 가정하면
         현재 newNode는 currentNode 이후에 추가되야하므로 아래와 같다
         headNode -> currentNode -> newNode -> tailNode
         따라서 newNode의 다음 노드는 tailNode를 바라봐야 하며
         currentNode의 다음 노드는 tailNode에서 newNode로 바뀐다
      */
      
      newNode.nextNode = currentNode.nextNode;
      currentNode.nextNode = newNode;
      
      count++;
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
      }
      
      count++;
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
      return count;
      
   }
   
   /**
    * 노드 제거
    * @param removeNode
    * */
   public void removeNode(Node removeNode) {
      
       if(headNode == removeNode) { //지우고자 하는 노드가 헤드노드라면
           headNode = removeNode.nextNode; //헤드노드는 지우고자 하는 노드의 다음 노드를 바라보도록 한다.
       } else {
           Node removeBeforeNode = headNode; //지우고자 하는 노드를 연결하고 있는 노드
           
           while(removeBeforeNode!=null && removeBeforeNode.nextNode != removeNode) { 
        	  //지우고자 하는 노드의 전 노드 즉, 지우고자 하는 노드를 바라보는 노드를 찾는다.
              removeBeforeNode = removeBeforeNode.nextNode;
           }
           
           if(removeBeforeNode != null) {              
              removeBeforeNode.nextNode = removeNode.nextNode; 
              //지우고자 하는 노드를 바라보는 노드의 다음노드가 지우고자하는 노드의 다음 노드를 바라보도록 한다.
              //before : beforeNode -> removeNode -> nextNode
              //after : beforeNode -> nextNode
           }
           
       }
       
       count--; //노드 하나 제거했기때문에 사이즈 하나 감소   
       
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