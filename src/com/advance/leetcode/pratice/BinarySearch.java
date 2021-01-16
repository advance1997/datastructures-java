package com.advance.leetcode.pratice;

/**
 * @program: DataStructures
 * @description: 算法练习之二分法
 *
 *   算法思路：
 *      二分法的算法核心在于不断地求中位值从而逐渐缩小范围
 *      在数组中确定两个边界值，定义为left和right，再根据left与right的值取出中位数mid，mid=(left+right)/2
 *      left、right以及mid都为数组的下标值
 *      left初始值为数组的第一个元素的下标值，right初始化为数组最后一个元素地址的下标值，mid需要动态求他的值
 *
 *      二分法适合处理有序数组，以中位数值为界限，左边认为是小的有序数组，右边为大的有序数组
 *      通过target与中位值做比较，不断循环缩小范围，最终确定位置
 *      如果target < mid的值，则将left以及mid-1区间做为下一段搜寻区域
 *      如果target > mid的值，则将mid+1以及区间做为下一段搜寻区域
 *      如果target = mid的值，则mid减一就是插入位置
 *
 * @author: zhouh
 * @create: 2021-01-10 16:01
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 3, 58, 100, 200, 400, 567, 340};
        int target = 200;
        System.out.println(binarySearch(nums, target));
    }

    private static int binarySearch(int[] nums, int target){
        //定义一个左边界值
        int left = 0;
        //定义一个右边界值
        int right = nums.length - 1;
        //定义一个初始化mid值，在循环过程中不断变化
        int mid;
        //左边边界必须小于等于右边的边界，有等于号是为了最后一次确定位置
        while(left <= right){
            //开始循环并不断地变换left，right，mid的值
            mid = (left + right) / 2;
            //如果发现mid值等于目标值，则为找到了
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }

            if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

}
