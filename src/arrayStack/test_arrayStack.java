package arrayStack;

import arrayStack.arrayStack.ArrayStack;

public class test_arrayStack {
   public static void main(String args[]) {
      arrayStack as = new arrayStack();
      ArrayStack stack = null;
      
      /*���� ����*/
      System.out.println("create stack..\n");
      stack = as.createStack(stack, 10); //10���� �����͸� ���� ���� ����
      
      /*������ ����*/
      System.out.println("push data...\n");
      for(int i=0; i<5; i++) {
         as.Push(stack, i); //���ÿ� i���� ���ʴ�� ����
      }
      
      /*���� ���� ���� ���*/
      as.printStackStatus(stack);
      
      /*������ ��ȯ*/
      System.out.println("pop data....\n");
      
      for(int i=0; i<10; i++) {
         if(as.isEmpty(stack)) {
            System.out.println(i + " stack is empty...\n");
            break;
         }
         
         System.out.println(i + " pop : " + as.Pop(stack));
      }
      
      /*���� ���� ���� ���*/
      as.printStackStatus(stack);
      
      
   }

}