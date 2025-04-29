package in.abhi.stack;

import java.util.Stack;

public class Push_At_Botton_of_stack {
	public static void pushAtBottom(Stack<Integer> s,int data) {
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		
		int top=s.pop();
		pushAtBottom(s, data);
		s.push(top);
	}
	public static void printStack(Stack<Integer> s) {
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		printStack(s);
		pushAtBottom(s, 5);
		printStack(s);

	}
	
}
