package com.advance.leetcode.simple;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 思路：使用二分法
 * @author advance
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] arrs = {1};
        int target = 2;
        System.out.println(searchInsert(arrs, target));
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    private static int searchInsert(int[] nums, int target){
//        int right = nums.length - 1;
//        int left = 0;
//        while(){
//
//        }
    }

    private static int searchInsert1(int[] nums, int target){
        int index = 0;
        int j = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[j] > target){
                index = j;
                break;
            }else if(nums[j] < target && nums[i] >= target){
                index = i;
                break;
            }else if(nums[nums.length - 1] < target ){
                index = nums.length;
                break;
            }
            j++;
        }
        return index;
    }

}