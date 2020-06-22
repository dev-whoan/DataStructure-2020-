package Assignment0301;
import java.util.Scanner;

public class AssignmentArraystack {
	public static void main(String args[])
	{
		System.out.println("�й�: 201611253, �̸�: ���ȯ, ����: �ڷᱸ��(3190) ���α׷� ����");
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		
		scan.close();
		ArrayStack stack = new ArrayStack(input.length());
		
		for(int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == ' ')
				continue;
			stack.push(input.charAt(i));
		}
		
		input = null;
		
		int size = stack.size();
		
		char[] exp = new char[size];
		for(int i = 0; i < size; i++)
		{
			Object t = stack.pop();
			if( (Character)t == '(' || (Character) t == ')')
			{
				if( (Character) t == '(')
					t = ')';
				else
					t = '(';
			}
			
			exp[i] = (Character) t;
			System.out.print(exp[i]);
		}

		Calculator cal = new Calculator(exp);
	
		if(cal.isExpressionValid())
		{
			cal.ConvToRPNExp();
			String str = String.format("%f", cal.EvalRPNExp());
			System.out.println(" = " + str );
		}
		System.out.println("�й�: 201611253, �̸�: ���ȯ, ����: �ڷᱸ��(3190) ���α׷� ����");
	}
}
