package com.advance.datastructures.linkedlist;

import java.util.Stack;

/**
 * 单链表
 * @author advance
 *
 */
public class SinglelinkedList {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList linkList = new LinkList();
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(8, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(4, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(15, "林冲", "豹子头");
		linkList.add(hero1);
		linkList.add(hero2);
		linkList.add(hero3);
		linkList.add(hero4);
//		linkList.addByOrder(hero1);
//		linkList.addByOrder(hero2);
//		linkList.addByOrder(hero3);
//		linkList.addByOrder(hero4);
//		linkList.addByOrder(hero4);
//		linkList.display();
//		System.out.println(linkList.get(2));
//		HeroNode hero5 = new HeroNode(2, "卢俊义", "玉麒麟up");
//		System.out.println("链表大小=======>"+linkList.size());
//		linkList.update(hero5);
//		linkList.display();
//		linkList.remove(new HeroNode(1, "宋江", "及时雨"));
//		System.out.println("链表大小=======>"+linkList.size());
//		linkList.remove(new HeroNode(2, "卢俊义", "玉麒麟up"));
//		System.out.println("链表大小=======>"+linkList.size());
//		linkList.remove(new HeroNode(3, "吴用", "智多星"));
//		linkLi+st.remove(new HeroNode(4, "林冲", "豹子头"));
//		System.out.println("========删除之后的链表=========");
//		linkList.display();
//		int k = 1;
//		System.out.println("链表倒数第"+k+"位节点为："+linkList.getLastKNode(k));
//		reversetLinkList(linkList);
//		reversePrint(linkList);
		
		LinkList linkList1 = new LinkList();
		HeroNode hero5 = new HeroNode(9, "宋江", "及时雨");
		HeroNode hero6 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero7 = new HeroNode(5, "吴用", "智多星");
		HeroNode hero8 = new HeroNode(13, "林冲", "豹子头");
		linkList1.add(hero5);
		linkList1.add(hero6);
		linkList1.add(hero7);
		linkList1.add(hero8);
		linkList.display();
		linkList1.display();
		System.out.println("==========合并后============");
		HeroNode temp = merge(linkList.getHead(), linkList1.getHead());
		while(temp.getNext() != null){
			System.out.println(temp.getNext());
			temp = temp.getNext();
		}
	}

	/**
	 * 反转链表
	 * 思路：
	 * 	使用头插法插入新的临时链表，然后打印新的临时链表即可实现链表反转
	 */
	public static void reversetLinkList(LinkList linkList){
		HeroNode head = linkList.getHead();
		//原始链表头结点
		HeroNode cur = linkList.getHead().getNext();
		//新链表的头结点
		HeroNode reversetHead = new HeroNode(0, "", "");
		//中间节点
		HeroNode next = null;
		//循环遍历使用头插法
		while(cur != null){
			next = cur.getNext();
			cur.setNext(reversetHead.getNext());
			reversetHead.setNext(cur);
			cur = next;
		}
		head.setNext(reversetHead.getNext());
		linkList.display();
	}
	
	/**
	 * 反转链表
	 * 思路：
	 *  通过栈实现，将链表元素压入栈中，然后再出栈
	 * 	借助栈先入后出的特性
	 */
	public static void reversePrint(LinkList linkList){
		Stack<HeroNode> stack = new Stack<>();
		HeroNode temp = linkList.getHead().getNext();
		//循环遍历使用头插法
		while(temp != null){
			stack.push(temp);
			temp = temp.getNext();
		}
		while(stack.size() > 0){
			System.out.println(stack.pop());
		}
	}
	
	/**
	 * 按照升序合并两个链表
	 * l1    3 -> 8 -> 12
	 * l2    1 -> 9 -> 10
	 */
	public static HeroNode mergeLinkListByOrder(HeroNode head1,HeroNode head2){
        if (head1.getNext() == null && head2.getNext() ==null){
            return null;
        }
        if (head1.getNext() == null){
            return head2;
        }
        if (head2.getNext() == null){
            return head1;
        }
        HeroNode head = null;
        if (head1.getNo() > head2.getNo()) {
            //把head较小的结点给头结点
            head = head2;
            //继续递归head2
            head.setNext(mergeLinkListByOrder(head1, head2.getNext()));
        } else {
            head = head1;
            head.setNext(mergeLinkListByOrder(head1.getNext(), head2));
        }
 
        return head;
    }
	
	public static HeroNode merge(HeroNode head1,HeroNode head2){
		 
        if(head1 == null && head2 == null){
            return null;
        }
         // head1与head2任一为null，则无需合并，直接返回另一个即可
        if(head1 == null){
            return  head2;
        }
 
        if(head2 == null){
            return head1;
        }
        HeroNode headNode = null;
        HeroNode last = null;
 
        if(head1.getNo() < head2.getNo()){
            headNode = head1;
            last = head1;
            head1 = head1.getNext();
        }else{
            headNode = head2;
            last = head2;
            head2 = head2.getNext();
        }
         // 如果head1的值小于head2的值，则新链表的尾节点的next为head1，并且head1指向其next
         // 否则为head2，并且head2指向其next
        while(head1!=null&&head2!=null){
            if(head1.getNo()<head2.getNo()){
                last.setNext(head1);
                last = head1;
                head1 = head1.getNext();
            }else{
                last.setNext(head2);
                last = head2;
                head2 = head2.getNext();
            }
         }
 
        if(head1 !=null ){
            last.setNext(head1);// 如果head1链表不为null，则直接放到合并链表的尾部
        }else {
            last.setNext(head2);// 如果head2链表不为null，则直接放到合并链表的尾部
        }
        // 因为合并链表的头节点是随意初始化的，所以真正合并后的链表头节点应该是当前头节点的next
        return  headNode.getNext();
	}
	
	
	
}

/**
 * 单向链表
 * @author advance
 *
 */
class LinkList{
	
