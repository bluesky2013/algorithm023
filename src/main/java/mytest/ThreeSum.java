package mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fuwenchao on 2021/5/22.
 * 15. 三数之和
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum

 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0){
            return rs;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
//            如果两个连续的数相等，就continue，以过滤掉重复的结果。必须保证第一个是参与计算，而不是相同的第二个，也就是用nums[i]==nums[i-1] 而不是 nums[i]==nums[i+1]
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
//                这里也是必须保证第一个是参与计算，而不是相同的第二个，也就是用nums[j]==nums[j-1] 而不是 nums[j]==nums[j+1]
                if(j>(i+1) && nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
//                这里是一个剪枝的操作，由于数组进行了排序，所以如果nums[j] >-nums[i]，后续就没有正确的结果了，否则三数之和都是大于0的。
//                这里不能有等号，以应对[0, 0, 0]这种case
                if(nums[j] >-nums[i]){
                    break;
                }


                if(nums[i]+nums[j]+nums[k] >0 ) {
                    k--;
                }else if(nums[i]+nums[j]+nums[k] <0 ) {
                    j++;
                }
                else{
                        List<Integer> oneRs = new ArrayList<Integer>();
                        oneRs.add(nums[i]);
                        oneRs.add(nums[j]);
                        oneRs.add(nums[k]);
                        rs.add(oneRs);
                        j++;
                        k--;
                    }
                }

            }
        return rs;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {};
//        int[] nums = {0};
//        int[] nums = {0, 0, 0};
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> rs = new ThreeSum().threeSum(nums);
        if(rs == null || rs.size() == 0){
            return;
        }
        for(List<Integer> oneRs : rs){
            for(Integer element : oneRs){
                System.out.println(element);
            }
            System.out.println("------------------------");
        }
    }
}
