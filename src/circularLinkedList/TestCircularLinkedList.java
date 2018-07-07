package circularLinkedList;

import circularLinkedList.CircularLinkedList.Node;

public class TestCircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node currentNode = null;
		Node newNode = null; 
		
		CircularLinkedList nodes = new CircularLinkedList();
		
		//��� 5�� �߰�
		for (int i = 0; i < 5; i++) {
			newNode = nodes.createNode(i); //i���� ���� ���ο� ��带 ����
			nodes.appendNode(newNode); //������ ��带 list�� �߰�
		}

		//����Ʈ ���
		nodes.printfNodeList();

		//����Ʈ ����° ��忡 ���ο� ��带 ����
		System.out.println("\ninsert newNode after third node...\n");
		currentNode = nodes.getNodeAt(2); //����°�� �ִ� ��� ��ȯ
		newNode = nodes.createNode(3000); //3000���� ���� ���ο� ��带 ����
		nodes.insertAfter(currentNode, newNode); //����° ��� �ڿ� newNode�� ����
		
		//����Ʈ ���
		nodes.printfNodeList();
		
		//��� ����Ʈ�� ���̺��� 2�踸ŭ ������ ���� ȯ�� ��ũƮ ����Ʈ���� Ȯ��
		System.out.println("double print..\n\n");

		for (int i = 0; i < nodes.getNodeCount() * 2; i++)
		{
			currentNode = nodes.getNodeAt(i); //list�� ��� ����� i��°�� ��ġ�� ��带 �����´�
			System.out.println("list[" + i + "] : " +  currentNode.data);
		}
		
		//����Ʈ ù��° ��带 ����
		System.out.println("\nafter remove first node...\n");
		currentNode = nodes.getNodeAt(0);
		System.out.println(currentNode.data);
		nodes.removeNode(currentNode);
		
		
		//����Ʈ �ι�° ��带 ����
		System.out.println("\nafter remove second node...\n");
		currentNode = nodes.getNodeAt(1);
		nodes.removeNode(currentNode);
		
		//����Ʈ ���
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
//						destoryNode(currentNode); //�ش� ��� �޸� ���� ==> gc�� ������ ����!
			}
			currentNode = nextNode;
		}

	}

}
