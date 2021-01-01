package com.advance.datastructures.stack;

/**
 * 使用链表实现栈
 * 使用头插法，先进后出
 * @author advance
 *
 */
public class LinkListStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkStack stack = new LinkStack(10);
		stack.push(16);
		stack.push(12);
		stack.push(26);
		stack.push(32);
		stack.push(10);
		stack.push(35);
		stack.push(73);
		stack.display();
		System.out.println("-========pop=========-");
		stack.pop();
		stack.display();
		System.out.println("栈大小="+stack.size());
		System.out.println("栈顶元素"+stack.peak());
	}

}

class LinkStack{
	
	//栈顶元素
	private Node head;
	//栈内个数
	private int elementSize;
	//容量
	private int maxSize;
	
	public LinkStack(int size){
		this.head = null;
		this.maxSize = size;
		this.elementSize = 0;
	}
	
	public boolean isFull(){
		return maxSize == elementSize;
	}
	
	public boolean isEmpty(){
		return elementSize == 0;
	}
	
	public void push(int val){
		if(isFull()){
			throw new RuntimeException("Stack is Full");
		}
		Node node = new Node(val);
		node.next = head;
		head = node;
		elementSize++;
	}
	
	public void pop(){
		if(isEmpty()){
			throw new RuntimeException("Stack is Empty");
		}
		System.out.println(head.val);
		head = head.next;
		elementSize--;
	}
	
	public void display(){
		Node temp = head;
		while(temp != null){
			System.out.println(" => " + temp.val);
			temp = temp.next;
		}
	}
	
	/**
	 * 返回栈的数据大小
	 * @return
	 */
	public int size(){
		return 	elementSize;
	}
	
	/**
	 * 返回栈顶元素
	 * @return
	 */
	public int peak(){
		return head.val;
	}
	
}

class Node{
	
	int val;
	
	Node next;
	
	public Node(int val){
		this.val = val;
	}
	
}