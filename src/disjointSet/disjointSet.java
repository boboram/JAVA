package disjointSet;

/**
 * 분리 집합
 * 공통되는 데이터가 없는 합집합만 존재하는 집합
 * 합집합 : 첫번째 노드의 최상위 부모노드를 두번째 노드의 최상위 노드의 부모노드로 연결
 * 집합검색 : 해당 노드의 최상위 부모노드를 반환
 * */
public class disjointSet { 
	
	class Node {
		String data; //데이터
		Node parentNode; //부모 노드
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		disjointSet djs = new disjointSet(); //분리집합 객체 생성
		
		//A집합 생성
		Node aRootNode = djs.createNode("A");
		Node aNode1 = djs.createNode("A-1");
		Node aNode2 = djs.createNode("A-2");
		Node aNode3 = djs.createNode("A-3");
		aNode1.parentNode = aRootNode;
		aNode2.parentNode = aRootNode;
		aNode3.parentNode = aRootNode;

		//B집합 생성
		Node bRootNode = djs.createNode("B");
		Node bNode1 = djs.createNode("B-1");
		Node bNode2 = djs.createNode("B-2");
		Node bNode3 = djs.createNode("B-3");
		bNode1.parentNode = bRootNode;
		bNode2.parentNode = bRootNode;
		bNode3.parentNode = bRootNode;
		
		//임의의 노드를 선택하여 집합 검색 실행
		System.out.println("aNode2의 집합 결과 : " + djs.findDisjoinSet(aNode2).data);
		System.out.println("bNode3의 집합 결과 : " + djs.findDisjoinSet(bNode3).data + "\n");
		
		//두 집합은 분리되어 있으므로 루트 노드가 다름을 확인
		System.out.println("A집합 == B집합 : " + (djs.findDisjoinSet(aNode2) == djs.findDisjoinSet(bNode3)) );
		
		System.out.println("\n합집합 실행.....\n");
		djs.unionDisjointSet(aRootNode, bRootNode);
		
		//두 집합을 합하였으므로 루트 노드가 같음을 확인
		System.out.println("A집합 == B집합 : " + (djs.findDisjoinSet(aNode2) == djs.findDisjoinSet(bNode3)) );
		
		//노드 소멸
		aRootNode = aNode1 = aNode2 = aNode3 = bRootNode = bNode1 = bNode2 = bNode3 = null;
	}
	
	/**
	 * 노드 생성 
	 * @param newData
	 **/
	Node createNode(String newData) {
		Node newNode = new Node();
		
		newNode.data = newData;
		newNode.parentNode = null;
		
		return newNode;
	}
	
	/**
	 * 노드 제거
	 * @param removeNode : 제거할 노드 
	 **/
	void destroyNode(Node removeNode) {
		if(removeNode == null)
			return ;
		
		removeNode = null;
		
	}
	
	/**
	 * 집합검색
	 * 해당 집합을 대표하는 루트 노드 반환
	 * @param node : 집합 검색할 노드
	 * @return 대표하는 루트 노드
	 **/
	Node findDisjoinSet(Node node) {
		
		while(node.parentNode != null) {
			node = node.parentNode;
		}
		
		return node;
		
	}
	
	/**
	 * 합집합
	 * node2의 루트노드의 부모 노드를 node1의 루트노드를 바라보도록 설정
	 * @param node1
	 * @param node2
	 **/
	void unionDisjointSet(Node node1, Node node2) {
		node1 = findDisjoinSet(node1);
		node2 = findDisjoinSet(node2);
		
		node2.parentNode = node1;
	}

}
