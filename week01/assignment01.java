package week01;

import java.util.*;

/*
 * Konkuk University
 * Dept. Computer Engineering
 * Minwhoan Kim, 201611253
 */
public class assignment01 {
	public static void main(String[] args)
	{
		System.out.println("Minwhoan Kim, 201611253");
		Scanner scan = new Scanner(System.in);
	//	char[] exp = scan.nextLine().toCharArray();
		
		System.out.println("Please Input Expression");
		Calculator cal = new Calculator(scan.nextLine().toCharArray());
		scan.close();
		
		System.out.println("-------Calculate-------");
		
		if(cal.isExpressionValid())
		{
			cal.ConvToRPNExp();
			System.out.println( cal.EvalRPNExp() );
		}
	}
}

class Calculator
{
	private char[] expression;
	private char[] postfixExpression;
	
	Calculator(char[] exp){
		System.out.println("----Your Expression----");
		expression = exp;
		System.out.println(expression);
	}
	
	public boolean isExpressionValid() {
		if(expression.length > 0)
			return true;
		else
			return false;
	}
	protected void ConvToRPNExp() {

		Stack<Character> stack = new Stack<>();
		
		int expLen = expression.length;
		ArrayList<Character> convExp = new ArrayList<>();
		
		int i, idx = 0;
		char tok, popOp;
		//-1 = init, 0 = number, 1 = operator
		int preChar = -1;
		boolean artificialBraket = false;
		char artificalOperator = '+';
		
		for(i = 0; i < expLen; i++)
		{
			tok = expression[i];
			if(Character.isDigit(tok))
			{
				if(preChar == 0)
				{
					convExp.remove(--idx);
				}
				convExp.add( idx++, tok );
				convExp.add( idx++, ' ');
				
				if(artificialBraket)
				{
					convExp.add( idx++, artificalOperator );
					convExp.add( idx++, ' ');
					convExp.add( idx++, ')');
					convExp.add( idx++, ' ');
					
					artificalOperator = '+';
					artificialBraket = false;
				}
				preChar = 0;
			}
			else
			{
				//괄호면 0으로 보내고 밀어내기...
				//0 = +, 1 = -, 2 = * , 3 = /
				int curOper = -1;
				switch(tok)
				{
				case '(':
					stack.push(tok);
					convExp.add(idx++, '(');
					convExp.add(idx++, ' ' );
					preChar = 2;
					break;
				case ')':
					while(true)
					{
						popOp = stack.pop();
						if(popOp == '(') {
							convExp.add(idx++, ')');
							convExp.add(idx++, ' ' );
							break;
						}
						convExp.add(idx++, popOp);
						convExp.add(idx++, ' ');
					}
					preChar = 2;
					break;
				case '+': case '-': 
				case '*': case '/':
					if(tok == '+')
						curOper = 0;
					else if(tok == '-')
						curOper = 1;
					else if(tok == '*')
						curOper = 2;
					else if(tok == '/')
						curOper = 3;
					
					char[] currentOperator = {'+', '-', '*', '/'};
					
					//처음부터 연산자라면
					if(i == 0)
					{
						//근데 -라면, 
						if(currentOperator[curOper] == '-' || currentOperator[curOper] == '*' || currentOperator[curOper] == '/')
						{
							//앞에 0을 넣어줌
							convExp.add(idx++, '0');
							convExp.add(idx++, ' ');
							stack.push(currentOperator[curOper]);
							
						}
					}else {
						if(preChar == 1)
						{	
							char preOper = stack.peek();
							//+는 무시해도됨...
							if(curOper == 1)
							{
								//* /였을때 , -면 곱해짐...
								if(preOper == '*' || preOper == '/')
								{
									convExp.add(idx++, '(');
									convExp.add(idx++, ' ');
									convExp.add(idx++, '0');
									convExp.add(idx++, ' ');
									artificalOperator = currentOperator[curOper];
									artificialBraket = true;
								}
								else if(preOper == '-')
								{
									//이전에도 -였으면 +로 바꿔줘야함.
									stack.pop();
									stack.push('+');
								}
							}
							else if(curOper == 2 || curOper == 3)
							{
								//지금 * 혹은 / 일 경우.. 어떤 경우든 이전껄 날려버림..
						//		if(preOper == '-' || preOper == '+')
						//		{
									stack.pop();
									stack.push(currentOperator[curOper]);
						//		}
								
							}
						}else {
							while(!stack.isEmpty() && WhoPrecOp(stack.peek(), tok) >= 0)
							{
								convExp.add(idx++, stack.pop());
								convExp.add(idx++, ' ');
							}
							stack.push(tok);
						}
						preChar = 1;
					}
					break;
				}
				
				
			}
		}
		
		while(!stack.isEmpty())
		{
			convExp.add(idx++, stack.pop());
		}
		
		char[] result = new char[convExp.size()];
		for(i = 0; i < convExp.size(); i++){
			result[i] = convExp.get(i);
	//		System.out.print(result[i]);
		}
	//	System.out.println("");
		postfixExpression = result;
//		return result;
	}
	
