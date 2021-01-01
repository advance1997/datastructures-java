package com.advance.datastructures.queue;

/**
 * 
 * 使用数组实现队列
 * 
 * 次队列不是环形队列，不能重复使用，也叫一次性队列
 * 
 * 队列的特性，先进先出（FIFO）
 * 思路：
 * 	使用一个头指针用于指向第一个元素的上一个位置
 * 	使用一个尾指针用于指向最后一个元素的位置
 * 
 * @author advance
 *
 */
public class ArrayQueueDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue queue = new ArrayQueue(4);
		queue.add(2);
		queue.add(5);
		queue.add(4);
		queue.add(9);
		queue.out();
		System.out.println(queue.headQueue());
		queue.display();
	}

}

/**
 * 使用数组模拟队列
 * @author advance
 *
 */
class ArrayQueue{
	
	/**
	 * 设置一个头指针
	 */
	private int front = -1;
	
	/**
	 * 设置一个尾指针
	 */
	private int rear = -1;
	
	/**
	 * 设置一个最大容量
	 */
	private int maxSize;
	
	/**
	 * 设置一个数组用于存储数据
	 */
	private int[] arr;
	
	/**
	 * 构造函数
	 * @param size
	 */
	public ArrayQueue(int size){
		maxSize = size;
		arr = new int[maxSize];
	}
	
	/**
	 * 队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return front == rear;
	}
	
	/**
	 * 队列是否已满
	 * @return
	 */
	public boolean isFull(){
		return rear == maxSize - 1;
	}
	
	/**
	 * 尾指针指向的下一个元素，同时头指针往前移一
	 * 入队列
	 */
	public void add(int data){
		if(isFull()){
			throw new RuntimeException("队列已满，无法插入数据！");
		}
		rear++;
		arr[rear] = data;
	}
	
	/**
	 * 出队列
	 * 头指针指向的下一个元素，同时头指针往前移一
	 */
	public int out(){
		if(isEmpty()){
			throw new RuntimeException("队列空，不能取数据");
		}
		front++;
		return arr[front];
	}
	
	/**
	 * 打印队列
	 */
	public void display(){
		if(isEmpty()){
			System.out.println("队列空的，没有数据~~");
			return;
		}
		for(int i =0; i < maxSize; i++){
			System.out.println("Queue["+i+"]="+arr[i]);
		}
	}
	
	/**
	 * 获取队列的第一个元素
	 * @return
	 */
	public int headQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列空，不能取数据");
		}	
		return arr[front+1];
	}
	
}
