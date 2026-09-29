package substring;

import java.util.HashMap;
import java.util.Map;

public class KSum {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int pre=0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int n:nums){
            pre+=n;
            if(mp.containsKey(pre-k)){
                count+=mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }

        return  count;
    }
    public static void main(String[] args) {
        KSum kSum = new KSum();
        int[] nums = {1,1,1};
        int count = kSum.subarraySum(nums, 2);
        System.out.println(count);
    }
}
