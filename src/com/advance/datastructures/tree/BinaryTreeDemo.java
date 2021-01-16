package com.advance.datastructures.tree;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: DataStructures
 * @description: 二叉树示例
 * @author: zhouh
 * @create: 2021-01-12 09:32
 **/
public class BinaryTreeDemo {
}

/**
 * 二叉树
 */
class BinaryTree{
    private Node root;

    public void setRoot(Node root){
        this.root = root;
    }

}

/**
 * 树节点
 */
@Data
@NoArgsConstructor
class Node{
    /**
     * 编号
     */
    private int no;
    /**
     * 名字
     */
    private String name;
    /**
     * 左子节点
     */
    private Node left;
    /**
     * 右子节点
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
     * 前序遍历
     * 1、先输出本结点
     * 2、左节点存在的话再输出左节点
     * 3、右节点存在的话最后输出右节点
     */
    public void preOrder(){
        //先输出本结点信息
        System.out.println(this);
        //左节点不为空，递归打印左节点
        if(this.left != null){
            this.left.preOrder();
        }
        //右节点不为空，递归打印右节点
        if(this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     * 1、左节点存在的话先输出左节点
     * 2、再输出本结点
     * 3、右节点存在的话最后输出右节点
     */
    public void midOrder(){
        //左节点不为空，先递归打印左节点
        if(this.left != null){
            this.left.midOrder();
        }
        //再输出本结点信息
        System.out.println(this);
        //右节点不为空，递归打印右节点
        if(this.right != null){
            this.right.midOrder();
        }
    }

    /**
     * 后序遍历
     * 1、左节点存在的话先输出左节点
     * 2、右节点存在的话再输出右节点
     * 3、最后输出本结点
     */
    public void postOrder(){
        //左节点不为空，先递归打印左节点
        if(this.left != null){
            this.left.postOrder();
        }
        //右节点不为空，再递归打印右节点
        if(this.right != null){
            this.right.postOrder();
        }
        //最后输出本结点信息
        System.out.println(this);
    }

}