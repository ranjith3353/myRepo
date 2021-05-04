package training.java_training.data_structures;

import java.util.Stack;

public class PrefixToPostfixStackOperation {

	// check if character is operator or not
	  static boolean isOperator(char ch)
	  {
	    if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
	    return true;
	 
	    return false;
	  }
	 
	  // Convert prefix to Postfix expression
	  static String convertPrefixToPostfix(String prefix)
	  {
	    Stack<String> postFix = new Stack<>();
	 
	    // length of prefix expression
	    int n = prefix.length();
	 
	    // reading from right to left
	    for (int i = n - 1; i >= 0; i--)
	    {
	      char ch= prefix.charAt(i);
	 
	      // check if symbol is operator
	      if (isOperator(ch))
	      {
	      // pop two operands from stack
	      String first = postFix.pop();
	 
	      String second = postFix.pop();
	 
	      // concat the operands and operator to form Postfix
	      String temp_postFix = first + second + ch;
	 
	      // Push the partly evaluated postfix back to stack
	      postFix.push(temp_postFix);
	      }
	 
	      // if symbol is an operand
	      else 
	      { 
	      // push the operand to the stack
	      postFix.push(ch + "");
	      }
	    }
	 
	    // stack contains only the Postfix expression
	    return postFix.pop();
	  }
	 
	  public static void main(String args[])
	  {
	    String prefix = "/+AB-CD";      // Infix is : (A+B) / (C-D).
	    System.out.println("The Prefix Expression is: "+prefix);
	    String result = convertPrefixToPostfix(prefix);
	    System.out.println("The Equivalent Postfix is : "+ result);  
	 
	    System.out.println();
	 
	    prefix = "*+AB/-CDE";          // Infix is : (A+B) * ((C-D)/E).
	    System.out.println("The Prefix Expression is: "+prefix);
	    result = convertPrefixToPostfix(prefix);
	    System.out.println("The Equivalent Postfix is : "+ result);  
	 
	  }
}
