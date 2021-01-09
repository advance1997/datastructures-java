package com.advance.datastructures.stack;

/**
 * ʹ��ջʵ��һ�����׵�����������
 * ���磺3+5*��1+6��-2
 * 	
 * ǰ׺���ʽ��Ҳ�в������ʽ����
 * 	
 * @author advance
 *
 */
public class Caculator {
	
	public static void main(String[] args){
		String expression = "7*4*2-9+5-3+7-4";
		//��������ջ���ֱ������洢������������
		Stack operate = new Stack(10);
		Stack num = new Stack(10);
		
		//ָ�����ڼ�¼��ǰ�Ƿ��Ѿ���������ʽ
		int index = 0;
		int num1 = 0; 
		int num2 = 0;
		int oper = 0;
		int res = 0;
		//���ڼ�¼��ǰ����ɨ����ַ�����Ϊ�����Ƕ�λ����
		String strTemp = "";
		//��ÿ��ɨ��õ�char���浽ch
		char ch = ' '; 
		while(true){
			ch = expression.substring(index).charAt(0);
			//�ж�ch��ʲô��Ȼ������Ӧ�Ĵ���
			//����������
			if(isOper(ch)){
				if(!operate.isEmpty()) {
					//�������ջ�в��������ͽ��бȽ�,�����ǰ�Ĳ����������ȼ�С�ڻ��ߵ���ջ�еĲ�����,����Ҫ����ջ��pop��������,
					//�ڴӷ���ջ��pop��һ�����ţ��������㣬���õ����������ջ��Ȼ�󽫵�ǰ�Ĳ����������ջ
					if(priority(ch) <= priority(operate.peek())) {
						num1 = num.pop();
						num2 = num.pop();
						oper = operate.pop();
						res = cal(num1, num2, oper);
						//������Ľ������ջ
						num.push(res);
						//Ȼ�󽫵�ǰ�Ĳ����������ջ
						operate.push(ch);
					} else {
						//�����ǰ�Ĳ����������ȼ�����ջ�еĲ������� ��ֱ�������ջ.
						operate.push(ch);
					}
				}else {
					//���Ϊ��ֱ�������ջ..
					operate.push(ch); // 1 + 3
				}
			}
			//���������
			else{
				//numStack.push(ch - 48); //? "1+3" '1' => 1
				//����˼·
				//1. �������λ��ʱ�����ܷ�����һ������������ջ����Ϊ�������Ƕ�λ��
				//2. �ڴ���������Ҫ��expression�ı��ʽ��index ���ٿ�һλ,��������ͽ���ɨ�裬����Ƿ��Ų���ջ
				//3. ���������Ҫ����һ������ �ַ���������ƴ��
				
				//�����λ��
				strTemp += ch;
				
				//���ch�Ѿ���expression�����һλ����ֱ����ջ
				if (index == expression.length() - 1) {
					num.push(Integer.parseInt(strTemp));
				}else{
				
					//�ж���һ���ַ��ǲ������֣���������֣��ͼ���ɨ�裬����������������ջ
					//ע���ǿ���һλ������index++
					if (isOper(expression.substring(index+1,index+2).charAt(0))) {
						//�����һλ�������������ջ keepNum = "1" ���� "123"
						num.push(Integer.parseInt(strTemp));
						//��Ҫ��!!!!!!, keepNum���
						strTemp = "";
						
					}
				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		//�����ʽɨ����ϣ���˳��Ĵ� ��ջ�ͷ���ջ��pop����Ӧ�����ͷ��ţ�������.
		while(true) {
			//�������ջΪ�գ�����㵽���Ľ��, ��ջ��ֻ��һ�����֡������
			if(operate.isEmpty()) {
				break;
			}
			num1 = num.pop();
			num2 = num.pop();
			oper = operate.pop();
			res = cal(num1, num2, oper);
			num.push(res);//��ջ
		}
		//����ջ���������pop�������ǽ��
		int res2 = num.pop();
		System.out.printf("���ʽ %s = %d", expression, res2);
	}

	//�ж��ǲ���һ�������
	public static boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	
	//��������������ȼ������ȼ��ǳ���Ա��ȷ��, ���ȼ�ʹ�����ֱ�ʾ
	//����Խ�������ȼ���Խ��.
	// �ٶ�Ŀǰ�ı��ʽֻ�� +, - , * , /
	public static int priority(int oper) {
		if(oper == '*' || oper == '/'){
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; 
		}
	}
	
	//���㷽��
	public static int cal(int num1, int num2, int oper) {
		int res = 0; // res ���ڴ�ż���Ľ��
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;// ע��˳��
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
	//ջ����
	private int maxSize;
	//����
	private int[] arr;
	//ջ��ָ��
	private int top;
	
	public Stack(int maxSize){
		this.top = -1;
		this.maxSize = maxSize;
		arr = new int[this.maxSize];
	}
	
	public boolean isFull(){
		return top == maxSize - 1;
	}
	
	//����һ�����������Է��ص�ǰջ����ֵ, ���ǲ���������pop
	public int peek() {
		return arr[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public void push(int data){
		if(isFull()){
			throw new RuntimeException("ջ�ռ�����");
		}
		top++;
		arr[top] = data;
	}
	
	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("ջΪ��");
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
