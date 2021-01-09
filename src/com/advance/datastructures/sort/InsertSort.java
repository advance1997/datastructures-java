package com.advance.datastructures.sort;

import java.util.Random;

/**
 * 插入排序
 * @author advance
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 80000;
//		int[] arrs = generatorArrs(n);
		int[] arrs = new int[]{1,2,3,4,5,6,7,8,9,10};
		long start = System.currentTimeMillis();
		insertSort(arrs);
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("插入排序对"+n+"个数值进行排序花费时间为："+time+"毫秒");
	}

	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(10);
		}
		return arrs;
	}
	
	/**
	 * 插入排序
	 * 首先从第一个数开始，默认前面是一个有序的数组
	 * 然后依次从第i位数往前对比
	 * 如果此位数比上一位数小，则将此位数与上一位数对换
	 * 在继续往前对比
	 * 知道上一位数比此位数小或者到了数组最前面时停止
	 * 最后再将i位上的书放在此位置即可
	 * @param arrs
	 */
	private static void insertSort(int[] arrs){
		int index;
		int temp;
		//从第二位数开始作对比，依次对比到最后一个数
		for(int i = 1; i < arrs.length; i++){
			temp = arrs[i];
			index = i;
			//依次往前对比，并交换数据
			while(index > 0 && temp < arrs[index - 1]){
				arrs[index] = arrs[index - 1];
				index--;
			}
			//如果发现并没有往前做交换，则不需要重新赋值，如果往前了，则需要重新赋值
			if(index != i){
				arrs[index] = temp;
			}
		}
	}
	
}
