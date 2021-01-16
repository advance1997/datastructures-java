package com.advance.datastructures.sort;

import java.util.Random;

/**
 * ϣ������
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
		System.out.println("ϣ�������"+n+"����ֵ�������򻨷�ʱ��Ϊ��"+time+"����");
	}

	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(100000000);
		}
		return arrs;
	}

	/**
	 * ����ʽshell����
	 * Ч�ʵͣ��������Ϊ����ð������
	 * @param arrs
	 */
	public static void shellSortChange(int[] arrs){
		int temp;
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
	 * Ч�ʸߣ��������Ϊ���β�������
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

}
