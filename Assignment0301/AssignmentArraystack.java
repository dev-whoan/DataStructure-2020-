package Assignment0301;
import java.util.Scanner;

public class AssignmentArraystack {
	public static void main(String args[])
	{
		System.out.println("학번: 201611253, 이름: 김민환, 과목: 자료구조(3190) 프로그램 시작");
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
		System.out.println("학번: 201611253, 이름: 김민환, 과목: 자료구조(3190) 프로그램 종료");
	}
}
