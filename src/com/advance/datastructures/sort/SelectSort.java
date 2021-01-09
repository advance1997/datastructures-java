package com.advance.datastructures.sort;

import java.util.Random;

/**
 * 选择排序法
 * 
 * 	通过循环每次找出最小值，然后记录下位置再放回前面
 * @author advance
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 80000;
//		int[] arrs = generatorArrs(n);
		int[] arrs = new int[]{1,2,3,4,5,6,7,8,9,10};
		long start = System.currentTimeMillis();
		selectSort(arrs);
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("选择排序对"+n+"个数值进行排序花费时间为："+time+"毫秒");
	}
	
	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(10);
		}
		return arrs;
	}
	
	/**
	 * 快速排序方法
	 * 	首先设定一个最小值的index
	 *  然后使用外层循环依次升序确定数值
	 *  外循环确定当前位置的值，内循环确定最小值
	 *  执行外内循环之后再将最小值放在当前外循环的值上
	 * @param arrs
	 */
	private static void selectSort(int[] arrs){
		int index = 0;
		int temp = 0;
		
		//记录当前排序到第几轮
		for(int i = 0; i < arrs.length - 1; i++){
			index = i;
			for(int j = i + 1; j < arrs.length; j++){
				if(arrs[j] < arrs[index]){
					index = j;
				}
			}
			temp = arrs[i];
			arrs[i] = arrs[index];
			arrs[index] = temp;
		}
	}
	

}
