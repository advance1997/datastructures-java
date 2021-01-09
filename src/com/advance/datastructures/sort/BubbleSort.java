package com.advance.datastructures.sort;

import java.util.Random;

/**
 * ð������
 * 
 * ʱ�临�Ӷȣ�O(n^2)
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
		System.out.println("ð�������"+n+"����ֵ�������򻨷�ʱ��Ϊ��"+time+"����");
	}
	
	private static int[] generatorArrs(int n){
		int[] arrs = new int[n];
		for(int i = 0; i < n; i++){
			arrs[i] = new Random().nextInt(10);
		}
		return arrs;
	}
	
	/**
	 * ð�����򷽷�˼·��
	 * ʹ�����ѭ�����ڶ��������������������ݳ���Ϊn������Ӧ��Ϊn-1�֣���Ϊ���һ�����ǲ���Ҫ�Ƚϵ�
	 * ʹ���ڲ�ѭ���Ա��������ڵ����֣�������������ǰ�����С����ǰ������������棬һ���滻����������ð�������
	 * ����ÿһ��֮����һ��������ð������������ڲ�ѭ��ÿһ��ֻ��Ҫ�Ա�n-i-1�֣�
	 * ��Ϊǰ�漸��ð��֮�����ֵ����Ҫ�Ƚ��ˣ��϶����������Ǳ�ǰ����ֵ���
	 * ���ʹ��flag�����㷨�Ż��������ĳһ���У�һ������ð�ݶ�û�з��������ʾ�Ѿ��ź����ˣ���ֱ���˳�
	 * @param arrs
	 */
	private static void bubbleSort(int[] arrs){
		//���ڱ�ʶ�Ƿ��ڸ���ð�����Ƿ��й�����ð��
		boolean flag = false;
		for(int i = 0; i < arrs.length - 1; i++){
			for(int j = 0; j < arrs.length - i - 1; j++){
				if(arrs[j] > arrs[j+1]){
					//ð���˾ͽ�flag��Ϊtrue��������ð��
					flag = true;
					int temp = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = temp;
				}
			}
			if(!flag){
				//û�з���ð�ݣ�ѭ����ֹ�������Ѿ��ź�����
				break;
			}else{
				//������ð��������flag��ʹ��flag�ڽ�����һ��ʱ����ʼֵ��ȷ
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
