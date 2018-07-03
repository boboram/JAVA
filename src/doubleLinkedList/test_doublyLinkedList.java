package doubleLinkedList;

import doubleLinkedList.DoubleLinkedList.Node;

public class test_doublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node currentNode = null;
		Node newNode = null;
		
		DoubleLinkedList nodes = new DoubleLinkedList();
		
		//��� 5�� �߰�
		for (int i = 0; i < 5; i++) {
			newNode = nodes.createNode(i); //i���� ���� ���ο� ��带 ����
			nodes.appendNode(newNode); //������ ��带 list�� �߰�
		}

		//���ο� ��� ��� 2�� �߰� 77����
		newNode = nodes.createNode(-1);
		nodes.insertNewHead(newNode); //list�� -1���� ���� ��带 ��� ���� �߰�
		
		newNode = nodes.createNode(-2);
		nodes.insertNewHead(newNode); //list�� -2���� ���� ��带 ��� ���� �߰�
		
		//����Ʈ ���
		nodes.printfNodeList();

		//����Ʈ ����° ��忡 ���ο� ��带 ����
		System.out.println("\ninsert newNode after third node...\n");
		currentNode = nodes.getNodeAt(2); //����°�� �ִ� ��� ��ȯ
		newNode = nodes.createNode(3000); //3000���� ���� ���ο� ��带 ����
		nodes.insertAfter(currentNode, newNode); //����° ��� �ڿ� newNode�� ����
		
		//����Ʈ ���
		nodes.printfNodeList();
		
		/*����Ʈ �׹�° ��带 ����*/
		System.out.println("\nafter remove forth node...\n");
		currentNode = nodes.getNodeAt(3);
		nodes.removeNode(currentNode);

		/*����Ʈ ���*/
		nodes.printfNodeList();

		//��� ��� ����
		System.out.println("\ndestroy all nodes..");
		
		int count = nodes.getNodeCount(); //list�� ��� ��� ����
		
		currentNode = nodes.getNodeAt(0);
		Node nextNode = null;
		for (int i = 0; i < count; i++) {
			nextNode = currentNode.nextNode;
			if (currentNode != null) {
				nodes.removeNode(currentNode); //list���� ����
//				destoryNode(currentNode); //�ش� ��� �޸� ���� ==> gc�� ������ ����!
			}
			currentNode = nextNode;
		}
		


	}

}
