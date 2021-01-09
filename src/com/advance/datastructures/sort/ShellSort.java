package com.advance.datastructures.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 希尔排序
 * @author advance
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000;
//		int[] arrs = generatorArrs(n);
		int[] arrs = new int[]{8,9,1,7,2,3,5,4,6,0};
		long start = System.currentTimeMillis();
//		shellSortStep1(arrs);
//		shellSortStep2(arrs);
//		shellSortStep3(arrs);
		shellSortMove(arrs);
		System.out.println(Arrays.toString(arrs));
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("希尔排序对"+n+"个数值进行排序花费时间为："+time+"毫秒");
	}

	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(100000);
		}
		return arrs;
	}
	
	/**
	 * 交换式shell排序
	 * 效率高，可以理解为分治插入排序
	 * @param arrs
	 */
	public static void shellSortChange(int[] arrs){
		int temp = 0;
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
	 * 效率低，可以理解为分治冒泡排序
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
	
	public static void shellSortStep1(int[] arrs){
		int temp;
		for(int i = 5; i < arrs.length ; i++){
			for(int j = i - 5; j >= 0; j-=5 ){
				if(arrs[j] > arrs[j+5]){
					temp = arrs[j];
					arrs[j] = arrs[j+5];
					arrs[j+5] = temp;
				}
			}
		}
	}
	
	public static void shellSortStep2(int[] arrs){
		int temp;
		for(int i = 2; i < arrs.length ; i++){
			for(int j = i - 2; j >= 0; j-= 2 ){
				if(arrs[j] > arrs[j+2]){
					temp = arrs[j];
					arrs[j] = arrs[j+2];
					arrs[j+2] = temp;
				}
			}
		}
	}
	
	public static void shellSortStep3(int[] arrs){
		int temp;
		for(int i = 1; i < arrs.length ; i++){
			for(int j = i - 1; j >= 0; j-= 1 ){
				if(arrs[j] > arrs[j+1]){
					temp = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = temp;
				}
			}
		}
	}
	
	public static void shellSort(int[] arr) {
	    int length = arr.length;
	    int temp;
	    for (int step = length / 2; step >= 1; step /= 2) {
	        for (int i = step; i < length; i++) {
	            temp = arr[i];
	            int j = i - step;
	            while (j >= 0 && arr[j] > temp) {
	                arr[j + step] = arr[j];
	                j -= step;
	            }
	            arr[j + step] = temp;
	        }
	    }
	}

}
