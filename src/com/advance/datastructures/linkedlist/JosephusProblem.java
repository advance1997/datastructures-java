package com.advance.datastructures.linkedlist;

/**
 * 约瑟夫问题
 * 	约瑟夫问题是个有名的问题：
 * 		N个人围成一圈，从第一个开始报数，
 * 		第M个将被杀掉，最后剩下一个，其余人都将被杀掉。
 * 		例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3。
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
 * 环形链表类
 * @author advance
 *
 */
class CircleSingleLinkedList{
	
	private JpsNode head;
	
	private int size;
	
	/**
	 * 初始化环形链表
	 * @param size
	 */
	public CircleSingleLinkedList(int size){
		if(size < 1){
			throw new RuntimeException("环形链表的个数必须大于0！");
		}
		head = null;
		this.size = size;
		
		// 辅助指针，帮助构建环形链表
		JpsNode curNode = null; 
		
		for(int i = 1; i <= size; i++){
			//创建节点
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
			System.out.println("链表为空，没有数据！");
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
	 * 环形链表，实现约瑟夫问题
	 * @param start 起始位置
	 * @param jumpNum 间隔位数
	 */
	public void circleNum(int startNum, int jumpNum){
		//创建辅助指针,帮助节点出圈
		JpsNode temp = head;
		while(temp.getNext() != head){
			temp = temp.getNext();
		}
		//先找到起始报数的位置
		for(int i = 0; i < startNum -1 ; i++ ){
			head = head.getNext();
			temp = temp.getNext();
		}
		
		//转回自身的时候则表示其他节点已经全部出去了，也就是指最后一个人
		while(temp != head){
			//开始往后数，并将指到的元素移除
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
 * 创建节点
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