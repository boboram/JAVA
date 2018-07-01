package linkedList;

import linkedList.LinkedList.Node;

public class TestLinkedList { //연결 리스트 테스트
	public static void main(String args[]) {
		Node currentNode = null;
		Node newNode = null;
		
		LinkedList nodes = new LinkedList();
		
		//노드 5개 추가
		for (int i = 0; i < 5; i++) {
			newNode = nodes.createNode(i); //i값을 갖는 새로운 노드를 생성
			nodes.appendNode(newNode); //생성된 노드를 list에 추가
		}

		//새로운 헤드 노드 2개 추가 77ㅑㅑ
		newNode = nodes.createNode(-1);
		nodes.insertNewHead(newNode); //list에 -1값을 갖는 노드를 헤드 노드로 추가
		
		newNode = nodes.createNode(-2);
		nodes.insertNewHead(newNode); //list에 -2값을 갖는 노드를 헤드 노드로 추가
		
		//리스트 출력
		nodes.printfNodeList();

		//리스트 세번째 노드에 새로운 노드를 삽입
		System.out.println("insert newNode after third node...");
		currentNode = nodes.getNodeAt(2); //세번째에 있는 노드 반환
		newNode = nodes.createNode(3000); //3000값을 갖는 새로운 노드를 생성
		nodes.insertAfter(currentNode, newNode); //세번째 노드 뒤에 newNode를 삽입
		
		//리스트 출력
		nodes.printfNodeList();

		//모든 노드 제거
		System.out.println("destroy all nodes..");
		
		int count = nodes.getNodeCount(); //list에 담긴 노드 개수

		currentNode = nodes.getNodeAt(0);
		Node nextNode = null;
		for (int i = 0; i < count; i++) {
			nextNode = currentNode.nextNode;
			if (currentNode != null) {
				nodes.removeNode(currentNode); //list에서 삭제
//				destoryNode(currentNode); //해당 노드 메모리 해제 ==> gc가 있으니 생략!
			}
			currentNode = nextNode;
		}

	}
}
