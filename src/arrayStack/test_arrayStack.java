package arrayStack;

import arrayStack.arrayStack.ArrayStack;

public class test_arrayStack {
   public static void main(String args[]) {
      arrayStack as = new arrayStack();
      ArrayStack stack = null;
      
      /*스택 생성*/
      System.out.println("create stack..\n");
      stack = as.createStack(stack, 10); //10개의 데이터를 담을 스택 생성
      
      /*데이터 삽입*/
      System.out.println("push data...\n");
      for(int i=0; i<5; i++) {
         as.Push(stack, i); //스택에 i값을 차례대로 삽입
      }
      
      /*현재 스택 상태 출력*/
      as.printStackStatus(stack);
      
      /*데이터 반환*/
      System.out.println("pop data....\n");
      
      for(int i=0; i<10; i++) {
         if(as.isEmpty(stack)) {
            System.out.println(i + " stack is empty...\n");
            break;
         }
         
         System.out.println(i + " pop : " + as.Pop(stack));
      }
      
      /*현재 스택 상태 출력*/
      as.printStackStatus(stack);
      
      
   }

}