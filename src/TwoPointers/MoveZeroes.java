package TwoPointers;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes1(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }


    public int[] moveZeroes(int[] nums){
        int left = 0;
        int right = left+1;

        while(right<=nums.length-1){
            //左边等于0右边不等于0才交换位置
            if(nums[left]==0&&nums[right]!=0){
                nums[left] = nums[right];
                nums[right] = 0;

            }
            if(nums[left]==0&&nums[right]==0){
                right++;
                continue;
            }

            left++;
            right++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,4,0,6};
        MoveZeroes mz = new MoveZeroes();
        nums =  mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
