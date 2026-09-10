package hashmap;


import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public  int[] twoSum(int[] nums ,int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int another = target - nums[i];
            if(hashMap.containsKey(another)){
                return new int[]{hashMap.get(another),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{};
    }
    //静态方法不可以调用非静态方法
    public static void main(String[] args) {
         int[] nums = {2,4,7,0};
        TwoSum twoSum = new TwoSum();
        int[] indexs = twoSum.twoSum(nums,9);
        for(int index:indexs){
            System.out.print(index+" ");
        }
    }

}
