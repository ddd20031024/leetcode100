package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //滑动窗口
        Set<Character> window = new HashSet<>();
        int maxLength=0;
        int r=-1; //右指针初始为-1
        for(int i=0;i<n;i++){
            if(i!=0){
                //左指针移动，去掉第一个
                window.remove(s.charAt(i-1));
            }
            while(r+1<n&&!window.contains(s.charAt(r+1))){
                window.add(s.charAt(r+1));
                r++;
            }
            maxLength=Math.max(maxLength,r-i+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int maxLength = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.println(maxLength);
    }
}
