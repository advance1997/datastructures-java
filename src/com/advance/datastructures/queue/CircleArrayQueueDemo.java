package com.advance.datastructures.queue;

/**
 * ʹ������ʵ�ֻ��ζ���
 * 
 * ʹ��frontָ���һ��Ԫ��
 * ʹ��rearָ�����һ��Ԫ�صĺ�һ��λ��
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
		System.out.println("========��ӡ����==========");
		c.display();
		System.out.println("����ͷΪ��"+c.headQueue());
		System.out.println(c.out()+"������");
		System.out.println("6�������");
		c.add(6);
		System.out.println("========�¶���==========");
		c.display();
		System.out.println("����ͷΪ��"+c.headQueue());
	}

}

/**
 * ʹ������ģ��ʵ�ֻ��ζ���
 */
class CircleArrayQueue{
	
	/**
	 * ����һ��ͷָ��
	 */
	private int front = 0;
	
	/**
	 * ����һ��βָ��
	 */
	private int rear = 0;
	
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
	public CircleArrayQueue(int size){
		maxSize = size + 1;
		arr = new int[maxSize];
	}
	
	/**
	 * �����Ƿ���
	 * rearָ��Ķ������һ��Ԫ�غ�һλ
	 * rear+1��Ϊ���еĳ���
	 * �ٸ�maxSizeȡģ����
	 * ����frontʱ���μ�������
	 * @return
	 */
	public boolean isFull(){
		return (rear + 1) % maxSize == front;
	}
	
	/**
	 * �����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return rear == front;
	}
	
	/**
	 * ��������Ԫ�أ���Ҫ������һλ��λ��
	 * ע��rearָ�����һ��Ԫ�ص���һ����ַ, 
	 * ���Բ���ʱ��ַ����rearֵ
	 * ����֮����Ҫ�ٴμ���rear��λ��
	 * ʹ��ȡģ������Ϊ�˻�����׼��
	 * @param data
	 */
	public void add(int data){
		if(isFull()){
			throw new RuntimeException("�����������޷��������ݣ�");
		}
		arr[rear] = data;
		rear = (rear + 1) % maxSize;
	}
	
	/**
	 * ����Ԫ�س��ң���Ҫ����front��λ��
	 * ע��frontָ��ǰԪ�صĵ�ַ, 
	 * ���Գ���ʱ��ַ����frontֵ
	 * ����֮����Ҫ�ٴμ���front��λ��
	 * ʹ��ȡģ������Ϊ�˻�����׼��
	 * @param data
	 */
	public int out(){
		if(isEmpty()){
			throw new RuntimeException("���пյģ�û������~~");
		}
		int temp = arr[front];
		front = (front + 1) % maxSize;
		return temp;
	}
	
	/**
	 * ��ӡ����
	 */
	public void display(){
		if(isEmpty()){
			System.out.println("���пյģ�û������~~");
			return;
		}
		for(int i = front; i < front + size(); i++){
			System.out.println("Queue["+(i % maxSize)+"]="+arr[i % maxSize]);
		}
	}
	
	/**
	 * ��ȡ��ǰ���ζ��еĴ�С
	 * 
	 * rear - front �󵽵�ǰ��ͷβ������
	 * ����maxsize��Ϊ��ȡ����ֵ
	 * ����maxsizeȡģ�ǿ��ǻ��¶���Ȼ��ȡ������С
	 * @return
	 */
	public int size(){
		return (rear + maxSize - front) % maxSize;
	}
	
	/**
	 * ��ʾ���е�ͷ���ݣ� ע�ⲻ��ȡ������
	 * @return
	 */
	public int headQueue() {
		// �ж�
		if (isEmpty()) {
			throw new RuntimeException("���пյģ�û������~~");
		}
		return arr[front];
	}
	
}