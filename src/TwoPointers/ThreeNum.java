package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums) ;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int first=0;first<n;first++){
            //1.不能和之前重复
            if(first!=0&&nums[first]==nums[first-1]){
                continue;
            }
            int right = n-1;
            int target = -nums[first];
            for(int second=first+1;second<n;second++){
                //不允许重复
                if(second>first+1&&nums[second]==nums[second-1]){
                  continue;
                }
                //right指针在second指针右边
                while(second<right&&nums[second]+nums[right]>target){
                    right--;
                }
                //second 和right 重合，再没元素满足a+b+c=0;
                if(second==right){
                    break;
                }
                if(nums[second]+nums[right]==target){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[first]);
                    l.add(nums[second]);
                    l.add(nums[right]);
                    ans.add(l);
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums = {-1,0,1,2,-1,-4};
        ThreeNum threeNum = new ThreeNum();
        List<List<Integer>> ans = threeNum.threeSum(nums);
        System.out.println(ans);
    }
}
