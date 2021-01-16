package com.advance.datastructures.tree;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: DataStructures
 * @description: ������ʾ��
 * @author: zhouh
 * @create: 2021-01-12 09:32
 **/
public class BinaryTreeDemo {
}

/**
 * ������
 */
class BinaryTree{
    private Node root;

    public void setRoot(Node root){
        this.root = root;
    }

}

/**
 * ���ڵ�
 */
@Data
@NoArgsConstructor
class Node{
    /**
     * ���
     */
    private int no;
    /**
     * ����
     */
    private String name;
    /**
     * ���ӽڵ�
     */
    private Node left;
    /**
     * ���ӽڵ�
     */
    private Node right;

    @Override
    public String toString(){
        return "TreeNode [no=" + no + ", name=" + name + "]";
    }

    public Node(int no, String name){
        this.no = no;
        this.name = name;
    }

    public void delNode(int no){
        if(this.no == no){

        }
    }

    /**
     * ǰ�����
     * 1������������
     * 2����ڵ���ڵĻ��������ڵ�
     * 3���ҽڵ���ڵĻ��������ҽڵ�
     */
    public void preOrder(){
        //������������Ϣ
        System.out.println(this);
        //��ڵ㲻Ϊ�գ��ݹ��ӡ��ڵ�
        if(this.left != null){
            this.left.preOrder();
        }
        //�ҽڵ㲻Ϊ�գ��ݹ��ӡ�ҽڵ�
        if(this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * �������
     * 1����ڵ���ڵĻ��������ڵ�
     * 2������������
     * 3���ҽڵ���ڵĻ��������ҽڵ�
     */
    public void midOrder(){
        //��ڵ㲻Ϊ�գ��ȵݹ��ӡ��ڵ�
        if(this.left != null){
            this.left.midOrder();
        }
        //������������Ϣ
        System.out.println(this);
        //�ҽڵ㲻Ϊ�գ��ݹ��ӡ�ҽڵ�
        if(this.right != null){
            this.right.midOrder();
        }
    }

    /**
     * �������
     * 1����ڵ���ڵĻ��������ڵ�
     * 2���ҽڵ���ڵĻ�������ҽڵ�
     * 3�������������
     */
    public void postOrder(){
        //��ڵ㲻Ϊ�գ��ȵݹ��ӡ��ڵ�
        if(this.left != null){
            this.left.postOrder();
        }
        //�ҽڵ㲻Ϊ�գ��ٵݹ��ӡ�ҽڵ�
        if(this.right != null){
            this.right.postOrder();
        }
        //�������������Ϣ
        System.out.println(this);
    }

}