package hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1.为空则返回
        if(strs==null || strs.length==0 ){
            return new ArrayList<>();
        }

        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            //转为字符串
            String key = new String(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
//        for(List<String> list:map.values()){
//            res.add(list);
//        }
        List<List<String>> res = map.
                values().
                stream().
                collect(Collectors.toList());
        return res;
    }
    public static void main(String[] args) {
         String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
         Anagrams anagrams = new Anagrams();
        List<List<String>> lists = anagrams.groupAnagrams(strs);
        for(List<String> list:lists){
            System.out.println(list);
        }

    }
}
