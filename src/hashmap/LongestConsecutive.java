package hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Set<Integer> nums_set = new HashSet<Integer>();
        for(int num:nums){
            nums_set.add(num);
        }
        int LongestStreak=1;
        for(int num:nums_set){
            int currentStreak=1;

            if(nums_set.contains(num-1)){
                continue;
            }
            while(nums_set.contains(num+1)){
                num+=1;
                currentStreak+=1;
            }
            LongestStreak = Math.max(LongestStreak,currentStreak);
        }
        return LongestStreak;
    }

    public static void main(String[] args) {

    }
}
