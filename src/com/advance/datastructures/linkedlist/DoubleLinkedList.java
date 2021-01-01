package com.advance.datastructures.linkedlist;

/**
 * 双向链表
 * @author advance
 *
 */
public class DoubleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Link link = new Link();
		Node node1 = new Node(1, 23);
		Node node2 = new Node(2, 15);
		Node node3 = new Node(3, 39);
		Node node4 = new Node(4, 21);
		link.add(node1);
		link.add(node2);
		link.add(node3);
		link.add(node4);
		link.remove(2);
		Node nodeUpdate = new Node(1, 35);
		link.update(nodeUpdate);
		Node node5 = new Node(2, 19);
		link.addByOrder(node5);
		link.display();
		System.out.println(link.size());
	}

}

class Link{
	
	private Node head = new Node(0,0);
	
	public Node getHead(){
		return head;
	}
	
	public void add(Node node){
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
			if(temp.val == node.val){
				System.out.println("链表中已存在该值，无法插入！");
				return;
			}
		}
		temp.next = node;
		node.pre = temp;
	}
	
	public void display(){
		Node temp = head.next;
		while(temp != null){
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	public void remove(int no){
		Node temp = head.next;
		while(temp != null){
			if(no == temp.no){
				temp.next.pre = temp.pre;
				temp.pre.next = temp.next;
				break;
			}
			temp = temp.next;
		}
	}
	
	public void update(Node node){
		Node temp = head.next;
		while(temp != null){
			if(node.no == temp.no){
				temp.val = node.val;
				break;
			}
			temp = temp.next;
		}
	}
	
	public void addByOrder(Node node){
		Node temp = head.next;
		while(temp != null){
			if(node.no > temp.no){
				node.next = temp.next;
				temp.next.pre = node;
				node.pre = temp;
				temp.next = node;
				break;
			}
			temp = temp.next;
		}
	}
	
	public int size(){
		Node temp = head;
		int size = 0;
		while(temp.next != null){
			size++;
			temp = temp.next;
		}
		return size;
	}
	
}

/**
 * 双向链表节点
 * @author advance
 *
 */
class Node{
	
	public int no;
	
	public int val;
	
	public Node next;
	
	public Node pre;
	
	public Node(int no, int val){
		this.val = val;
		this.no = no;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}
	
}