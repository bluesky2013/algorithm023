package mytest;

import java.util.Stack;

/**
 * Created by fuwenchao on 2021/5/8.
 *
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 */
public class LargeRectangleArea {
    /**
     * 暴力破解1： 枚举 宽 的做法
     * 问题：内循环j 应该从几开始，
     * 疏忽的地方：将int min = Integer.MAX_VALUE; 写到了两个循环外面了
     *这个暴力破解的方式，虽然可以得到正确结果，但是在leetcode上面提交的时候，超时了。
     *
     * 从中可以学习到：内循环遍历的时候，可以边遍历就能得到最小值，而不需要再增加第三个训练来找到i到j之间的最小值。
     *
     * ：
     * @param heights
     * @return
     */
    public int largestRectangleArea_1(int[] heights) {
        int rs = 0;

        for(int i=0; i<heights.length; i++){
            if(i==1){
                System.out.println();
            }
            int min = Integer.MAX_VALUE;
            for(int j=i; j<heights.length; j++){
                min = Math.min(min, heights[j]);
                int area = min*(j-i+1);
                rs = Math.max(area, rs);
            }
        }
        return rs;
    }

    /**
     * 暴力破解2：枚举 高 的做法
     * @param heights
     * @return
     */
    public int largeRectangleArea_2(int[] heights){
        int rs = 0;
        for(int i=0; i<heights.length; i++){
            int j = i;
            while(j>=0){
                if(heights[j]<heights[i]){
                    break;
                }
                j--;
            }
            int k = i;
            while(k<heights.length){
                if(heights[k]<heights[i]){
                    break;
                }
                k++;
            }

            int area = heights[i]*(k-j-1);
            rs = Math.max(area, rs);

        }
        return rs;

    }

    /**
     *
     *问题：1.没有考虑相邻元素相等的情况，
     * @param heights
     * @return
     */
    public int largeRectangleArea_3(int[] heights){
        int rs = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        for(int i=0; i<heights.length; i++){

            if(st.peek() == -1 || heights[i]>=heights[st.peek()] ){
                st.push(i);
            }else{
                while(st.peek()!=-1 && heights[st.peek()]>=heights[i]){
                    int tmp = st.pop();
                    int right = i-1;
                    int left = st.peek()+1;
                    int area = heights[tmp] * (right-left+1);
                    rs = Math.max(area, rs);
                }
                st.push(i);

            }


        }
        int right = heights.length-1;
        while(st.size()>1){
            int tmp = st.pop();
            int left = st.peek()+1;
            int area = heights[tmp] * (right-left+1);
            rs = Math.max(area, rs);
//            right = tmp;
        }
        return rs;

    }

    public static void main(String[] args) {
//        int[] nums = {2, 1, 5,6,2,3};
//        int[] nums = {999,999,999,999};
//        int[] nums = {};
//        int[] nums = {1,8,6,2,5,4,8,3,7};
//        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] nums = {4,2,0,3,2,5};
        System.out.println(new LargeRectangleArea().largestRectangleArea_1(nums));
        System.out.println(new LargeRectangleArea().largeRectangleArea_2(nums));
        System.out.println(new LargeRectangleArea().largeRectangleArea_3(nums));

    }
}
