package com.advance.datastructures.sort;

import java.util.Random;

/**
 * ��������
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
		System.out.println("���������"+n+"����ֵ�������򻨷�ʱ��Ϊ��"+time+"����");
	}

	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(10);
		}
		return arrs;
	}
	
	/**
	 * ��������
	 * ���ȴӵ�һ������ʼ��Ĭ��ǰ����һ�����������
	 * Ȼ�����δӵ�iλ����ǰ�Ա�
	 * �����λ������һλ��С���򽫴�λ������һλ���Ի�
	 * �ڼ�����ǰ�Ա�
	 * ֪����һλ���ȴ�λ��С���ߵ���������ǰ��ʱֹͣ
	 * ����ٽ�iλ�ϵ�����ڴ�λ�ü���
	 * @param arrs
	 */
	private static void insertSort(int[] arrs){
		int index;
		int temp;
		//�ӵڶ�λ����ʼ���Աȣ����ζԱȵ����һ����
		for(int i = 1; i < arrs.length; i++){
			temp = arrs[i];
			index = i;
			//������ǰ�Աȣ�����������
			while(index > 0 && temp < arrs[index - 1]){
				arrs[index] = arrs[index - 1];
				index--;
			}
			//������ֲ�û����ǰ������������Ҫ���¸�ֵ�������ǰ�ˣ�����Ҫ���¸�ֵ
			if(index != i){
				arrs[index] = temp;
			}
		}
	}
	
}
