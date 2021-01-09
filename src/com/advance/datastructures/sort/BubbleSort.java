package com.advance.datastructures.sort;

import java.util.Random;

/**
 * 冒泡排序法
 * 
 * 时间复杂度：O(n^2)
 * 
 * @author advance
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 80000;
//		int[] arrs = generatorArrs(n);
		int[] arrs = new int[]{1,2,3,4,5,6,7,8,9,10};
		long start = System.currentTimeMillis();
		bubbleSort(arrs);
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("冒泡排序对"+n+"个数值进行排序花费时间为："+time+"毫秒");
	}
	
	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(10);
		}
		return arrs;
	}
	
	/**
	 * 冒泡排序方法思路：
	 * 使用外层循环用于定义排序轮数，假如数据长度为n，轮数应该为n-1轮，因为最后一个数是不需要比较的
	 * 使用内层循环对比两两相邻的数字，如果后面的数比前面的数小，则将前面的数换到后面，一次替换，将最大的数冒泡至最后
	 * 由于每一轮之后都有一个大数字冒泡至最后，所以内层循环每一次只需要对比n-i-1轮，
	 * 因为前面几轮冒泡之后的数值不需要比较了，肯定是有序且是比前面数值大的
	 * 最后使用flag进行算法优化，如果在某一轮中，一次数据冒泡都没有发生，则表示已经排好序了，可直接退出
	 * @param arrs
	 */
	private static void bubbleSort(int[] arrs){
		//用于标识是否在该轮冒泡中是否有过数据冒泡
		boolean flag = false;
		for(int i = 0; i < arrs.length - 1; i++){
			for(int j = 0; j < arrs.length - i - 1; j++){
				if(arrs[j] > arrs[j+1]){
					//冒泡了就将flag置为true代表发生过冒泡
					flag = true;
					int temp = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = temp;
				}
			}
			if(!flag){
				//没有发生冒泡，循环终止，代表已经排好序了
				break;
			}else{
				//发生过冒泡则重置flag，使得flag在进入下一轮时都初始值正确
				flag = false;
			}
		}
	}
	
	private static void printArrs(int[] arrs){
		for(int i : arrs){
			System.out.print(i+"\t");
		}
	}

}
