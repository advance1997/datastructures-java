package com.advance.datastructures.sort;

import java.util.Random;

/**
 * @program: DataStructures
 * @description: ��������
 * ��������ʹ�÷��η���Divide and conquer����������һ�����У�list����Ϊ�����Ӵ��У�sub-lists����
 *
 * ������������һ�ֶַ���֮˼���������㷨�ϵĵ���Ӧ�á���������������������Ӧ��������ð����������ϵĵݹ���η���
 *
 * �����������������Ǽ򵥴ֱ�����Ϊһ��������������֪�������ڵ����壬���ǿ죬����Ч�ʸߣ����Ǵ�����������������㷨֮һ�ˡ�
 *  �㷨����:
 *  1��������������һ��Ԫ�أ���Ϊ "��׼"��pivot��;
 *
 * 2�������������У�����Ԫ�رȻ�׼ֵС�İڷ��ڻ�׼ǰ�棬����Ԫ�رȻ�׼ֵ��İ��ڻ�׼�ĺ��棨��ͬ�������Ե���һ�ߣ�������������˳�֮�󣬸û�׼�ʹ������е��м�λ�á������Ϊ������partition��������
 *
 *:3���ݹ�أ�recursive����С�ڻ�׼ֵԪ�ص������кʹ��ڻ�׼ֵԪ�ص�����������
 * @author: advance
 * @create: 2021-01-11 09:56
 **/
public class QuickSort {

    public static void main(String[] args) {
        int n = 100000;
//        int[] nums = {16,7,3,20,17,8};
        int[] nums = generatorArrs(n);
        long start = System.currentTimeMillis();
        quickSort(nums, 0, n - 1);
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

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // �趨��׼ֵ��pivot��
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
