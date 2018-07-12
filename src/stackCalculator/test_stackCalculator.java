package stackCalculator;

import java.util.Scanner;

public class test_stackCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String infixExpression = ""; //사용자가 입력한 중위 표기식이 저장될 변수
		String postfixExpression = ""; //사용자가 입력한 중위 표기식이 후위 표기식으로 변경되어 저장될 변수
		stackCalculator calc = new stackCalculator();
		
		/*중위 표기식 입력*/
		System.out.print("Enter infix expression : ");
		infixExpression = sc.nextLine();
		
		/*후위 표기식으로 전환*/
		postfixExpression = calc.getPostfix(infixExpression, postfixExpression);
		
		System.out.println("postfixExpression : " + postfixExpression);
		
		/*후위 표기식으로 전환된 식을 계산*/
		System.out.println("result : " + calc.calculate(postfixExpression));
	}

}