	private int GetOpPrec(char op)
	{
		switch(op)
		{
		case '*':
		case '/':
			return 5;
		case '+':
		case '-':
			return 3;
		case '(':
			return 1;
		}
		
		return -1;
	}
	
	private int WhoPrecOp(char op1, char op2)
	{
		int op1Prec = GetOpPrec(op1);
		int op2Prec = GetOpPrec(op2);
		
		if (op1Prec > op2Prec)
			return 1;
		else if(op1Prec < op2Prec)
			return -1;
		else return 0;
	}
	
	protected int EvalRPNExp()
	{
		String exp = String.copyValueOf(postfixExpression);
		String[] temp = exp.split(" ");
		String[] arr = new String[temp.length];
		
		for(int i = 0; i < temp.length; i++)
			arr[i] = temp[i];
		
		Stack<String> stack = new Stack<>();
		String tok;
		
		int A, B;
		
		boolean isBraket = false;
		
		int braketIndex = 0, printListIndex = 0;
		
		ArrayList<String> printList = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++)
		{
			tok = arr[i];
			//tok의 첫 글자가 숫자면 당연히 숫자임...
			if( Character.isDigit(tok.charAt(0)) )
			{
				stack.push(tok);
			}else {
				if(tok.charAt(0) == '(')
				{
					braketIndex = printListIndex;
					printListIndex = 0;
					isBraket = true;
				}else if(tok.charAt(0) == ')')
				{
					printListIndex = braketIndex;
					braketIndex = 0;
					
					isBraket = false;
				}
				else
				{
					B = Integer.parseInt(stack.pop());
					if(!stack.isEmpty())
						A = Integer.parseInt(stack.pop());
					else
						A = 0;
					
					char operator = tok.charAt(0);
					
					if(isBraket)
					{
						braketIndex++;
					}
					
					switch(operator)
					{
					case '+':
						stack.push(Integer.toString(A + B));
						printList.add(printListIndex, A + " + " + B + " = " + (A+B));
						break;
					case '-':
						stack.push(Integer.toString(A - B));
						printList.add(printListIndex, A + " - " + B + " = " + (A-B));
						break;
					case '*':
						stack.push(Integer.toString(A * B));
						printList.add(printListIndex, A + " * " + B + " = " + (A*B));
						break;
					case '/':
						stack.push(Integer.toString(A / B));
						printList.add(printListIndex, A + " / " + B + " = " + (A/B));
						break;
					}
					printListIndex++;
				}
				
			}
		}
		for(int i = 0; i < printList.size(); i++)
			System.out.println(printList.get(i));
	
		System.out.println("-------Result is-------");
		return Integer.parseInt(stack.pop());
	}
}