	//头结点
	private HeroNode head = new HeroNode(0, "", "");
	
	public HeroNode getHead(){
		return this.head;
	}
	
	/**
	 * 插入节点
	 * @param node
	 */
	public void add(HeroNode node){
		HeroNode temp = head;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		temp.setNext(node);
	}
	
	/**
	 * 打印单链表
	 */
	public void display(){
		if(head.getNext() == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head;
		while(temp.getNext() != null){
			temp = temp.getNext();
			System.out.println(temp);
		}
	}
	
	/**
	 * 按序添加节点
	 */
	public void addByOrder(HeroNode node){
		HeroNode temp = head;
		boolean flag = false;
		while(temp.getNext() != null){
			//当前可以插入
			if(temp.getNext().getNo() > node.getNo()){
				break;
			} else 
				//说明希望添加的heroNode的编号已然存在
				if (temp.getNext().getNo() == node.getNo()) { 
				flag = true; //说明编号存在
				break;
			}
			temp = temp.getNext();
		}
		if(flag){			
			System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", node.getNo());
		}else{
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
	}
	
	/**
	 * 根据编号查找链表节点 
	 * @param no
	 * @return
	 */
	public HeroNode get(int no){
		HeroNode result = null;
		HeroNode temp = head;
		while(temp.getNext() != null){
			if(temp.getNext().getNo() == no){
				result = temp.getNext();
				break;
			}
			temp = temp.getNext();
		}
		if(result == null){
			throw new RuntimeException("编号为"+no+"的英雄的不存在");
		}
		return result;
	}
	
	/**
	 * 获取链表的倒数第K个元素
	 * @param k
	 * @return
	 */
	public HeroNode getLastKNode(int k){
		if(head.getNext() == null){
			return null;
		}
		int length = size();
		if(k <= 0  || k > length){
			return null;
		}
		HeroNode temp = head.getNext();
		for(int i = 0; i < length-k; i++){
			temp = temp.getNext();
		}
		return temp;
	}
	
	
	/**
	 * 修改单链表的节点元素
	 * 通过no进行判断是否为此节点
	 */
	public void update(HeroNode node){
		HeroNode temp = head;
		boolean flag = false;
		while(temp != null){
			if(temp.getNo() == node.getNo()){
				flag = true;
				break;
			}
			temp = temp.getNext();
		}
		if(flag){
			temp.setName(node.getName());
			temp.setNickName(node.getNickName());
		}else{
			System.out.printf("没有找到 编号 %d 的节点，不能修改\n", node.getNo());
		}
	}
	
	/**
	 * 删除单链表节点
	 * @param node
	 */
	public void remove(HeroNode node){
		HeroNode temp = head;
		boolean flag = false;
		while(temp.getNext() != null){
			if(temp.getNext().getNo() == node.getNo()){
				flag = true;
				break;
			}
			temp = temp.getNext();
		}
		if(flag){
			temp.setNext(temp.getNext().getNext());
		}else{
			System.out.printf("没有找到 编号 %d 的节点，不能修改\n", node.getNo());
		}
	}
	
	/**
	 * 计算链表大小
	 * @return
	 */
	public int size(){
		if(head.getNext() == null) {
			System.out.println("链表为空");
			return 0;
		}
		int size = 0;
		HeroNode temp = head;
		while(temp.getNext() != null){
			size ++;
			temp = temp.getNext();
		}
		return size;
	}
	
}

/**
 * 链表节点
 * @author advance
 *
 */
class HeroNode{
	
	//编号
	private int no;
	
	//姓名
	private String name;
	
	//昵称
	private String nickName;
	
	//下一节点地址
	private HeroNode next;
	
	public HeroNode(int no, String name, String nickName){
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getNickName() {
		return nickName;
	}

	public HeroNode getNext() {
		return next;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public void setNext(HeroNode heroNode) {
		this.next = heroNode;
	}
	
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
}
