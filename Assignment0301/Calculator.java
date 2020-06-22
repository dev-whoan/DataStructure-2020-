package Assignment0301;

class Calculator
{
	private char[] expression;
	private char[] postfixExpression;
	private int expLen;
	
	Calculator(char[] exp){
		expression = exp;
		expLen = expression.length;
	}
	
	public boolean isExpressionValid() {
		if(expression.length > 0)
			return true;
		else
			return false;
	}
	protected void ConvToRPNExp() {

		ArrayStack stack = new ArrayStack(expLen);
		int expLen = expression.length;
		char convExp[] = new char[expLen*2];
		
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
					--idx;
				}
				convExp[idx++] = tok;
				convExp[idx++] = ' ';
				
				if(artificialBraket)
				{
					convExp[idx++] = artificalOperator;
					convExp[idx++] = ' ';
					convExp[idx++] = ')';
					convExp[idx++] = ' ';
					
					artificalOperator = '+';
					artificialBraket = false;
				}
				preChar = 0;
			}
			else
			{
				//��ȣ�� 0���� ������ �о��...
				//0 = +, 1 = -, 2 = * , 3 = /
				int curOper = -1;
				switch(tok)
				{
				case '(':
					stack.push(tok);
					convExp[idx++] = '(';
					convExp[idx++] = ' ';
					preChar = 2;
					break;
				case ')':
					while(true)
					{
						popOp = (Character) stack.pop();
						if(popOp == '(') {
							convExp[idx++] = ')';
							convExp[idx++] = ' ';
							break;
						}
						convExp[idx++] = popOp;
						convExp[idx++] = ' ';
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
					
					//ó������ �����ڶ��
					if(i == 0)
					{
						//�ٵ� -���, 
						if(currentOperator[curOper] == '-' || currentOperator[curOper] == '*' || currentOperator[curOper] == '/')
						{
							//�տ� 0�� �־���
							convExp[idx++] = '0';
							convExp[idx++] = ' ';
							stack.push(currentOperator[curOper]);
							
						}
					}else {
						if(preChar == 1)
						{	
							char preOper = (Character) stack.peek();
							//+�� �����ص���...
							if(curOper == 1)
							{
								//* /������ , -�� ������...
								if(preOper == '*' || preOper == '/')
								{
									convExp[idx++] = '(';
									convExp[idx++] = ' ';
									convExp[idx++] = '0';
									convExp[idx++] = ' ';
									artificalOperator = currentOperator[curOper];
									artificialBraket = true;
								}
								else if(preOper == '-')
								{
									//�������� -������ +�� �ٲ������.
									stack.pop();
									stack.push('+');
								}
							}
							else if(curOper == 2 || curOper == 3)
							{
								//���� * Ȥ�� / �� ���.. � ���� ������ ��������..
						//		if(preOper == '-' || preOper == '+')
						//		{
									stack.pop();
									stack.push(currentOperator[curOper]);
						//		}
								
							}
						}else {
							
							while(!stack.isEmpty() && WhoPrecOp((Character) stack.peek(), tok) >= 0)
							{
								convExp[idx++] = ((Character) stack.pop());
								convExp[idx++] = ' ';
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
			convExp[idx++] = ((Character) stack.pop());
			convExp[idx++] = ' ';
		}
		
		char[] result = new char[convExp.length];
		for(i = 0; i < convExp.length; i++){
			result[i] = convExp[i];
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
		double op1Prec = GetOpPrec(op1);
		double op2Prec = GetOpPrec(op2);
		
		if (op1Prec > op2Prec)
			return 1;
		else if(op1Prec < op2Prec)
			return -1;
		else return 0;
	}
	
	protected double EvalRPNExp()
	{
		String exp = String.copyValueOf(postfixExpression);
		String[] temp = exp.split(" ");
		String[] arr = new String[temp.length];
		
		for(int i = 0; i < temp.length; i++)
		{
			arr[i] = temp[i];
		}
	//	Stack<String> stack = new Stack<>();
		ArrayStack stack = new ArrayStack(temp.length);
		String tok;
		
		double A, B;
		
		boolean isBraket = false;
		
		int braketIndex = 0, printListIndex = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			tok = arr[i];
			//tok�� ù ���ڰ� ���ڸ� �翬�� ������...
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
				//	B = Double.parseDouble(stack.pop());
					B = (Double.parseDouble((String) stack.pop()));
					if(!stack.isEmpty())
						A = (Double.parseDouble((String) stack.pop())); // Double.parseDouble(stack.pop());
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
						stack.push(Double.toString(A + B));
						break;
					case '-':
						stack.push(Double.toString(A - B));
						break;
					case '*':
						stack.push(Double.toString(A * B));
						break;
					case '/':
						stack.push(Double.toString(A / B));
						break;
					}
					printListIndex++;
				}
				
			}
		}
	
		return (Double.parseDouble((String)stack.pop()));//Double.parseDouble(stack.pop());
	}
}