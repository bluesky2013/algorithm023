package mytest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断是否是合法的括号
 * 用栈
 * Created by fuwenchao on 2021/5/7.
 * 没有考虑到的情况： 1."[";  2.执行peek前，没有判断栈不为空
 */
public class IsValidBracket {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
//      stack变量怎么命名呢？有什么规范.  官方命名是pairs
        Stack<Character> st = new Stack<Character>();
        char[] cs = s.toCharArray();
        for(Character c : cs){
            if(map.containsKey(c)){
                if(st.size()>0 && st.peek()==map.get(c)){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(c);
            }
        }
        if(st.size()==0){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
//        通常的string变量怎么命名?
        String str = "()";
        str = "()[]{}";
        str = "(]";
        str = "[";
        System.out.println(new IsValidBracket().isValid(str));
    }
}
