package Week_02.有效的字母异位词;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IsAnagram {


    private static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c)+1);
            }else{
                charMap.put(c, 1);
            }
        }

        for(char c : t.toCharArray()){
            if(!charMap.containsKey(c)){
                return false;
            }else{
                charMap.put(c, charMap.get(c)-1);
            }
        }
        Iterator it = charMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>)it.next();
            if(entry.getValue()!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";
        str1 = "rat";
        str2 = "car";
        str1 = "aacc";
        str2 = "ccac";
        System.out.println(isAnagram(str1, str2));
    }
}
