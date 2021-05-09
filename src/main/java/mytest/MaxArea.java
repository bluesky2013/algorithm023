package mytest;

/**
 * 11. 盛最多水的容器
 * 双指针法的原理：一句话解释就是说矮柱子选取后如果移动高柱子的话面积是一定会减小的，
 * 因为长度距离在变小的时候，此时高度只能小于或等于矮的柱子。因此只能移动矮的柱子这边才有可能使得高度比矮柱子大
 */
public class MaxArea {
    public int maxArea(int[] heights){
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        while(left < right){
            int area = Math.min( heights[left], heights[right] ) * ( right - left );
            maxArea = Math.max(area, maxArea);
//            这块没有想的很明白，可能会容易忘记。为什么那边小，那边就往中间走呢？
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
