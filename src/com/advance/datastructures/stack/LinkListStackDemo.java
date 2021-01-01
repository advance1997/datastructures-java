package com.advance.datastructures.stack;

/**
 * ʹ������ʵ��ջ
 * ʹ��ͷ�巨���Ƚ����
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
		System.out.println("ջ��С="+stack.size());
		System.out.println("ջ��Ԫ��"+stack.peak());
	}

}

class LinkStack{
	
	//ջ��Ԫ��
	private Node head;
	//ջ�ڸ���
	private int elementSize;
	//����
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
	 * ����ջ�����ݴ�С
	 * @return
	 */
	public int size(){
		return 	elementSize;
	}
	
	/**
	 * ����ջ��Ԫ��
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