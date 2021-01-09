package com.advance.datastructures.stack;

/**
 * 使用栈实现一个简易的整数计算器
 * 例如：3+5*（1+6）-2
 * 	
 * 前缀表达式（也叫波兰表达式）：
 * 	
 * @author advance
 *
 */
public class Caculator {
	
	public static void main(String[] args){
		String expression = "7*4*2-9+5-3+7-4";
		//定义两个栈，分别用来存储操作符和数字
		Stack operate = new Stack(10);
		Stack num = new Stack(10);
		
		//指针用于记录当前是否已经遍历完表达式
		int index = 0;
		int num1 = 0; 
		int num2 = 0;
		int oper = 0;
		int res = 0;
		//用于记录当前的正扫描的字符，因为可能是多位数字
		String strTemp = "";
		//将每次扫描得到char保存到ch
		char ch = ' '; 
		while(true){
			ch = expression.substring(index).charAt(0);
			//判断ch是什么，然后做相应的处理
			//如果是运算符
			if(isOper(ch)){
				if(!operate.isEmpty()) {
					//如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
					//在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
					if(priority(ch) <= priority(operate.peek())) {
						num1 = num.pop();
						num2 = num.pop();
						oper = operate.pop();
						res = cal(num1, num2, oper);
						//把运算的结果如数栈
						num.push(res);
						//然后将当前的操作符入符号栈
						operate.push(ch);
					} else {
						//如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
						operate.push(ch);
					}
				}else {
					//如果为空直接入符号栈..
					operate.push(ch); // 1 + 3
				}
			}
			//如果是数字
			else{
				//numStack.push(ch - 48); //? "1+3" '1' => 1
				//分析思路
				//1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
				//2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
				//3. 因此我们需要定义一个变量 字符串，用于拼接
				
				//处理多位数
				strTemp += ch;
				
				//如果ch已经是expression的最后一位，就直接入栈
				if (index == expression.length() - 1) {
					num.push(Integer.parseInt(strTemp));
				}else{
				
					//判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
					//注意是看后一位，不是index++
					if (isOper(expression.substring(index+1,index+2).charAt(0))) {
						//如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
						num.push(Integer.parseInt(strTemp));
						//重要的!!!!!!, keepNum清空
						strTemp = "";
						
					}
				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		//当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
		while(true) {
			//如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
			if(operate.isEmpty()) {
				break;
			}
			num1 = num.pop();
			num2 = num.pop();
			oper = operate.pop();
			res = cal(num1, num2, oper);
			num.push(res);//入栈
		}
		//将数栈的最后数，pop出，就是结果
		int res2 = num.pop();
		System.out.printf("表达式 %s = %d", expression, res2);
	}

	//判断是不是一个运算符
	public static boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	
	//返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
	//数字越大，则优先级就越高.
	// 假定目前的表达式只有 +, - , * , /
	public static int priority(int oper) {
		if(oper == '*' || oper == '/'){
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; 
		}
	}
	
	//计算方法
	public static int cal(int num1, int num2, int oper) {
		int res = 0; // res 用于存放计算的结果
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;// 注意顺序
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
	
}

class Stack{
	//栈容量
	private int maxSize;
	//数组
	private int[] arr;
	//栈顶指针
	private int top;
	
	public Stack(int maxSize){
		this.top = -1;
		this.maxSize = maxSize;
		arr = new int[this.maxSize];
	}
	
	public boolean isFull(){
		return top == maxSize - 1;
	}
	
	//增加一个方法，可以返回当前栈顶的值, 但是不是真正的pop
	public int peek() {
		return arr[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public void push(int data){
		if(isFull()){
			throw new RuntimeException("栈空间已满");
		}
		top++;
		arr[top] = data;
	}
	
	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("栈为空");
		}
		int value = arr[top];
		top--;
		return value;
	}
	
	public void display(){
		for(int i = top; i >= 0; i--){
			System.out.println(arr[i]);
		}
	}
	
	public int size(){
		return top + 1;
	}
	
}
