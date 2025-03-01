public class Notation {
	public Notation() {
		
	}
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		MyStack<Double> stack = new MyStack<>();
		for (int i=0;i<postfixExpr.toCharArray().length;i++) {
			if (postfixExpr.charAt(i)==' ') {       		
        	}
			else if (Character.isDigit(postfixExpr.charAt(i)) || postfixExpr.charAt(i)=='(') {
                stack.push((double) (postfixExpr.charAt(i)-'0'));
            } else if (postfixExpr.charAt(i)=='*' || postfixExpr.charAt(i)=='/' || postfixExpr.charAt(i)=='+' || postfixExpr.charAt(i)=='-') {
            	try {           
            		double secondValue = stack.pop();
                    double firstValue = stack.pop();
                    double finalDouble = 0;
                    if (postfixExpr.charAt(i) == '+') finalDouble = firstValue + secondValue;
                    else if (postfixExpr.charAt(i) == '-') finalDouble = firstValue - secondValue;
                    else if (postfixExpr.charAt(i) == '*') finalDouble = firstValue * secondValue;
                    else if (postfixExpr.charAt(i) == '/') finalDouble = firstValue / secondValue;
                    stack.push(finalDouble);
                } catch (StackUnderflowException | StackOverflowException e) {
                    throw new InvalidNotationFormatException();
                }
            }
		}
		if (stack.size() != 1) {
            throw new InvalidNotationFormatException();
        }
		return stack.pop();
	}
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<>();
		for (int i=0;i<postfix.toCharArray().length;i++) {
			if (postfix.charAt(i)==' ') {
				continue;
        	} else if (Character.isDigit(postfix.charAt(i))) {
        		stack.push(String.valueOf(postfix.charAt(i)));
        	}
        	else if (postfix.charAt(i)=='*' || postfix.charAt(i)=='/' || postfix.charAt(i)=='+' || postfix.charAt(i)=='-'){
        		try {
        			String secondValue = stack.pop();
        			String firstValue = stack.pop();              
                    String finalString = "(" + firstValue + postfix.charAt(i) + secondValue + ")";
                    stack.push(finalString);
        		} catch (StackUnderflowException | StackOverflowException e) {
        			throw new InvalidNotationFormatException();
        		}
        	}
		}
		if (stack.size() != 1) {
			throw new InvalidNotationFormatException();
		}
		return stack.pop();
	}
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		MyQueue<Character> queue = new MyQueue<>();
        MyStack<Character> stack = new MyStack<>();
        for (int i=0;i<infix.length();i++) {
        	if (infix.charAt(i)==' ') {       		
        	} else if (Character.isDigit(infix.charAt(i))) {
        		queue.enqueue(infix.charAt(i));
        	}
        	else if (infix.charAt(i)=='(') {
        		stack.push(infix.charAt(i));
        	} else if (infix.charAt(i)==')') {
        		try {
        			while (stack.top()!='(') {
            			queue.enqueue(stack.pop());
            		}
            		stack.pop();
        		} catch (StackUnderflowException | QueueOverflowException e) {
                    throw new InvalidNotationFormatException();
                }
        	} else {
        		while (!stack.isEmpty() && 
        				((stack.top() == '*' || stack.top() == '/') || 
                                ((stack.top() == '+' || stack.top() == '-') && (infix.charAt(i) == '+' || infix.charAt(i) == '-')))) {
        			queue.enqueue(stack.pop());
                }
                stack.push(infix.charAt(i));
        	}   	       	
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
		return queue.toString();
	}
}

