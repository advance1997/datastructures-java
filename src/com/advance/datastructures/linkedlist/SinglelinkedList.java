package com.advance.datastructures.linkedlist;

import java.util.Stack;

/**
 * ������
 * @author advance
 *
 */
public class SinglelinkedList {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList linkList = new LinkList();
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(8, "¬����", "������");
		HeroNode hero3 = new HeroNode(4, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(15, "�ֳ�", "����ͷ");
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
//		HeroNode hero5 = new HeroNode(2, "¬����", "������up");
//		System.out.println("�����С=======>"+linkList.size());
//		linkList.update(hero5);
//		linkList.display();
//		linkList.remove(new HeroNode(1, "�ν�", "��ʱ��"));
//		System.out.println("�����С=======>"+linkList.size());
//		linkList.remove(new HeroNode(2, "¬����", "������up"));
//		System.out.println("�����С=======>"+linkList.size());
//		linkList.remove(new HeroNode(3, "����", "�Ƕ���"));
//		linkLi+st.remove(new HeroNode(4, "�ֳ�", "����ͷ"));
//		System.out.println("========ɾ��֮�������=========");
//		linkList.display();
//		int k = 1;
//		System.out.println("��������"+k+"λ�ڵ�Ϊ��"+linkList.getLastKNode(k));
//		reversetLinkList(linkList);
//		reversePrint(linkList);
		
		LinkList linkList1 = new LinkList();
		HeroNode hero5 = new HeroNode(9, "�ν�", "��ʱ��");
		HeroNode hero6 = new HeroNode(2, "¬����", "������");
		HeroNode hero7 = new HeroNode(5, "����", "�Ƕ���");
		HeroNode hero8 = new HeroNode(13, "�ֳ�", "����ͷ");
		linkList1.add(hero5);
		linkList1.add(hero6);
		linkList1.add(hero7);
		linkList1.add(hero8);
		linkList.display();
		linkList1.display();
		System.out.println("==========�ϲ���============");
		HeroNode temp = merge(linkList.getHead(), linkList1.getHead());
		while(temp.getNext() != null){
			System.out.println(temp.getNext());
			temp = temp.getNext();
		}
	}

	/**
	 * ��ת����
	 * ˼·��
	 * 	ʹ��ͷ�巨�����µ���ʱ����Ȼ���ӡ�µ���ʱ������ʵ������ת
	 */
	public static void reversetLinkList(LinkList linkList){
		HeroNode head = linkList.getHead();
		//ԭʼ����ͷ���
		HeroNode cur = linkList.getHead().getNext();
		//�������ͷ���
		HeroNode reversetHead = new HeroNode(0, "", "");
		//�м�ڵ�
		HeroNode next = null;
		//ѭ������ʹ��ͷ�巨
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
	 * ��ת����
	 * ˼·��
	 *  ͨ��ջʵ�֣�������Ԫ��ѹ��ջ�У�Ȼ���ٳ�ջ
	 * 	����ջ������������
	 */
	public static void reversePrint(LinkList linkList){
		Stack<HeroNode> stack = new Stack<>();
		HeroNode temp = linkList.getHead().getNext();
		//ѭ������ʹ��ͷ�巨
		while(temp != null){
			stack.push(temp);
			temp = temp.getNext();
		}
		while(stack.size() > 0){
			System.out.println(stack.pop());
		}
	}
	
	/**
	 * ��������ϲ���������
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
            //��head��С�Ľ���ͷ���
            head = head2;
            //�����ݹ�head2
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
         // head1��head2��һΪnull��������ϲ���ֱ�ӷ�����һ������
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
         // ���head1��ֵС��head2��ֵ�����������β�ڵ��nextΪhead1������head1ָ����next
         // ����Ϊhead2������head2ָ����next
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
            last.setNext(head1);// ���head1����Ϊnull����ֱ�ӷŵ��ϲ������β��
        }else {
            last.setNext(head2);// ���head2����Ϊnull����ֱ�ӷŵ��ϲ������β��
        }
        // ��Ϊ�ϲ������ͷ�ڵ��������ʼ���ģ����������ϲ��������ͷ�ڵ�Ӧ���ǵ�ǰͷ�ڵ��next
        return  headNode.getNext();
	}
	
	
	
}

/**
 * ��������
 * @author advance
 *
 */
class LinkList{
	
	//ͷ���
	private HeroNode head = new HeroNode(0, "", "");
	
	public HeroNode getHead(){
		return this.head;
	}
	
	/**
	 * ����ڵ�
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
	 * ��ӡ������
	 */
	public void display(){
		if(head.getNext() == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head;
		while(temp.getNext() != null){
			temp = temp.getNext();
			System.out.println(temp);
		}
	}
	
	/**
	 * ������ӽڵ�
	 */
	public void addByOrder(HeroNode node){
		HeroNode temp = head;
		boolean flag = false;
		while(temp.getNext() != null){
			//��ǰ���Բ���
			if(temp.getNext().getNo() > node.getNo()){
				break;
			} else 
				//˵��ϣ����ӵ�heroNode�ı����Ȼ����
				if (temp.getNext().getNo() == node.getNo()) { 
				flag = true; //˵����Ŵ���
				break;
			}
			temp = temp.getNext();
		}
		if(flag){			
			System.out.printf("׼�������Ӣ�۵ı�� %d �Ѿ�������, ���ܼ���\n", node.getNo());
		}else{
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
	}
	
	/**
	 * ���ݱ�Ų�������ڵ� 
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
			throw new RuntimeException("���Ϊ"+no+"��Ӣ�۵Ĳ�����");
		}
		return result;
	}
	
	/**
	 * ��ȡ����ĵ�����K��Ԫ��
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
	 * �޸ĵ�����Ľڵ�Ԫ��
	 * ͨ��no�����ж��Ƿ�Ϊ�˽ڵ�
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
			System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", node.getNo());
		}
	}
	
	/**
	 * ɾ��������ڵ�
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
			System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", node.getNo());
		}
	}
	
	/**
	 * ���������С
	 * @return
	 */
	public int size(){
		if(head.getNext() == null) {
			System.out.println("����Ϊ��");
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
 * ����ڵ�
 * @author advance
 *
 */
class HeroNode{
	
	//���
	private int no;
	
	//����
	private String name;
	
	//�ǳ�
	private String nickName;
	
	//��һ�ڵ��ַ
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
