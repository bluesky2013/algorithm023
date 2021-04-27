package mytest.gungualanshu;

/**
 * Created by fuwenchao on 2021/3/5.
 * 以下代码需要写的非常熟练
 */
public class Demo1 {


    //字符串翻转
    public static void reverseString(char[] s){
        if(s == null || s.length==0){
            return ;
        }
        for(int i = 0, j = s.length-1; i<j; i++, j--){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

    //嵌套遍历数字,注意下标 边界值，常用于遍历字符串的所有子串等情况
    public static void traverseArray(int[] nums){

        for(int i = 0; i<nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){

            }
        }
    }

    public static void main(String[] args) {
        String str = "i love you";
        char[] s = str.toCharArray();
        reverseString(s);
        System.out.println(s);
    }

}
