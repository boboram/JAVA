package stackCalculator;

import stackCalculator.linkedListStack.LinkedListStack;
import stackCalculator.linkedListStack.Node;

public class stackCalculator {
	char LEFT_PARENTHESIS = '(';
	char RIGHT_PARENTHESIS = ')';
	char PLUS = '+';
	char MINUS = '-';
	char MULTIPLY = '*';
	char DIVIDE = '/';
	char SPACE = ' ';
	char OPERAND;
	
	char NUMBER[] = {'.', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}; //숫자 배열
	//.은 소수점을 의미
	
	/**
	 * 숫자 판별 함수
	 * @param cipher
	 **/
	public boolean isNumber(char cipher) {
		for(int i=0; i<NUMBER.length; i++) {
			if(NUMBER[i] == cipher) return true;
		}
		return false;
		
	}
	
	/**
	 * 연산자 순위 반환 함수 
	 * @param operator :  연산자
	 **/
	public int getPriority(char operator) {
		/*
		    - 가장 높음 : *, /
			- 중간 : +, -
		 	- 깍두기 : ( 
		*/
		//높은 순위의 연산자일수록 높은 값을 반환
		//자바에선 switch~case문법 사용시 case에 변수를 넣으면 인식하지 못하는 문제가 발생하기 때문에 if ~ elseif문으로 대체한다.
		if (operator == LEFT_PARENTHESIS) {
			return 0;
			
		} else if (operator == PLUS || operator == MINUS) {
			return 1;
			
		} else if (operator == MULTIPLY || operator == DIVIDE) {
			return 2;
			
		} else {
			return -1;
			
		}
	}
	
	/**
	 * 우선순위 비교 
	 * @param operatorInstack : 최상위에 위치한 연산자
	 * @param operatorInToken : 스택에 쌓으려는 연산자
	 **/
	public boolean isPrior(char operatorInstack, char operatorInToken) {
		return getPriority(operatorInstack) >= getPriority(operatorInToken);

	}
	
	/**
	 * 후위표기식으로 변경 
	 * @param infixExpression : 중위표기식
	 * @param postfixExpression : 후위표기식으로 변경된 값이 저장되는 변수
	 * )를 만나면 그동에 스택에 쌓아둔 연산자들을 postfixExpression와 합칩니다.
	 * 본인보다 높은 순위의 연산자를 만나면 높은 순위의 연산자는 반환되면 본인은 스택에 쌓이게 됩니다.
	 * '('와 ')'는 반환되지 않으며 ')'는 쌓이지 않습니다.
	 **/
	public String getPostfix(String infixExpression, String postfixExpression) {
		
		/*스택 생성*/
		LinkedListStack stack = null;
		linkedListStack lls = new linkedListStack();
		
		stack = lls.createStack(stack);
		
//		int position = 0; //후위표기식 인덱스 ==>char배열이 아닌 String이기 때문에 필요 없음
		int needWhiteSpace = 0; //공백 필요 여부
		
		for(int i=0; i<infixExpression.length(); i++) {
			//숫자일 경우 스택에 쌓지 않고 바로 출력하기 위해 후위 표기식에 그대로 옮긴다.
			if(isNumber(infixExpression.charAt(i))) {
				postfixExpression += infixExpression.charAt(i);
				needWhiteSpace = 1; //숫자를 구분하기 위해 공백이 필요
				
			} 
			else { //숫자가 아닌경우
				//이중 공백을 막기 위한 조건식 : 이전의 문자가 숫자인 경우에만 공백 넣어주기
				//이전문자가 존재하는 경우일때만 조건문 적용되도록 i>0수식 추가
				if( i>0 && postfixExpression.charAt(postfixExpression.length()-1) != ' ' && needWhiteSpace == 1) {
					postfixExpression += ' ';
					needWhiteSpace = 0;
					
				}
				
				//닫는 괄호 ')' 인 경우
				if( infixExpression.charAt(i) == RIGHT_PARENTHESIS) {
					Node topNode = null;
					
					//'(' 여는 괄호가 나오기 전까지 계속 반환(Pop)
					while(!lls.isEmpty(stack)) {
						topNode = lls.Pop(stack);
						if(topNode.data.charAt(0) != LEFT_PARENTHESIS ) { //'('여는 괄호가 아닌 다른 연산자만 후기 표현식 변수와 합치기					
							postfixExpression += topNode.data;
						}else //'('이면 반복문 
							break;
					}
					//여는 괄호는 표현식에 들어가지 않으며 닫는 괄호는 스택에 쌓이지 않는다 
				}
				else if( infixExpression.charAt(i) == LEFT_PARENTHESIS ) { //'('여는 괄호라면 스택에 쌓는다.
					lls.Push(stack, lls.createNode( String.valueOf(infixExpression.charAt(i)) )); //String형으로 문자 변환후 푸쉬
					
				}
				else { //괄호가 아닌 그 외 연산자인 경우엔 우선순위 계산과 함께 스택에 쌓는다.
					Node topNode = null;
					
					//최상위 스택에 있는 연산자의 순위가 현재 연산자의 순위보다 높다면 반환한다
					while(!lls.isEmpty(stack) && isPrior( stack.topNode.data.charAt(0), infixExpression.charAt(i))) {
						topNode = lls.Pop(stack);
						postfixExpression += topNode.data;
					}
					
					lls.Push(stack, lls.createNode(String.valueOf(infixExpression.charAt(i))));
					
				}
				
			}
			
		}
		
		//스택에 남아 있는 연산자들 순서대로 반환		
		Node topNode = null;
		
		while(!lls.isEmpty(stack)) {
			topNode = lls.Pop(stack);
			postfixExpression += topNode.data;
		}
		
		return postfixExpression; //후위표기식 값 리턴
		
	} //end function getPostfix
	
