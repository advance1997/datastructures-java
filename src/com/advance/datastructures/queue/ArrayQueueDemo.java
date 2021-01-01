package com.advance.datastructures.queue;

/**
 * 
 * ʹ������ʵ�ֶ���
 * 
 * �ζ��в��ǻ��ζ��У������ظ�ʹ�ã�Ҳ��һ���Զ���
 * 
 * ���е����ԣ��Ƚ��ȳ���FIFO��
 * ˼·��
 * 	ʹ��һ��ͷָ������ָ���һ��Ԫ�ص���һ��λ��
 * 	ʹ��һ��βָ������ָ�����һ��Ԫ�ص�λ��
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
 * ʹ������ģ�����
 * @author advance
 *
 */
class ArrayQueue{
	
	/**
	 * ����һ��ͷָ��
	 */
	private int front = -1;
	
	/**
	 * ����һ��βָ��
	 */
	private int rear = -1;
	
	/**
	 * ����һ���������
	 */
	private int maxSize;
	
	/**
	 * ����һ���������ڴ洢����
	 */
	private int[] arr;
	
	/**
	 * ���캯��
	 * @param size
	 */
	public ArrayQueue(int size){
		maxSize = size;
		arr = new int[maxSize];
	}
	
	/**
	 * �����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return front == rear;
	}
	
	/**
	 * �����Ƿ�����
	 * @return
	 */
	public boolean isFull(){
		return rear == maxSize - 1;
	}
	
	/**
	 * βָ��ָ�����һ��Ԫ�أ�ͬʱͷָ����ǰ��һ
	 * �����
	 */
	public void add(int data){
		if(isFull()){
			throw new RuntimeException("�����������޷��������ݣ�");
		}
		rear++;
		arr[rear] = data;
	}
	
	/**
	 * ������
	 * ͷָ��ָ�����һ��Ԫ�أ�ͬʱͷָ����ǰ��һ
	 */
	public int out(){
		if(isEmpty()){
			throw new RuntimeException("���пգ�����ȡ����");
		}
		front++;
		return arr[front];
	}
	
	/**
	 * ��ӡ����
	 */
	public void display(){
		if(isEmpty()){
			System.out.println("���пյģ�û������~~");
			return;
		}
		for(int i =0; i < maxSize; i++){
			System.out.println("Queue["+i+"]="+arr[i]);
		}
	}
	
	/**
	 * ��ȡ���еĵ�һ��Ԫ��
	 * @return
	 */
	public int headQueue(){
		if(isEmpty()){
			throw new RuntimeException("���пգ�����ȡ����");
		}	
		return arr[front+1];
	}
	
}
