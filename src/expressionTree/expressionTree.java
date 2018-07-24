package expressionTree;

import java.util.Scanner;

public class expressionTree {
	
	class Node {
		String data;
		Node leftNode;
		Node rightNode;
	}
	int pos;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		expressionTree et = new expressionTree();
		String expression = ""; //후위표기식
		String token[]; //토큰을 저장 할 변수
		
		System.out.print("후위 표기식을 입력(예: 1 2 3 * + 5 /) : ");
		expression = sc.nextLine();
		
		token = expression.split(" "); //공백 기준으로 토큰 분리 
		Node rootNode = null; //뿌리 노드 초기화

		/*for(int i=0; i<token.length; i++) {
			System.out.println(i + " : " + token[i]);
		}*/
		rootNode = et.buildExpressionTree(token, token.length - 1, rootNode);
/*		System.out.println(rootNode.data);
		System.out.println(rootNode.rightNode.data);
		System.out.println(rootNode.leftNode.data);
		System.out.println(rootNode.leftNode.leftNode.data);
		System.out.println(rootNode.leftNode.rightNode.data);
		System.out.println(rootNode.leftNode.rightNode.leftNode.data);
		System.out.println(rootNode.leftNode.rightNode.rightNode.data);*/
		System.out.println("계산 : " + et.calculate(rootNode));
		
		//노드 삭제
		rootNode = null;
	}
	
	/**
	 * 노드 생성
	 * @param newData
	 **/
	Node createNode(String newData) {
		Node newNode = new Node();
		
		newNode.data = newData;
		newNode.leftNode = null;
		newNode.rightNode = null;
		
		return newNode;
		
	}
	
	/**
	 * 전위 탐색 
	 **/
	void printPreorderTreeTraversal(Node rootNode) {
		if(rootNode == null)
			return ;
		
		System.out.println(rootNode.data);
		printPreorderTreeTraversal(rootNode.leftNode);
		printPreorderTreeTraversal(rootNode.rightNode);
		
	}
	
	/**
	 * 중위 탐색
	 * @param rootNode
	 **/
	void printInorderTreeTraversal(Node rootNode) {
		if(rootNode == null)
			return ;
		
		printInorderTreeTraversal(rootNode.leftNode);
		System.out.println(rootNode.data);
		printInorderTreeTraversal(rootNode.rightNode);
		
	}
	
	/**
	 * 후위 탐색
	 * @param rootNode 
	 **/
	void printPostorderTreeTraversal(Node rootNode) {
		if(rootNode == null)
			return ;
		
		printPostorderTreeTraversal(rootNode.leftNode);
		printPostorderTreeTraversal(rootNode.rightNode);
		System.out.println(rootNode.data);
		
	}
	
	/**
	 * 수식 트리 생성
	 * @param array expression : 수식 토큰
	 * @param position : 노드 생성할 토큰 인덱스
	 * @param rootNode
	 **/
	Node buildExpressionTree(String expression[], int position, Node rootNode) { //객체 값 넣어주기 위해 Node를 리턴형으로 잡아준다
		if(position == (expression.length -1)) //첫 시작일때만 인덱스를 배열 크기만큼 잡아준다.
			pos = position;
		String token = expression[pos]; //끝에서부터 차례대로 한 토큰씩 노드를 생성해줍니다.
		pos--; //다음 함수 호출시 현재 토큰보다 앞에 있는 토큰을 얻이위하여 인덱스 1 감소
		rootNode = createNode(token); //노드 생성
		
		if( isOperator(token) ) {
			rootNode.rightNode = buildExpressionTree(expression, 0, rootNode.rightNode); //후위 표기식은 뒤부터 읽기 때문에 오른쪽부터 채운다.
			rootNode.leftNode = buildExpressionTree(expression, 0, rootNode.leftNode);
		}
		
		return rootNode; //토큰으로 생성한 노드를 반환한다.
		
	}

	
	/**
	 * 수식 트리 계산
	 * @param rootNode 
	 * @return double
	 * 토큰값이 수식이면 계산한 값 반환
	 * 아닌경우 피연산자 반환
	 **/
	double calculate(Node rootNode) {
		if(rootNode == null)
			return 0;
		
		double result = 0, left = 0, right = 0; 
		String token = rootNode.data; //해당 노드의 데이터
		if( isOperator(token) ) {
			left = calculate(rootNode.leftNode);
			right = calculate(rootNode.rightNode);
			
			if("+".equals(token)) result = left + right;
			else if("-".equals(token)) result = left - right;
			else if("*".equals(token)) result = left * right;
			else result = left / right;
		} else { //토큰값이 수식이 아닌경우 피연산자값 반환
			result = Integer.parseInt(token);
		}
		
		System.out.println("result : " +  result);
		
		return result;
		
	}
	
	/**
	 * 수식인지 아닌지 반환하는 함수
	 * @param token
	 * @return boolean 
	 **/
	boolean isOperator(String token) {
		return ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
		
	}

}
