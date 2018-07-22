package binaryTree;

public class binaryTree {
	class Node{
		char data;
		Node leftChildNode;
		Node rightChildNode;
	}

	public static void main(String[] args) {
		binaryTree bt = new binaryTree();
		Node rootNode;
		
		rootNode = bt.createNode('A');
		
		rootNode.leftChildNode = bt.createNode('B');
		rootNode.leftChildNode.leftChildNode = bt.createNode('C');
		rootNode.leftChildNode.rightChildNode = bt.createNode('D');
		
		rootNode.rightChildNode = bt.createNode('E');
		rootNode.rightChildNode.leftChildNode = bt.createNode('F');
		rootNode.rightChildNode.rightChildNode = bt.createNode('G');
		
		System.out.println("preorder...");
		bt.printPreorderTreeTraversal(rootNode);
		System.out.println("\n\n");
		
		System.out.println("inorder...");
		bt.printInorderTreeTraversal(rootNode);
		System.out.println("\n\n");
		
		System.out.println("postorder...");
		bt.printPostorderTreeTraversal(rootNode);
		System.out.println("\n\n");
		
		rootNode = null; //트리 제거
		
	}
	
	/** 
	 * 노드 생성
	 * @param newData : 새로 추가하려는 데이터
	 **/
	Node createNode(char newData) {
		Node newNode = new Node();
		newNode.data = newData;
		newNode.leftChildNode = null;
		newNode.rightChildNode = null;
		
		return newNode;
	}
	
	void destroyNode(Node destroyNode) {
		if(destroyNode != null) {
			destroyNode = null;
		}
		
	}
	
	/**
	 * 트리 제거 - java에서 필요할까?
	 * @param rootNode
	 **/
	void destroyTree(Node rootNode) {
		if(rootNode == null)
			return ;
		
		destroyTree(rootNode.leftChildNode);
		destroyTree(rootNode.rightChildNode);
		rootNode = null;
		
	}
	
	/**
	 * 트리 탐색 : 전위 순회로 출력 
	 * @param rootNode
	 **/
	void printPreorderTreeTraversal(Node rootNode) {
		if(rootNode == null)
			return ;
		
		System.out.println(rootNode.data);
		printPreorderTreeTraversal(rootNode.leftChildNode);
		printPreorderTreeTraversal(rootNode.rightChildNode);
		
	}
	
	/**
	 * 트리 탐색 : 중위 순회로 출력 
	 * @param rootNode
	 **/
	void printInorderTreeTraversal(Node rootNode) {
		//왼,중,오
		if(rootNode == null)
			return ;
		
		printInorderTreeTraversal(rootNode.leftChildNode);
		System.out.println(rootNode.data);
		printInorderTreeTraversal(rootNode.rightChildNode);
		
	}
	
	/**
	 * 트리 탐색 : 후위 순회로 출력 
	 * @param rootNode
	 **/
	void printPostorderTreeTraversal(Node rootNode) {
		//아래부터 위, 왼, 오 , 중
		if(rootNode == null)
			return ;
		
		printPostorderTreeTraversal(rootNode.leftChildNode);
		printPostorderTreeTraversal(rootNode.rightChildNode);
		System.out.println(rootNode.data);
		
	}

}
