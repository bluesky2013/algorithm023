package mytest.gungualanshu;

/**
 * Created by fuwenchao on 2021/3/2.
 * 将文本数字转换为数字
 * 考虑的情况比较多
 */
public class Atoi {

    public int myAtoi(String str){
        int index = 0, sign = 1, total = 0;
        if(str == null || str.length() == 0){
            return 0;
        }
        while(str.charAt(index) == ' '  && index<str.length()){
            index++;
        }

        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+'?1:-1;
            index++;
        }
        while(index<str.length()){
            int digit = str.charAt(index) - '0';
            if(digit<0 || digit>9){
                break;
            }
            if(Integer.MAX_VALUE/10<total ||
                    Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10<digit){
                return sign == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            total = total*10+digit;
            index++;
        }
        return total*sign;
    }

    public static void main(String[] args) {
        System.out.println(new Atoi().myAtoi("-123"));
    }


}
