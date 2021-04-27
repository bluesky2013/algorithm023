package mytest;

/**
 * Created by fuwenchao on 2021/1/14.
 * 将0都移动到末尾
 */
public class MoveZero {

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }

        }
        System.out.println(nums);
        for(int tmp =0 ; tmp<nums.length; tmp++){
            System.out.println(nums[tmp]);
        }
    }
}
