package arrayStack;


public class arrayStack {
   
   public class Node {
      int data = 0;
   }
   
   public class ArrayStack {
      int capacity; //스택 용량
      int top; //노드 배열 최상위 인덱스
      Node Nodes[]; //노드 배열
   }
   
   /**
    * 스택 생성 
    **/
   public ArrayStack createStack(ArrayStack stack, int capacity) {
      stack = new ArrayStack(); //스택 메모리 생성
      stack.Nodes = new Node[capacity]; //capacity만큼의 노드 메모리 설정
      stack.capacity = capacity; //입력된 capacity로 스택 용량 설정
      stack.top = 0; //top 초기화
      
      return stack;
   }
   
   /**
    * 스택 데이터 저장
    **/
   public void Push(ArrayStack stack, int data) {
      stack.Nodes[stack.top] = new Node();
      stack.Nodes[stack.top++].data = data;
   }
   
   /**
     * 스택 data 반환 
    **/
   public int Pop(ArrayStack stack) {
      return stack.Nodes[--stack.top].data;
   }
   
   /**
     * 스택 메모리 갯수 반환 
    **/
   public int getSize(ArrayStack stack) {
      return stack.top;
   }
   
   /**
     * 스택 비어져있는지 여부 반환 
    **/
   public boolean isEmpty(ArrayStack stack) {
      return stack.top == 0;
   }
   
   /**
     * 스택 상태 출력 
    **/
   public void printStackStatus(ArrayStack stack) {
      System.out.println("print stack status...\n");
      System.out.println("capacity : " + stack.capacity);
      System.out.println("top : " + stack.top);
      System.out.println("stack size : " + getSize(stack));
      System.out.println("stack is empty? : " + isEmpty(stack));
   }
}