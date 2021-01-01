package com.advance.datastructures.linkedlist;

/**
 * Լɪ������
 * 	Լɪ�������Ǹ����������⣺
 * 		N����Χ��һȦ���ӵ�һ����ʼ������
 * 		��M������ɱ�������ʣ��һ���������˶�����ɱ����
 * 		����N=6��M=5����ɱ����˳���ǣ�5��4��6��2��3��
 * @author advance
 *
 */
public class JosephusProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleSingleLinkedList link = new CircleSingleLinkedList(6);
//		link.display();
		link.circleNum(1, 5);
	}

}

/**
 * ����������
 * @author advance
 *
 */
class CircleSingleLinkedList{
	
	private JpsNode head;
	
	private int size;
	
	/**
	 * ��ʼ����������
	 * @param size
	 */
	public CircleSingleLinkedList(int size){
		if(size < 1){
			throw new RuntimeException("��������ĸ����������0��");
		}
		head = null;
		this.size = size;
		
		// ����ָ�룬����������������
		JpsNode curNode = null; 
		
		for(int i = 1; i <= size; i++){
			//�����ڵ�
			JpsNode node = new JpsNode(i);
			if(i == 1){
				head = node;
				head.setNext(node);
				curNode = node;
			}else{
				curNode.setNext(node);
				node.setNext(head);
				curNode = node;
			}
		}
	}
	
	public void display(){
		if(head == null){
			System.out.println("����Ϊ�գ�û�����ݣ�");
			return;
		}
		JpsNode temp = head;
		while(true){
			System.out.println(temp);
			if(temp.getNext() == head){
				break;
			}
			temp = temp.getNext();
		}
		
	}
	
	/**
	 * ��������ʵ��Լɪ������
	 * @param start ��ʼλ��
	 * @param jumpNum ���λ��
	 */
	public void circleNum(int startNum, int jumpNum){
		//��������ָ��,�����ڵ��Ȧ
		JpsNode temp = head;
		while(temp.getNext() != head){
			temp = temp.getNext();
		}
		//���ҵ���ʼ������λ��
		for(int i = 0; i < startNum -1 ; i++ ){
			head = head.getNext();
			temp = temp.getNext();
		}
		
		//ת�������ʱ�����ʾ�����ڵ��Ѿ�ȫ����ȥ�ˣ�Ҳ����ָ���һ����
		while(temp != head){
			//��ʼ������������ָ����Ԫ���Ƴ�
			for(int i = 0; i < jumpNum-1; i++){
				head = head.getNext();
				temp = temp.getNext();
			}
			System.out.print(" ->" + head.getNo() + " ");
			head = head.getNext();
			temp.setNext(head);
		}
	}
	
}

/**
 * �����ڵ�
 * @author advance
 *
 */
class JpsNode{
	
	private int no;
	
	private JpsNode next;
	
	public JpsNode(int no){
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public JpsNode getNext() {
		return next;
	}

	public void setNext(JpsNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "JpsNode [no=" + no + "]";
	}
	
}