	/**
	 * 후위표기식으로 변환된 식 계산 
	 * 공백은 무시합니다.
	 * '*', '/', '+', '-'만 가능합니다
	 **/
	public double calculate(String postfixExpression) {
		/*스택 생성*/
		LinkedListStack stack = null;
		linkedListStack lls = new linkedListStack();
		
		stack = lls.createStack(stack);
		
		//시작 인덱스와 끝 인덱스를 지정한 이유는 3.34와 같이 두자이상의 숫자를 하나로 묶기 위함
		int startPosition = -1, endPosition = -1;
		
		/*
			후위 표기식 계산법
			1. 피연산자(숫자)는 스택에 쌓는다
			2. 연산자를 만나면 스택에서 2회 반환(pop)을 하고 [두번째 반환된 데이터 (연산) 첫번째 반환된 데이터]의 결과를 다시 스택에 쌓는다
		*/
		
		for(int i=0; i<postfixExpression.length(); i++) {
			//공백인 경우 그냥 넘어가유
			if(postfixExpression.charAt(i) == SPACE) continue;
			
			//숫자인 경우 ==> 스택에 쌓는다.
			if(isNumber(postfixExpression.charAt(i))) {
				
				//첫시작이라면 첫 인덱스 수정
				if(startPosition == -1) //숫자의 처음이면 1.234의 1의 index가 0이라면 startPosition의 값은 0이 된다. 0부터 4까지가 하나의 스택에 들어가게 된다
					startPosition = i;
				
				//다음 문자가 숫자가 아닐 경우 스택에 쌓는다. 다음문자가 공백이거나 연산자면 스택에 숫자 넣기
				if(!isNumber(postfixExpression.charAt(i+1))) {
					String token = "";
					
					endPosition = i; //현재 반복문의 인덱스까지만 돌리기 위하여 오
					
					for(; startPosition<=endPosition; startPosition++) {
						token += postfixExpression.charAt(startPosition);
					}
					
					lls.Push(stack, lls.createNode(token));
					
					startPosition = -1; //숫자 스택에 넣은 후에 첫 인덱스 -1로 수정
					endPosition = -1;
				}
				
				continue;
			}
			
			//연산자일 경우 스택에서 2회 반환(pop)을 수행 후 연산 결과를 다시 스택에 저장
			Node firstNode = lls.Pop(stack);
			Node secondNode = lls.Pop(stack);
			
			double firstData = Double.valueOf(firstNode.data); //최상단에 있는 수 - 뒤에서 계산
			double secondData = Double.valueOf(secondNode.data); //앞에서 계산
			double resultData = 0; //결과 값을 저장할 변수
			
			switch (postfixExpression.charAt(i)) { //현재 연산자로 비교
				case '+':
					resultData = secondData + firstData;
					break;
				case '-':
					resultData = secondData - firstData;
					break;
				case '*':
					resultData = secondData * firstData;
					break;
				case '/':
					resultData = secondData / firstData;
					break;
			}
			
			lls.Push(stack, lls.createNode(String.valueOf(resultData))); //double형 String형으로 변한후 연산된 결과값을 스택에 저장
		
		} //end for
		
		//계산된 값 반환
		Node resultNode = lls.Pop(stack);
		double result = Double.valueOf(resultNode.data);
		
		return result; //계산된 결과값 반환
		
	} //end function calculate
	
}
