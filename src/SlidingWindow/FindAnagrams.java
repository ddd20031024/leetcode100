package SlidingWindow;

import java.util.*;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int sL = s.length(),pL=p.length();
        if(sL<pL){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        //先存前三个
        for(int i=0;i<pL;i++){
           ++sCount[s.charAt(i)-'a'];
           ++pCount[p.charAt(i)-'a'];
        }
        if(Arrays.equals(sCount,pCount)){
            ans.add(0);
        }
        for(int i=0;i<sL-pL;i++){
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+pL) -'a']++;
            if(Arrays.equals(sCount,pCount)){
                //移除的上一轮的，这一轮的起始位置需要加1
                ans.add(i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       String  s = "cbaebabacd";
       String p = "abc";
       FindAnagrams findAnagrams = new FindAnagrams();
       List<Integer> ans = findAnagrams.findAnagrams(s, p);
       System.out.println(ans);
    }
}
