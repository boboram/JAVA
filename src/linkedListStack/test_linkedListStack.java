package linkedListStack;

import linkedListStack.linkedListStack.*;

public class test_linkedListStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedListStack lls = new linkedListStack();
		LinkedListStack stack = null;
		Node newNode = null;

		/*스택 생성*/
		System.out.println("create stack...\n");
		stack = lls.createStack(stack);

		/*스택 상태 출력*/
		lls.printStackStatus(stack);

		/*데이터 1개 삽입*/
		System.out.println("\npush data...\n");
		newNode = lls.createNode("first");
		lls.Push(stack, newNode);

		/*스택 상태 출력*/
		lls.printStackStatus(stack);

		/*데이터 1개 삽입*/
		System.out.println("\npush data...\n");
		newNode = lls.createNode("second");
		lls.Push(stack, newNode);

		/*스택 상태 출력*/
		lls.printStackStatus(stack);

		/*데이터 1개 반환*/
		System.out.println("\npop data...\n");
		System.out.println("pop data : " + lls.Pop(stack).data);

		/*스택 상태 출력*/
		lls.printStackStatus(stack);

		/*데이터 1개 반환*/
		System.out.println("\npop data...\n");
		System.out.println("pop data : " + lls.Pop(stack).data);

		/*스택 상태 출력*/
		lls.printStackStatus(stack);
	}

}
