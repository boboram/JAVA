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
	
	char NUMBER[] = {'.', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}; //���� �迭
	//.�� �Ҽ����� �ǹ�
	
	/**
	 * ���� �Ǻ� �Լ�
	 * @param cipher
	 **/
	public boolean isNumber(char cipher) {
		for(int i=0; i<NUMBER.length; i++) {
			if(NUMBER[i] == cipher) return true;
		}
		return false;
		
	}
	
	/**
	 * ������ ���� ��ȯ �Լ� 
	 * @param operator :  ������
	 **/
	public int getPriority(char operator) {
		/*
		    - ���� ���� : *, /
			- �߰� : +, -
		 	- ��α� : ( 
		*/
		//���� ������ �������ϼ��� ���� ���� ��ȯ
		//�ڹٿ��� switch~case���� ���� case�� ������ ������ �ν����� ���ϴ� ������ �߻��ϱ� ������ if ~ elseif������ ��ü�Ѵ�.
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
	 * �켱���� �� 
	 * @param operatorInstack : �ֻ����� ��ġ�� ������
	 * @param operatorInToken : ���ÿ� �������� ������
	 **/
	public boolean isPrior(char operatorInstack, char operatorInToken) {
		return getPriority(operatorInstack) >= getPriority(operatorInToken);

	}
	
	/**
	 * ����ǥ������� ���� 
	 * @param infixExpression : ����ǥ���
	 * @param postfixExpression : ����ǥ������� ����� ���� ����Ǵ� ����
	 * )�� ������ �׵��� ���ÿ� �׾Ƶ� �����ڵ��� postfixExpression�� ��Ĩ�ϴ�.
	 * ���κ��� ���� ������ �����ڸ� ������ ���� ������ �����ڴ� ��ȯ�Ǹ� ������ ���ÿ� ���̰� �˴ϴ�.
	 * '('�� ')'�� ��ȯ���� ������ ')'�� ������ �ʽ��ϴ�.
	 **/
	public String getPostfix(String infixExpression, String postfixExpression) {
		
		/*���� ����*/
		LinkedListStack stack = null;
		linkedListStack lls = new linkedListStack();
		
		stack = lls.createStack(stack);
		
//		int position = 0; //����ǥ��� �ε��� ==>char�迭�� �ƴ� String�̱� ������ �ʿ� ����
		int needWhiteSpace = 0; //���� �ʿ� ����
		
		for(int i=0; i<infixExpression.length(); i++) {
			//������ ��� ���ÿ� ���� �ʰ� �ٷ� ����ϱ� ���� ���� ǥ��Ŀ� �״�� �ű��.
			if(isNumber(infixExpression.charAt(i))) {
				postfixExpression += infixExpression.charAt(i);
				needWhiteSpace = 1; //���ڸ� �����ϱ� ���� ������ �ʿ�
				
			} 
			else { //���ڰ� �ƴѰ��
				//���� ������ ���� ���� ���ǽ� : ������ ���ڰ� ������ ��쿡�� ���� �־��ֱ�
				//�������ڰ� �����ϴ� ����϶��� ���ǹ� ����ǵ��� i>0���� �߰�
				if( i>0 && postfixExpression.charAt(postfixExpression.length()-1) != ' ' && needWhiteSpace == 1) {
					postfixExpression += ' ';
					needWhiteSpace = 0;
					
				}
				
				//�ݴ� ��ȣ ')' �� ���
				if( infixExpression.charAt(i) == RIGHT_PARENTHESIS) {
					Node topNode = null;
					
					//'(' ���� ��ȣ�� ������ ������ ��� ��ȯ(Pop)
					while(!lls.isEmpty(stack)) {
						topNode = lls.Pop(stack);
						if(topNode.data.charAt(0) != LEFT_PARENTHESIS ) { //'('���� ��ȣ�� �ƴ� �ٸ� �����ڸ� �ı� ǥ���� ������ ��ġ��					
							postfixExpression += topNode.data;
						}
					}
					//���� ��ȣ�� ǥ���Ŀ� ���� ������ �ݴ� ��ȣ�� ���ÿ� ������ �ʴ´� 
				}
				else if( infixExpression.charAt(i) == LEFT_PARENTHESIS ) { //'('���� ��ȣ��� ���ÿ� �״´�.
					lls.Push(stack, lls.createNode( String.valueOf(infixExpression.charAt(i)) )); //String������ ���� ��ȯ�� Ǫ��
					
				}
				else { //��ȣ�� �ƴ� �� �� �������� ��쿣 �켱���� ���� �Բ� ���ÿ� �״´�.
					Node topNode = null;
					
					//�ֻ��� ���ÿ� �ִ� �������� ������ ���� �������� �������� ���ٸ� ��ȯ�Ѵ�
					while(!lls.isEmpty(stack) && isPrior( stack.topNode.data.charAt(0), infixExpression.charAt(i))) {
						topNode = lls.Pop(stack);
						postfixExpression += topNode.data;
					}
					
					lls.Push(stack, lls.createNode(String.valueOf(infixExpression.charAt(i))));
					
				}
				
			}
			
		}
		
		//���ÿ� ���� �ִ� �����ڵ� ������� ��ȯ		
		Node topNode = null;
		
		while(!lls.isEmpty(stack)) {
			topNode = lls.Pop(stack);
			postfixExpression += topNode.data;
		}
		
		return postfixExpression; //����ǥ��� �� ����
		
	} //end function getPostfix
	
	/**
	 * ����ǥ������� ��ȯ�� �� ��� 
	 * ������ �����մϴ�.
	 * '*', '/', '+', '-'�� �����մϴ�
	 **/
	public double calculate(String postfixExpression) {
		/*���� ����*/
		LinkedListStack stack = null;
		linkedListStack lls = new linkedListStack();
		
		stack = lls.createStack(stack);
		
		//���� �ε����� �� �ε����� ������ ������ 3.34�� ���� �����̻��� ���ڸ� �ϳ��� ���� ����
		int startPosition = -1, endPosition = -1;
		
		/*
			���� ǥ��� ����
			1. �ǿ�����(����)�� ���ÿ� �״´�
			2. �����ڸ� ������ ���ÿ��� 2ȸ ��ȯ(pop)�� �ϰ� [�ι�° ��ȯ�� ������ (����) ù��° ��ȯ�� ������]�� ����� �ٽ� ���ÿ� �״´�
		*/
		
		for(int i=0; i<postfixExpression.length(); i++) {
			//������ ��� �׳� �Ѿ��
			if(postfixExpression.charAt(i) == SPACE) continue;
			
			//������ ��� ==> ���ÿ� �״´�.
			if(isNumber(postfixExpression.charAt(i))) {
				
				//ù�����̶�� ù �ε��� ����
				if(startPosition == -1) //������ ó���̸� 1.234�� 1�� index�� 0�̶�� startPosition�� ���� 0�� �ȴ�. 0���� 4������ �ϳ��� ���ÿ� ���� �ȴ�
					startPosition = i;
				
				//���� ���ڰ� ���ڰ� �ƴ� ��� ���ÿ� �״´�. �������ڰ� �����̰ų� �����ڸ� ���ÿ� ���� �ֱ�
				if(!isNumber(postfixExpression.charAt(i+1))) {
					String token = "";
					
					endPosition = i; //���� �ݺ����� �ε��������� ������ ���Ͽ� ��
					
					for(; startPosition<=endPosition; startPosition++) {
						token += postfixExpression.charAt(startPosition);
					}
					
					lls.Push(stack, lls.createNode(token));
					
					startPosition = -1; //���� ���ÿ� ���� �Ŀ� ù �ε��� -1�� ����
					endPosition = -1;
				}
				
				continue;
			}
			
			//�������� ��� ���ÿ��� 2ȸ ��ȯ(pop)�� ���� �� ���� ����� �ٽ� ���ÿ� ����
			Node firstNode = lls.Pop(stack);
			Node secondNode = lls.Pop(stack);
			
			double firstData = Double.valueOf(firstNode.data); //�ֻ�ܿ� �ִ� �� - �ڿ��� ���
			double secondData = Double.valueOf(secondNode.data); //�տ��� ���
			double resultData = 0; //��� ���� ������ ����
			
			switch (postfixExpression.charAt(i)) { //���� �����ڷ� ��
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
			
			lls.Push(stack, lls.createNode(String.valueOf(resultData))); //double�� String������ ������ ����� ������� ���ÿ� ����
		
		} //end for
		
		//���� �� ��ȯ
		Node resultNode = lls.Pop(stack);
		double result = Double.valueOf(resultNode.data);
		
		return result; //���� ����� ��ȯ
		
	} //end function calculate
	
}
