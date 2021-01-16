package com.advance.leetcode.pratice;

/**
 * @program: DataStructures
 * @description: �㷨��ϰ֮���ַ�
 *
 *   �㷨˼·��
 *      ���ַ����㷨�������ڲ��ϵ�����λֵ�Ӷ�����С��Χ
 *      ��������ȷ�������߽�ֵ������Ϊleft��right���ٸ���left��right��ֵȡ����λ��mid��mid=(left+right)/2
 *      left��right�Լ�mid��Ϊ������±�ֵ
 *      left��ʼֵΪ����ĵ�һ��Ԫ�ص��±�ֵ��right��ʼ��Ϊ�������һ��Ԫ�ص�ַ���±�ֵ��mid��Ҫ��̬������ֵ
 *
 *      ���ַ��ʺϴ����������飬����λ��ֵΪ���ޣ������Ϊ��С���������飬�ұ�Ϊ�����������
 *      ͨ��target����λֵ���Ƚϣ�����ѭ����С��Χ������ȷ��λ��
 *      ���target < mid��ֵ����left�Լ�mid-1������Ϊ��һ����Ѱ����
 *      ���target > mid��ֵ����mid+1�Լ�������Ϊ��һ����Ѱ����
 *      ���target = mid��ֵ����mid��һ���ǲ���λ��
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
        //����һ����߽�ֵ
        int left = 0;
        //����һ���ұ߽�ֵ
        int right = nums.length - 1;
        //����һ����ʼ��midֵ����ѭ�������в��ϱ仯
        int mid;
        //��߽߱����С�ڵ����ұߵı߽磬�е��ں���Ϊ�����һ��ȷ��λ��
        while(left <= right){
            //��ʼѭ�������ϵر任left��right��mid��ֵ
            mid = (left + right) / 2;
            //�������midֵ����Ŀ��ֵ����Ϊ�ҵ���
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
