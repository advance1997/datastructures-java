package com.advance.datastructures.sort;

import java.util.Random;

/**
 * 希尔排序
 * @author advance
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10000000;
		int[] arrs = generatorArrs(n);
		long start = System.currentTimeMillis();
		shellSortMove(arrs);
		System.out.println(arrs[100]);
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("希尔排序对"+n+"个数值进行排序花费时间为："+time+"毫秒");
	}

	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(100000000);
		}
		return arrs;
	}

	/**
	 * 交换式shell排序
	 * 效率低，可以理解为分治冒泡排序
	 * @param arrs
	 */
	public static void shellSortChange(int[] arrs){
		int temp;
		int length = arrs.length;
		//分治分组情况，符合shell排序的思想，增量缩减
		for(int gap = length / 2; gap > 0; gap /= 2){
			//分治内的每一组的循环
			for(int i = gap; i < arrs.length; i++){
				//每一组内的元素对比
				for(int j = i - gap; j >= 0; j -= gap){
					if(arrs[j] > arrs[j + gap]){
						temp = arrs[j];
						arrs[j] = arrs[j + gap];
						arrs[j + gap] = temp;
					}
				}
			}
		}
	}
	
	/**
	 * 移动式shell排序
	 * 效率高，可以理解为分治插入排序
	 * @param arrs
	 */
	public static void shellSortMove(int[] arrs){
		int temp = 0;
		int length = arrs.length;
		int index = 0;
		//分治分组情况，符合shell排序的思想，增量缩减
		for(int gap = length / 2; gap > 0; gap /= 2){
			//分治内的每一组的循环
			for(int i = gap; i < arrs.length; i++){
				temp = arrs[i];
				index = i - gap;
				//每一组内的元素对比,借用插入排序的思想，记录位置往回对比
				while(index >= 0 && temp < arrs[index]){
					arrs[index + gap] = arrs[index];
					index -= gap;
				}
				arrs[index+gap] = temp;
			}
		}
	}

}
