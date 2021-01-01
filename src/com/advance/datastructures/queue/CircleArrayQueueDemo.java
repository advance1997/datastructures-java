package com.advance.datastructures.queue;

/**
 * 使用数组实现环形队列
 * 
 * 使用front指向第一个元素
 * 使用rear指向最后一个元素的后一个位置
 * 
 * @author advance
 *
 */
public class CircleArrayQueueDemo {
	
	public static void main(String[] args){
		CircleArrayQueue c = new CircleArrayQueue(5);
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		System.out.println("========打印队列==========");
		c.display();
		System.out.println("队列头为："+c.headQueue());
		System.out.println(c.out()+"出队列");
		System.out.println("6加入队列");
		c.add(6);
		System.out.println("========新队列==========");
		c.display();
		System.out.println("队列头为："+c.headQueue());
	}

}

/**
 * 使用数组模拟实现环形队列
 */
class CircleArrayQueue{
	
	/**
	 * 设置一个头指针
	 */
	private int front = 0;
	
	/**
	 * 设置一个尾指针
	 */
	private int rear = 0;
	
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
	public CircleArrayQueue(int size){
		maxSize = size + 1;
		arr = new int[maxSize];
	}
	
	/**
	 * 队列是否满
	 * rear指向的队列最后一个元素后一位
	 * rear+1即为队列的长度
	 * 再跟maxSize取模运算
	 * 等于front时环形即队列满
	 * @return
	 */
	public boolean isFull(){
		return (rear + 1) % maxSize == front;
	}
	
	/**
	 * 队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return rear == front;
	}
	
	/**
	 * 新增队列元素，需要考虑下一位的位置
	 * 注意rear指向最后一个元素的下一个地址, 
	 * 所以插入时地址就是rear值
	 * 插入之后需要再次计算rear的位置
	 * 使用取模运算是为了环形做准备
	 * @param data
	 */
	public void add(int data){
		if(isFull()){
			throw new RuntimeException("队列已满，无法插入数据！");
		}
		arr[rear] = data;
		rear = (rear + 1) % maxSize;
	}
	
	/**
	 * 队列元素出兑，需要考虑front的位置
	 * 注意front指向当前元素的地址, 
	 * 所以出队时地址就是front值
	 * 插入之后需要再次计算front的位置
	 * 使用取模运算是为了环形做准备
	 * @param data
	 */
	public int out(){
		if(isEmpty()){
			throw new RuntimeException("队列空的，没有数据~~");
		}
		int temp = arr[front];
		front = (front + 1) % maxSize;
		return temp;
	}
	
	/**
	 * 打印队列
	 */
	public void display(){
		if(isEmpty()){
			System.out.println("队列空的，没有数据~~");
			return;
		}
		for(int i = front; i < front + size(); i++){
			System.out.println("Queue["+(i % maxSize)+"]="+arr[i % maxSize]);
		}
	}
	
	/**
	 * 获取当前环形队列的大小
	 * 
	 * rear - front 求到当前的头尾相差个数
	 * 加上maxsize是为了取得正值
	 * 在于maxsize取模是考虑换新队列然后取真正大小
	 * @return
	 */
	public int size(){
		return (rear + maxSize - front) % maxSize;
	}
	
	/**
	 * 显示队列的头数据， 注意不是取出数据
	 * @return
	 */
	public int headQueue() {
		// 判断
		if (isEmpty()) {
			throw new RuntimeException("队列空的，没有数据~~");
		}
		return arr[front];
	}
	
}