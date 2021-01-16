package com.advance.datastructures.sort;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 快速排序
 * 快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 *
 * 快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。
 *
 * 快速排序的名字起的是简单粗暴，因为一听到这个名字你就知道它存在的意义，就是快，而且效率高！它是处理大数据最快的排序算法之一了。
 *  算法步骤:
 *  1：从数列中挑出一个元素，称为 "基准"（pivot）;
 *
 * 2：重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 *
 *:3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
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
        // 设定基准值（pivot）
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
