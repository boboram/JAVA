package leftChildRightSiblingTree;

/**
 * 2018.07.16
 * */
public class leftChildRightSiblingTree {
	
	class Node {
		int data;
		Node leftChildNode; //좌측 자식
		Node rightSiblingNode; //왼쪽 자식의 형제 노드
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leftChildRightSiblingTree lcrst = new leftChildRightSiblingTree();
		
		Node rootNode = lcrst.createNode(0); //뿌리 노드 생성
		
		Node childNode = lcrst.createNode(1);
		lcrst.appendNode(rootNode, childNode);
		
		Node newChildNode2 = lcrst.createNode(5);
		lcrst.appendNode(childNode, newChildNode2);
		
		newChildNode2 = lcrst.createNode(6);
		lcrst.appendNode(childNode, newChildNode2); //5,6 ==> 1의 자식

		childNode = lcrst.createNode(2);
		lcrst.appendNode(rootNode, childNode);

		Node newChildNode = lcrst.createNode(3);
		lcrst.appendNode(childNode, newChildNode );
		newChildNode = lcrst.createNode(4);
		lcrst.appendNode(childNode, newChildNode);
		
		lcrst.printNode(rootNode, 0);
	}
	
	/**
	 * 노드 생성
	 * @param newData : 새로 추가할 데이터
	 **/
	Node createNode(int newData) {
		Node newNode = new Node();
		
		newNode.data = newData;
		newNode.leftChildNode = null;
		newNode.rightSiblingNode = null;
		
		return newNode;
	}
	
	/**
	 * 노드 생성
	 * 왼쪽 자식 노드, 왼쪽 자식 노드의 형제 노드 생성
	 * 왼쪽 자식이 없으면 왼쪽 자식 노드로 연결
	 * 왼쪽 자식이 있다면 우측 노드로 연결
	 * @param parentNode : 부모 노드
	 * @param newChildNode : 자식 노드(왼쪽인지 오른쪽인지는 모름)
	 **/
	void appendNode(Node parentNode, Node newChildNode) {
		if(parentNode.leftChildNode == null) { //왼쪽 자식 노드가 없다면 왼쪽 자식 노드로 연결 
			parentNode.leftChildNode = newChildNode;
			
		} else { //오른쪽 자식 노드
			Node childNode = parentNode.leftChildNode;
			
			while(childNode.rightSiblingNode!=null) {
				childNode = childNode.rightSiblingNode;
			}
			
			childNode.rightSiblingNode = newChildNode; //null값이 우측 자식노드에 노드 연결
		}
	}
	
	/**
	 * 노드 제거
	 * 하단부터 삭제
	 * @param rootNode 
	 **/
	void destroyNode(Node rootNode) {
		if(rootNode == null)
			return;
		
		if(rootNode.rightSiblingNode != null)
			destroyNode(rootNode.rightSiblingNode); //재귀함수
		
		if(rootNode.leftChildNode != null)
			destroyNode(rootNode.leftChildNode); //재귀함수
		
		rootNode.rightSiblingNode = null;
		rootNode.leftChildNode = null;
		rootNode = null;
		
	}
	
	/**
	 * 노드 출력
	 * 재귀함수
	 * 뿌리부터 차례대로 출력
	 * @param node 
	 * @param depth : 노드 깊이 
	 **/
	void printNode(Node node, int depth) {
		for(int i=0; i<depth; i++) {
			System.out.print("\t");
		}
		
		System.out.println(node.data);
		
		if(node.leftChildNode!=null)
			printNode(node.leftChildNode, depth+1);
		
		if(node.rightSiblingNode!=null)
			printNode(node.rightSiblingNode, depth);
		
	}

}
