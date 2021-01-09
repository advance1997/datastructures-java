package com.advance.datastructures.stack;

import java.util.Stack;

/**
 * 
 * 测试表达式括号是否正确
 * [(()){}]
 * 
 * @author advance
 *
 */
public class StackExpressionRinght {

	private static String expression = "[(()){}]{}";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<>();
		
		char[] exp_chars = expression.toCharArray();
		
		boolean flag = true;
		
		for(char c : exp_chars){
			if(c == '('){
				stack.push(')');
			}else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty()||c!=stack.pop()){
                flag = false;
            }
		}
		
		System.out.println(stack.isEmpty() && flag);
		
	}

}
