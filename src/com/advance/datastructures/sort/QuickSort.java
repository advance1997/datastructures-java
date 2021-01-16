package com.advance.datastructures.sort;

import java.util.Arrays;

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
        int[] arrs = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        quickSort(arrs, 0, arrs.length - 1);
        System.out.println(Arrays.toString(arrs));
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
