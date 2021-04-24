package my_test;

/**
 * 11. 盛最多水的容器
 * 双指针:
 */
public class MaxArea {
    public int maxArea(int[] heights){
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        while(left < right){
            int area = Math.min(heights[left], heights[right])*(right - left);
            maxArea = Math.max(area, maxArea);
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
