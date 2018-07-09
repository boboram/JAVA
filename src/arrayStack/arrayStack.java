package arrayStack;


public class arrayStack {
   
   public class Node {
      int data = 0;
   }
   
   public class ArrayStack {
      int capacity; //���� �뷮
      int top; //��� �迭 �ֻ��� �ε���
      Node Nodes[]; //��� �迭
   }
   
   /**
    * ���� ���� 
    **/
   public ArrayStack createStack(ArrayStack stack, int capacity) {
      stack = new ArrayStack(); //���� �޸� ����
      stack.Nodes = new Node[capacity]; //capacity��ŭ�� ��� �޸� ����
      stack.capacity = capacity; //�Էµ� capacity�� ���� �뷮 ����
      stack.top = 0; //top �ʱ�ȭ
      
      return stack;
   }
   
   /**
    * ���� ������ ����
    **/
   public void Push(ArrayStack stack, int data) {
      stack.Nodes[stack.top] = new Node();
      stack.Nodes[stack.top++].data = data;
   }
   
   /**
     * ���� data ��ȯ 
    **/
   public int Pop(ArrayStack stack) {
      return stack.Nodes[--stack.top].data;
   }
   
   /**
     * ���� �޸� ���� ��ȯ 
    **/
   public int getSize(ArrayStack stack) {
      return stack.top;
   }
   
   /**
     * ���� ������ִ��� ���� ��ȯ 
    **/
   public boolean isEmpty(ArrayStack stack) {
      return stack.top == 0;
   }
   
   /**
     * ���� ���� ��� 
    **/
   public void printStackStatus(ArrayStack stack) {
      System.out.println("print stack status...\n");
      System.out.println("capacity : " + stack.capacity);
      System.out.println("top : " + stack.top);
      System.out.println("stack size : " + getSize(stack));
      System.out.println("stack is empty? : " + isEmpty(stack));
   }
}