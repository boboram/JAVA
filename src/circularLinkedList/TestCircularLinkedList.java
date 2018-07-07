package circularLinkedList;

import circularLinkedList.CircularLinkedList.Node;

public class TestCircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node currentNode = null;
		Node newNode = null; 
		
		CircularLinkedList nodes = new CircularLinkedList();
		
		//노드 5개 추가
		for (int i = 0; i < 5; i++) {
			newNode = nodes.createNode(i); //i값을 갖는 새로운 노드를 생성
			nodes.appendNode(newNode); //생성된 노드를 list에 추가
		}

		//리스트 출력
		nodes.printfNodeList();

		//리스트 세번째 노드에 새로운 노드를 삽입
		System.out.println("\ninsert newNode after third node...\n");
		currentNode = nodes.getNodeAt(2); //세번째에 있는 노드 반환
		newNode = nodes.createNode(3000); //3000값을 갖는 새로운 노드를 생성
		nodes.insertAfter(currentNode, newNode); //세번째 노드 뒤에 newNode를 삽입
		
		//리스트 출력
		nodes.printfNodeList();
		
		//노드 리스트의 길이보다 2배만큼 루프를 돌며 환형 링크트 리스트임을 확인
		System.out.println("double print..\n\n");

		for (int i = 0; i < nodes.getNodeCount() * 2; i++)
		{
			currentNode = nodes.getNodeAt(i); //list에 담긴 노드중 i번째에 위치한 노드를 가져온다
			System.out.println("list[" + i + "] : " +  currentNode.data);
		}
		
		//리스트 첫번째 노드를 제거
		System.out.println("\nafter remove first node...\n");
		currentNode = nodes.getNodeAt(0);
		System.out.println(currentNode.data);
		nodes.removeNode(currentNode);
		
		
		//리스트 두번째 노드를 제거
		System.out.println("\nafter remove second node...\n");
		currentNode = nodes.getNodeAt(1);
		nodes.removeNode(currentNode);
		
		//리스트 출력
		nodes.printfNodeList();

		//모든 노드 제거
		System.out.println("\ndestroy all nodes..");
		
		int count = nodes.getNodeCount(); //list에 담긴 노드 개수
		
		currentNode = nodes.getNodeAt(0);
		Node nextNode = null;
		for (int i = 0; i < count; i++) {
			nextNode = currentNode.nextNode;
			if (currentNode != null) {
				nodes.removeNode(currentNode); //list에서 삭제
//						destoryNode(currentNode); //해당 노드 메모리 해제 ==> gc가 있으니 생략!
			}
			currentNode = nextNode;
		}

	}

}
