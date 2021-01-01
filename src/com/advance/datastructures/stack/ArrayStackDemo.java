package com.advance.datastructures.stack;

/**
 * 
 * ʹ������ʵ��ջ���ݽṹ
 * ջ���ص㣺
 * 	���������Խṹ
 * 	�Ƚ������FILO��
 * @author advance
 *
 */
public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack arrayStack = new ArrayStack(5);
		arrayStack.push(10);
		arrayStack.push(20);
		arrayStack.push(30);
		arrayStack.push(40);
		arrayStack.push(50);
		arrayStack.pop();
		arrayStack.pop();
		arrayStack.display();
		System.out.println(arrayStack.size());
	}

}

/**
 * ����ʵ��ջ
 * @author advance
 *
 */
class ArrayStack{
	
	//ջ����
	private int maxSize;
	//����
	private int[] arr;
	//ջ��ָ��
	private int top;
	
	public ArrayStack(int maxSize){
		this.top = -1;
		this.maxSize = maxSize;
		arr = new int[this.maxSize];
	}
	
	public boolean isFull(){
		return top == maxSize - 1;
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
		System.out.println("top->"+top);
		top--;
		return arr[top];
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