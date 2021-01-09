package com.advance.datastructures.sort;

import java.util.Random;

/**
 * ѡ������
 * 
 * 	ͨ��ѭ��ÿ���ҳ���Сֵ��Ȼ���¼��λ���ٷŻ�ǰ��
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
		System.out.println("ѡ�������"+n+"����ֵ�������򻨷�ʱ��Ϊ��"+time+"����");
	}
	
	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(10);
		}
		return arrs;
	}
	
	/**
	 * �������򷽷�
	 * 	�����趨һ����Сֵ��index
	 *  Ȼ��ʹ�����ѭ����������ȷ����ֵ
	 *  ��ѭ��ȷ����ǰλ�õ�ֵ����ѭ��ȷ����Сֵ
	 *  ִ������ѭ��֮���ٽ���Сֵ���ڵ�ǰ��ѭ����ֵ��
	 * @param arrs
	 */
	private static void selectSort(int[] arrs){
		int index = 0;
		int temp = 0;
		
		//��¼��ǰ���򵽵ڼ���
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
