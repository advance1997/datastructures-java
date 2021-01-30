package com.advance.datastructures.sort;

import java.util.Random;

/**
 * @program: DataStructures
 * @description: 堆排序
 * @author: zhouh
 * @create: 2021-01-18 10:03
 **/
public class HeapSort {

    /**
     * @author: gethin
     * @create: 2018-05-23 16:21
     * @description: 常用排序算法
     **/
    public static void main(String[] args) {
        int n = 100000000;
//        int[] nums = {16,7,3,20,17,8};
        int[] nums = generatorArrs(n);
        long start = System.currentTimeMillis();
        headSort(nums);
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("堆排序对"+n+"个数值进行排序花费时间为："+time+"毫秒");
    }

    private static int[] generatorArrs(int n){
        int[] arrs = new int[n];
        for(int i = 0; i < n; i++){
            arrs[i] = new Random().nextInt(10);
        }
        return arrs;
    }

    /**
     * 堆排序
     */
    public static void headSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            headAdjust(list, list.length, i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAdjust(list, i, 0);
        }
    }

    private static void headAdjust(int[] list, int len, int i) {
        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            if (index + 1 < len) {
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            if (list[index] > temp) {
                list[k] = list[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        list[k] = temp;
    }

}
