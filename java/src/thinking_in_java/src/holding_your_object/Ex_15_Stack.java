package holding_your_object;

//TIJ4 Chapter Holding, Exercise 15, page 415
/* Stacks are often used to evaluate expressions in programming 
* languages. Using net.mindview.util.Stack, evaluate the following
* expression, where '+' means "push the following letter onto the 
* stack," and '-' means "pop the top of the stack and print it":
* "+U+n+c---+e+r+t---+a+i+n+t+y---+ -+r+u--+l+e+s---"
*/

import java.util.Stack;

public class Ex_15_Stack {

	public static void main(String[] args) {
		
		final String text = "+3+3+e+v+d+b---+k";
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < text.length(); i++) {
			
			if (text.charAt(i) == '+') {
				i++;
				stack.push(text.charAt(i));
			}
		
			if (text.charAt(i) == '-')
				stack.pop();
		}
		
		for (Character s : stack)
			System.out.println(s);
		
	}
	
}


