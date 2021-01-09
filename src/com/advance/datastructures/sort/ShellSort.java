package com.advance.datastructures.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * ϣ������
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
		System.out.println("ϣ�������"+n+"����ֵ�������򻨷�ʱ��Ϊ��"+time+"����");
	}

	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(100000);
		}
		return arrs;
	}
	
	/**
	 * ����ʽshell����
	 * Ч�ʸߣ��������Ϊ���β�������
	 * @param arrs
	 */
	public static void shellSortChange(int[] arrs){
		int temp = 0;
		int length = arrs.length;
		//���η������������shell�����˼�룬��������
		for(int gap = length / 2; gap > 0; gap /= 2){
			//�����ڵ�ÿһ���ѭ��
			for(int i = gap; i < arrs.length; i++){
				//ÿһ���ڵ�Ԫ�ضԱ�
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
	 * �ƶ�ʽshell����
	 * Ч�ʵͣ��������Ϊ����ð������
	 * @param arrs
	 */
	public static void shellSortMove(int[] arrs){
		int temp = 0;
		int length = arrs.length;
		int index = 0;
		//���η������������shell�����˼�룬��������
		for(int gap = length / 2; gap > 0; gap /= 2){
			//�����ڵ�ÿһ���ѭ��
			for(int i = gap; i < arrs.length; i++){
				temp = arrs[i];
				index = i - gap;
				//ÿһ���ڵ�Ԫ�ضԱ�,���ò��������˼�룬��¼λ�����ضԱ�
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
