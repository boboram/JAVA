package stackCalculator;

import java.util.Scanner;

public class test_stackCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String infixExpression = ""; //����ڰ� �Է��� ���� ǥ����� ����� ����
		String postfixExpression = ""; //����ڰ� �Է��� ���� ǥ����� ���� ǥ������� ����Ǿ� ����� ����
		stackCalculator calc = new stackCalculator();
		
		/*���� ǥ��� �Է�*/
		System.out.print("Enter infix expression : ");
		infixExpression = sc.nextLine();
		
		/*���� ǥ������� ��ȯ*/
		postfixExpression = calc.getPostfix(infixExpression, postfixExpression);
		
		System.out.println("postfixExpression : " + postfixExpression);
		
		/*���� ǥ������� ��ȯ�� ���� ���*/
		System.out.println("result : " + calc.calculate(postfixExpression));
	}

}
