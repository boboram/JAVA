package linkedListStack;

import linkedListStack.linkedListStack.*;

public class test_linkedListStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedListStack lls = new linkedListStack();
		LinkedListStack stack = null;
		Node newNode = null;

		/*���� ����*/
		System.out.println("create stack...\n");
		stack = lls.createStack(stack);

		/*���� ���� ���*/
		lls.printStackStatus(stack);

		/*������ 1�� ����*/
		System.out.println("\npush data...\n");
		newNode = lls.createNode("first");
		lls.Push(stack, newNode);

		/*���� ���� ���*/
		lls.printStackStatus(stack);

		/*������ 1�� ����*/
		System.out.println("\npush data...\n");
		newNode = lls.createNode("second");
		lls.Push(stack, newNode);

		/*���� ���� ���*/
		lls.printStackStatus(stack);

		/*������ 1�� ��ȯ*/
		System.out.println("\npop data...\n");
		System.out.println("pop data : " + lls.Pop(stack).data);

		/*���� ���� ���*/
		lls.printStackStatus(stack);

		/*������ 1�� ��ȯ*/
		System.out.println("\npop data...\n");
		System.out.println("pop data : " + lls.Pop(stack).data);

		/*���� ���� ���*/
		lls.printStackStatus(stack);
	}

}
