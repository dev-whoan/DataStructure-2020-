package Assignment0302;

public class AssignmentStackQueue {
	public static void main(String args[]) {
		char enqueue1[] = new char[] {'a', 'p', 'p', 'l', 'e'};
		char enqueue2[] = new char[] {'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n'};
		char enqueue3[] = new char[] {'y', ' ', 'p', 'r', 'o', 'j', 'e', 'c', 't'};
		
		System.out.println("학번: 201611253, 이름: 김민환, 과목: 자료구조(3190) 프로그램 시작");
		
		AsgStackQueue SQ = new AsgStackQueue(10);
		
		//enquee Apple
		for(int i = 0; i < enqueue1.length; i++)
			SQ.enqueue(enqueue1[i]);
		
		//dequeue 3 letters -> le ( - app )
		System.out.println("\n=*=*Dequeue 3 letters*=*=");
		for(int i = 0; i < 3; i++)
			System.out.print(SQ.dequeue() + " ");
		
		System.out.println("\n");
		
		//enqueue plication -< leplication 
		for(int i = 0; i < enqueue2.length; i++)
			SQ.enqueue(enqueue2[i]);
		
		
		//dequeue 5 letters -> cation ( - lepli )
		System.out.println("\n=*=*Dequeue 5 letters*=*=");
		for(int i = 0; i < 5; i++)
			System.out.print(SQ.dequeue() + " ");
		
		System.out.println("\n");
		
		//enqueue y project -> cationy project
		for(int i = 0; i < enqueue3.length; i++)
			SQ.enqueue(enqueue3[i]);
		
		//dequeue 4 letters -> ony project ( - cati )
		System.out.println("\n=*=*Dequeue 4 letters*=*=");
		for(int i = 0; i < 4; i++)
			System.out.print(SQ.dequeue() + " ");
		
		System.out.println("\n");

		
		//Dequeue all letters
		System.out.println("\n=*=*Dequeue whole left letters*=*=");
		while(!SQ.isEmpty()) {
			System.out.print(SQ.dequeue() + " ");
		}
		
		System.out.println("\n");
		System.out.println("학번: 201611253, 이름: 김민환, 과목: 자료구조(3190) 프로그램 종료");
	}
}
